package bbs.controller;

import java.util.ArrayList;
import java.util.List;

import bbs.model.Session;
import bbs.model.Topic;
import bbs.model.User;

import com.jfinal.core.Controller;

public class IndexController extends Controller{

	public void index(){
		List<Session> list = Session.dao.find("select * from session");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).getStr("name"));
		}
		List<Topic> topics = Topic.dao.find("select * from topic order by clickCount desc");
		List<User> users = User.dao.find("SELECT u.* FROM USER u, topic t WHERE u.id = t.userId ORDER BY t.clickCount DESC"); 
		setAttr("users", users);
		setAttr("sessions", list);
		setAttr("topics", topics);
		render("home/home.html");
	}
	
	public void test() {
		render("add.html");
	}
}
