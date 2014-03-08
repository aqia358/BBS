package bbs.controller;

import com.jfinal.core.Controller;

public class AdminController extends Controller{

	public void index(){
		System.out.println(getPara());
		renderText(""+Math.round(Math.random()*30));
	}
	
	public void method(){
		renderText("Admin controller method");
	}
	
}
