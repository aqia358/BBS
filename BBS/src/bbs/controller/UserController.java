package bbs.controller;

import java.util.List;

import bbs.model.User;
import bbs.validator.LoginValidator;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class UserController extends Controller{

	public void index() {
		render("login.html");
	}
	
	@Before(LoginValidator.class)
	public void login() {
		User  u = getModel(User.class);
		System.out.println(u.getStr("name")+u.getStr("password"));
		String sql = "select * from user where name = '"+u.getStr("name")+"' and password = '"+u.getStr("password")+"'";
		List<User> users = User.dao.find(sql);
		if(users.size() == 0){
			renderText("fail");
		}else{
			setSessionAttr("user", users.get(0));
			renderText("success");
		}
	}
}
