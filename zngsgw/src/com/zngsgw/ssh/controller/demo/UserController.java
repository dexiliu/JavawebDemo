package com.zngsgw.ssh.controller.demo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zngsgw.ssh.entity.demo.User;
import com.zngsgw.ssh.service.demo.UserServiceI;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserServiceI userService;

	@RequestMapping(params="list",method=RequestMethod.GET)
	public ModelAndView getAllUserList(Model model){
		ModelAndView mv = new ModelAndView();
		
		List<User> userLists = userService.findAllList();
		mv.addObject("userLists", userLists);
		mv.setViewName("user/list");
		return mv;
	}
	
	
	//跳转add.jsp页面
	@RequestMapping(params="toAddForm")
	public ModelAndView toAddForm(){
		System.out.println("come in!");
		return new ModelAndView("user/add");
	}
//	//创建表单中使用的ModelAttribute user
//	@ModelAttribute("user")
//	public User createFormBean() {
//		return new User();
//	}
	//添加并返回list视图
	@RequestMapping(params="add",method=RequestMethod.POST)
	public ModelAndView addUser(String userName,String password){
		
		System.out.println("=userName="+userName+" , "+"password="+password);
		
		ModelAndView mv = new ModelAndView();
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		userService.save(user);
		
		List<User> userLists = userService.findAllList();
		mv.addObject("userLists", userLists);
		mv.setViewName("user/list");
		return mv;	
	}
	
	/**
	 * go to update
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(params="goUpdate")
	public ModelAndView goUpdate(Long id){
		ModelAndView mv = new ModelAndView();
		User user=new User();
		user=userService.findById(id);
		mv.addObject("user",user);
		mv.setViewName("user/updateUser");
		return mv;
	}
	
	/**
	 * 更新用户
	 * @param user
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doUpdate")
	public ModelAndView doUpdate(@Valid User user, BindingResult result){
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			
			mv.setViewName("user/updateUser");
			return mv;
		}else{
			userService.update(user);
			
			List<User> userLists = userService.findAllList();
			mv.addObject("userLists", userLists);
			mv.setViewName("user/list");
			return mv;
		}
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(params="delete")
	public ModelAndView delete(HttpServletRequest request,Long id){
		if(id!=null||id!=0){
			userService.delete(id);
			
			List<User> userLists = userService.findAllList();
			request.setAttribute("userLists", userLists);
			return new ModelAndView("user/list");
		}else{
			request.setAttribute("msg", "删除失败！");
			return new ModelAndView("common/blank");
		}
	}
	
	@RequestMapping(params="goLogin")
	public ModelAndView goLogin(){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(params="login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,String userName,String password){
		ModelAndView mv=new ModelAndView();
		System.out.println("userName="+userName+",,,"+"password="+password);
		if(userName.equals("")||password.equals("")){
			request.setAttribute("msg", "请输入用户名和密码！");
			mv.setViewName("login/login");
			return mv;
		}
		User u=userService.findByUserName(userName);
		if(u!=null){
			if(u.getUserName().equals(userName)&&u.getPassword().equals(password)){
//				List<User> userLists = userService.findAllList();
//				mv.addObject("userLists", userLists);
				HttpSession session=request.getSession();
				session.setAttribute("currentuser", userName);
				mv.setViewName("user/index");
				return mv;
			}else{
				request.setAttribute("msg", "用户名或密码错误！");
				mv.setViewName("login/login");
				return mv;
			}
		}else{
			request.setAttribute("msg", "用户名不存在！");
			mv.setViewName("login/login");
			return mv;
		}
//		if(userName.equals("admin") && password.equals("admin")){
//			HttpSession session=request.getSession();
//			session.setAttribute("currentuser", "admin");
//			mv.setViewName("user/index");
//			return mv;
//		}else{
//			request.setAttribute("msg", "用户名或密码错误！");
//			mv.setViewName("common/blank");
//			return mv;
//		}
	}
	
	@RequestMapping(params="logout")
	public ModelAndView logout(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		HttpSession session = null;
		session = request.getSession();
		session.removeAttribute("currentuser");
		mv.setViewName("user/login");
		return mv;
	}
}
