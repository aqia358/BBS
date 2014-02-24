package bbs.config;

import bbs.controller.*;

import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
		add("/blog", BlogController.class);
		add("/user", UserController.class);
	}

}
