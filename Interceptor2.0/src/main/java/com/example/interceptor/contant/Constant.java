package com.example.interceptor.contant;


import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.interceptor.controller.StudentController;
import com.example.interceptor.model.Student;


public final class Constant {

	public static final String ACCESS_TOKEN_KEY = "Authorization";
	public static final Map<Method, String> METHOD_FEATURES = defaultMethodFeatures();
	public static final Set<String> NO_AUTHORIZATION = defaultAuthorization();
	private Constant() {
	}
	private static Set<String> defaultAuthorization(){
		Set<String> set = new HashSet<String>();
		set.add("login");
		set.add("register");
		return set;
	}
	private static Map<Method, String> defaultMethodFeatures() {

		Map<Method, String> map = new HashMap<>();
		
		//map.put(getMethod(HelloController.class, "hello"),"HELLO_GET");
		map.put(getMethod(StudentController.class, "getAll"),"STUDENT_GET");
		map.put(getMethod(StudentController.class, "save",Student.class),"STUDENT_POST");
		
		return Collections.unmodifiableMap(map);
		
	}
	
	private static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredMethod(name, parameterTypes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
