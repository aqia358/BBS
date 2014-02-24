package bbs.interceptor;

import bbs.model.User;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class AuthInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before action invoking auth");
		User u = ai.getController().getSessionAttr("user");
		if(u == null)
			ai.getController().renderText("authfail");
		else
			ai.invoke();
		System.out.println("After action invoking");
	}

}
