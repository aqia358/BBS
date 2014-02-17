package bbs.config;

import bbs.controller.AdminController;

import com.jfinal.config.Routes;

public class AdminRoutes extends Routes{

	@Override
	public void config() {
		add("/admin", AdminController.class);
	}

}
