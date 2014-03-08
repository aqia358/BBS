package bbs.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import bbs.config.Util;
import bbs.interceptor.AuthInterceptor;
import bbs.model.Reply;
import bbs.model.Topic;
import bbs.model.User;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.upload.UploadFile;

public class BlogController extends Controller{

	public void index(){
		int id = getParaToInt(0);
		int page = getParaToInt(1);
		Topic topic = Topic.dao.findById(id);
		long count = (int) (topic.getLong("clickCount")+1);
		topic.set("clickCount", count);
		topic.update();
//		Db.update("update topic set clickCount = "+topic.get("clickCount")+" where id = "+id);
		User user = User.dao.findById(topic.get("userId"));
		String limit = " limit "+page*10 +" ,10";
		List<Reply> total = Reply.dao.find("select * from reply where topicId = " + id);
		List<Reply> replys = Reply.dao.find("select * from reply where topicId = "+id+ limit);
		List<User> users = User.dao.find("SELECT u.* FROM USER u, reply r WHERE r.userId = u.id AND r.topicId = "+id+" ORDER BY r.replyTime"+limit);
		setAttr("page", page);
		setAttr("total",total.size()/10+1);
		setAttr("topic", topic);
		setAttr("user", user);
		setAttr("replys", replys);
		setAttr("users", users);
		render("blog.html");
	}
	@Before(AuthInterceptor.class)
	public void add() {
	}

	public void gotoAdd() {
		render("add.html");
	}
	
	@Before(AuthInterceptor.class)
	public void save() throws IOException {
		UploadFile f = getFile("img", Util.IMG_URL);
		User u = getSessionAttr("user");
		Topic topic = getModel(Topic.class);
		topic.set("userId", u.get("id"));
		if(topic.get("subtitle") == null)
			topic.set("subtitle", "-1");
		topic.set("img", f.getFile().getName());
		topic.set("createTime", new Timestamp(new Date().getTime()));
		topic.set("clickCount", 0);
		topic.set("replyCount", 0);
		topic.save();
		renderText("success");
	}
	
	@Before(AuthInterceptor.class)
	public void reply() {
		int id = getParaToInt();
		User u = getSessionAttr("user");
		Reply reply = getModel(Reply.class);
		reply.set("replyTime", new Timestamp(new Date().getTime()));
		reply.set("topicId", id);
		reply.set("userId", u.get("id"));
		Topic t = Topic.dao.findById(id);
		long count = (int) (t.getLong("replyCount")+1);
		t.set("replyCount", count);
		t.update();
//		Topic.dao.find("update topic set replyCount = "+t.getInt("replyCount")+1+" where id = "+id);
		System.out.println(reply.get("content")+""+reply.get("topicId"));
		reply.save();
		renderText("success");
	}
	
	public void replyCount(){
		
	}
/**************************************************************/	
	public void dajia() {
		render("dajiablog.html");
	}
	
	public void html() {
		renderHtml("<a href=''>hello</a>");
	}
	
	public void test() {
		String s = getSessionAttr("user");
		renderHtml(s);
	}
}
