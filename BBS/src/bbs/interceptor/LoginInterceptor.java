package bbs.interceptor;

import bbs.model.User;

import com.jfinal.aop.Before;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class LoginInterceptor implements Interceptor{
	
	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before action invoking login auth");
		User u = ai.getController().getSessionAttr("user");
		ai.getController().setAttr("my", u);
		ai.invoke();
		System.out.println("After action invoking");
	}

}
