package bbs.config;

import bbs.controller.BlogController;
import bbs.controller.IndexController;

import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
		add("/blog", BlogController.class);
	}

}
