package bbs.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class HelloController extends Controller {

	public void index() {
		renderText("Hello JFinal World.");
	}
	
	public void method() {
		renderText("by method name");
	}
	
	@ActionKey("/with")
	public void with() {
		String s = getPara(0);
		String s2 = getPara(1);
		String str = "hello "+s+s2;
		renderText("method with param:"+str);
	}
}