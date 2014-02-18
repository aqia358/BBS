package bbs.controller;

import bbs.model.User;

import com.jfinal.core.Controller;

public class BlogController extends Controller{

	public void index(){
		int id = getParaToInt(0);
		System.out.println("blog say hello "+id);
		renderText("Blog controller index "+id);
	}
	
	public void method() {
		renderText("Blog controller method");
	}
	
	public void html() {
		renderHtml("<a href=''>hello</a>");
	}
	
	public void test() {
		renderText("asdf");
	}
	public void add() {
		new User().set("name", "join").set("password", "11111").save();
		User u = User.dao.findById(1);
		System.out.println(u.getStr("name"));
		renderHtml("<a href=''>hello</a>");
	}
}
