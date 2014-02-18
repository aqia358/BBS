package bbs.controller;

import java.util.List;

import bbs.model.Session;

import com.jfinal.core.Controller;

public class IndexController extends Controller{

	public void index(){
		List<Session> list = Session.dao.find("select * from session");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getStr("name"));
		}
		setAttr("sessions", list);
		render("home/home.html");
	}
	
	public void test() {
		render("test.html");
	}
}
