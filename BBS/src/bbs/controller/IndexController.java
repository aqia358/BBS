package bbs.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import bbs.config.Util;
import bbs.model.Topic;
import bbs.model.User;

import com.jfinal.core.Controller;

public class IndexController extends Controller{
	
	public void index(){
		int id = getParaToInt(0);
		int page = getParaToInt(1);
		System.out.println(Util.NAV[id]+page);
		String limit = " limit "+page*10 +" ,10";
//		removeSessionAttr("user");
		User u = getSessionAttr("user");
		List<Topic> total = Topic.dao.find("select * from topic where category='"+Util.NAV[id]+"'");
		List<Topic> topics = Topic.dao.find("select * from topic where category='"+Util.NAV[id]+"' order by clickCount desc "+limit);
		List<User> users = User.dao.find("SELECT u.* FROM USER u, topic t WHERE u.id = t.userId and t.category='"+Util.NAV[id]+"' ORDER BY t.clickCount DESC "+limit); 
		if(u == null)
			System.out.println("user have benn log out");
		else
			System.out.println("user have not log out");
		setAttr("my", u);
		setAttr("page",page);
		setAttr("total",total.size()/10+1);
		setAttr("nav",id);
		setAttr("users", users);
		setAttr("topics", topics);
		render("home/home.html");
	}
	
	public void logout() {
		removeSessionAttr("user");
		User u = getSessionAttr("user");
		if(u == null){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}	
		redirect("/0_0");
	}
	public void test() {
		render("add.html");
	}
	public void flag(){
		User u = User.dao.findById(1);
		if(u.get("password").equals("111111")) {
			u.set("password", "dsf");
			u.update();
			renderText("success");
		}else
			renderText("fail");
	}
	public void dangerous() throws UnsupportedEncodingException{
		String name = URLDecoder.decode(getPara(),"UTF-8");
//		String name = getPara();
		System.out.println(name);
		User u = User.dao.findById(1);
		if(u.get("password").equals(name)) {
			renderText(u.get("id").toString());
		}else
			renderText("fail");
	}
	public void avoid() throws UnsupportedEncodingException{
		String name = URLDecoder.decode(getPara(),"UTF-8");
		System.out.println("road "+name+" have been avoid");
		User u = User.dao.findById(1);
		u.set("password", name+"1");
		u.update();
		renderText("success");
	}
	public void img(){
		int id = getParaToInt();
		System.out.println(id);
		renderText("http://www.unn.com.cn/mediafile/201009/13/F201009131508423689211774.jpg");
	}
}
