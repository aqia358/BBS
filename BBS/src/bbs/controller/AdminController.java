package bbs.controller;

import com.jfinal.core.Controller;

public class AdminController extends Controller{

	public void index(){
		renderText("admin controller index");
	}
	
	public void method(){
		renderText("Admin controller method");
	}
}
