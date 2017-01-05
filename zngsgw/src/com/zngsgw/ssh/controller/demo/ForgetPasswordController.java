package com.zngsgw.ssh.controller.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zngsgw.ssh.util.SendMail;

@Controller
@RequestMapping("/forgetPassword")
public class ForgetPasswordController {

	@RequestMapping(params="toFind")
	public ModelAndView toFind(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("findpassword/find");
		return mv;
	}
	
	@RequestMapping(params="toMailBox")
	public ModelAndView toMailBox(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		String msg="邮箱发送失败！";
		SendMail sendMail=new SendMail();
		String mailBox=request.getParameter("mailBox");
		System.out.println("mailbox="+mailBox);
		if(mailBox!=""||!mailBox.equals("")){
			sendMail.setTo(mailBox);
			sendMail.setContent("http://192.168.2.122:8090/zngsgw/forgetPassword.do?findPage");
			sendMail.send();
			msg="发送邮箱成功！请登录邮箱修改密码！";
		}
		request.setAttribute("msg", msg);
		mv.setViewName("findpassword/success");
		return mv;
	}
	
	@RequestMapping(params="findPage")
	public ModelAndView findPage(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("findpassword/change");
		return mv;
	}
	
	@RequestMapping(params="changePassword")
	public ModelAndView changePassword(HttpServletRequest request,String password1){
		ModelAndView mv=new ModelAndView();
		System.out.println("new password="+password1);
		String msg="密码修改成功！";
		request.setAttribute("msg", msg);
		mv.setViewName("findpassword/success");
		return mv;
	}
}
