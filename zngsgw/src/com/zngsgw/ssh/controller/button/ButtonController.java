package com.zngsgw.ssh.controller.button;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zngsgw.ssh.service.button.ButtonServiceI;

@Controller
@RequestMapping("/button")
public class ButtonController {
	@Resource
	private ButtonServiceI buttonService;
	
	@RequestMapping(params="getButton")
	public ModelAndView getButton(){
		return new ModelAndView();
	}
}
