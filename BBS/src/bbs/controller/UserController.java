package bbs.controller;

import java.sql.Timestamp;
import java.util.Date;
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
			renderText("login_fail");
		}else{
			setSessionAttr("user", users.get(0));
			redirect("/0_0");
		}
	}
	
	public void logout() {
//		setSessionAttr("user",null);
		removeSessionAttr("user");
		User u = getSessionAttr("user");
		if(u == null){
			System.out.println("success");
			renderText("退出成功");
		}else{
			System.out.println("fail");
			renderText("退出失败");
		}
	}
	
	public void register() {
		render("register.html");
	}
	public void save(){
		getFile();
		User u = getModel(User.class);
		u.set("lastDate", new Timestamp(new Date().getTime()));
		u.save();
		redirect("/0_0");
	}
}
