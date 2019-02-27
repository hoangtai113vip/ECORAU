package com.example.interceptor.interceptor;



import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.interceptor.contant.Constant;
import com.example.interceptor.model.User;
import com.example.interceptor.service.GroupPermissionService;
import com.example.interceptor.service.UserGroupService;
import com.example.interceptor.service.UserService;

import lombok.Setter;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	@Setter
	UserService userService;

	@Autowired
	@Setter
	UserGroupService userGroupService;

	@Autowired
	@Setter
	GroupPermissionService groupPermissionService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// this.userRepository = new UserRepository();
		boolean forceLogin = true;
		String uri = request.getRequestURI();
		Set<String> set = Constant.NO_AUTHORIZATION;
		for (String url : set) {
			if (uri.endsWith(url)) {
				return true;

			}

		}
		String accessToken = request.getHeader(Constant.ACCESS_TOKEN_KEY);

		Method handlerMethod = ((HandlerMethod) handler).getMethod();

		String featureName = Constant.METHOD_FEATURES.get(handlerMethod);

		User user = userService.findUserbyAccessToken(accessToken);
		 if (user == null) {
				response.getWriter().write("chua login");
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return false;
			}
		if(userService.checkIsAdmin(user))
		{
			return true;
		}
		if (user != null) {
			if (featureName != null) {
				List<Integer> idGroups = userGroupService.findGroupIdByUser(user);
				forceLogin = groupPermissionService.checkPermission(idGroups, featureName);

			} else {
				
				response.getWriter().write("ko co quyen");
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return false;
			}
		}

		if (forceLogin==false) {
			response.getWriter().write("not authorization");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;
		}
		return forceLogin;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
	}

}