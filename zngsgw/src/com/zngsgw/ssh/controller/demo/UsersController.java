package com.zngsgw.ssh.controller.demo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zngsgw.ssh.entity.demo.Users;
import com.zngsgw.ssh.service.demo.UsersServiceI;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Resource
	UsersServiceI usersService;

	@RequestMapping(params="list",method=RequestMethod.GET)
	public ModelAndView getAllUsersList(Model model){
		ModelAndView mv = new ModelAndView();
		
		List<Users> usersLists = usersService.findAllList();
		mv.addObject("usersLists", usersLists);
		mv.setViewName("users/list");
		return mv;
	}
	
	
	//跳转add.jsp页面
	@RequestMapping(params="toAddForm")
	public ModelAndView toAddForm(){
		System.out.println("come in!");
		return new ModelAndView("users/add");
	}

	//添加并返回list视图
	@RequestMapping(params="add",method=RequestMethod.POST)
	public ModelAndView addUsers(String useruame,String password){
		
		System.out.println("=useruame="+useruame+" , "+"password="+password);
		
		ModelAndView mv = new ModelAndView();
		Users users=new Users();
		users.setUsername(useruame);
		users.setPassword(password);
		usersService.save(users);
		
		List<Users> usersLists = usersService.findAllList();
		mv.addObject("usersLists", usersLists);
		mv.setViewName("users/list");
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
		Users users=new Users();
		users=usersService.findById(id);
		mv.addObject("users",users);
		mv.setViewName("users/updateUsers");
		return mv;
	}
	
	/**
	 * 更新用户
	 * @param users
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(params="doUpdate")
	public ModelAndView doUpdate(@Valid Users users, BindingResult result){
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			
			mv.setViewName("user/updateUser");
			return mv;
		}else{
			usersService.update(users);
			
			List<Users> usersLists = usersService.findAllList();
			mv.addObject("usersLists", usersLists);
			mv.setViewName("users/list");
			return mv;
		}
	}
	
	/**
	 * 删除用户
	 * @param request
	 * @param id
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(params="delete")
	public ModelAndView delete(HttpServletRequest request,Long id){
		if(id!=null||id!=0){
			usersService.delete(id);
			
			List<Users> usersLists = usersService.findAllList();
			request.setAttribute("usersLists", usersLists);
			return new ModelAndView("users/list");
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
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,String username,String password){
		ModelAndView mv=new ModelAndView();
		System.out.println("username="+username+",,,"+"password="+password);
		if(username.equals("")||password.equals("")){
			request.setAttribute("msg", "请输入用户名和密码！");
			mv.setViewName("login/login");
			return mv;
		}
		Users u=usersService.findByUsername(username);
		if(u!=null){
			if(u.getUsername().equals(username)&&u.getPassword().equals(password)){
				HttpSession session=request.getSession();
				session.setAttribute("currentuser", username);
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
		mv.setViewName("users/login");
		return mv;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(params="newlogin")
	public ModelAndView newlogin(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		HttpSession session=request.getSession();
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		Map attr=principal.getAttributes();
		String username=(String) attr.get("username");
		String uuid=(String)attr.get("userUUID");
		String name=(String) session.getAttribute("username");
		System.out.println(name);
		
		Users u=usersService.findByUsername(username);
		if(u!=null){
			if(username.equals(u.getUsername())&& uuid.equals(u.getUniqueId())){
				session.setAttribute("currentuser", username);
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
	}
}
