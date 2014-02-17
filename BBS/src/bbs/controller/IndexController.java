package bbs.controller;

import com.jfinal.core.Controller;

public class IndexController extends Controller{

	public void index(){
		renderText("Index controller index");
	}
	
	public void method() {
		renderText("Index controller method");
	}
}
