package bbs.config;

import bbs.interceptor.AuthInterceptor;
import bbs.model.Reply;
import bbs.model.Session;
import bbs.model.Topic;
import bbs.model.User;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class BBSConfig extends JFinalConfig {

	public void configConstant(Constants me) {
		me.setBaseViewPath("/pages");//配置全部模板的基础路径
		me.setDevMode(true);
//		me.setViewType(ViewType.JSP);// ������ͼ����ΪJSP
		me.setUrlParaSeparator("_");// ����URL����ָ�

	}

	@Override
	public void afterJFinalStart() {
		// TODO Auto-generated method stub
		super.afterJFinalStart();
	}

	@Override
	public void beforeJFinalStop() {
		// TODO Auto-generated method stub
		super.beforeJFinalStop();
	}

	public void configRoute(Routes me) {

		// me.add("/hello", HelloController.class);
		me.add(new AdminRoutes());
		me.add(new FrontRoutes());
	}

	public void configPlugin(Plugins me) {
		// loadPropertyFile("database_config.txt");
		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/bbs", "root", "tiger");
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
		arp.addMapping("reply", Reply.class);
		arp.addMapping("session", Session.class);
		arp.addMapping("topic", Topic.class);
		arp.addMapping("user", User.class);
	}

	public void configInterceptor(Interceptors me) {
		me.add(new AuthInterceptor());// Global����9����
	}

	public void configHandler(Handlers me) {
	}

}
