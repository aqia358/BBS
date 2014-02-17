package bbs.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class AuthInterceptor implements Interceptor{

	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before action invoking");
		ai.invoke();
		System.out.println("After action invoking");
	}

}
