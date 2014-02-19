package bbs.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import bbs.config.Util;
import bbs.model.Topic;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class BlogController extends Controller{

	public void index(){
		render("add.html");
	}
	
	public void save() throws IOException {
		File ff = new File("");
		UploadFile f = getFile("img", Util.IMG_URL);
		Topic topic = getModel(Topic.class);
		topic.set("img", f.getFile().getName());
		topic.set("createTime", new Timestamp(new Date().getTime()));
		topic.save();
		renderText("success");
	}
	
	public void img() {
		render("img.html");
	}
	
	public void html() {
		renderHtml("<a href=''>hello</a>");
	}
	
	public void test() {
		renderText("asdf");
	}
}
