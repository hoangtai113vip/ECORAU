package com.example.freetuts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.freetuts.service.SinhVienService;

@Controller
public class GreetingController {
	@Autowired
	SinhVienService sv;
    @GetMapping("/greeting")
    public String greeting( Model model) {
        
    	
    	model.addAttribute("sinhvien", sv.getSinhvien(1));
        return "greeting";
    }

}