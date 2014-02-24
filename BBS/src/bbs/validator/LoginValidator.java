/*
 * Word Union : Powered By [zlg]
 * Web Site: http://www.younghold.com
 * Since 2010 - 2013
 */


package bbs.validator;

import bbs.model.User;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * AuthorValidator.
 */
public class LoginValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequired("user.name", "user.name", "username不能为空!");
		validateRequired("user.password", "user.password", "password不能为空!");
		System.out.println("login validator");
	}
	
	protected void handleError(Controller controller) {
//		controller.keepModel(User.class);
//		controller.setAttr("infoType","error");
//		String actionKey = getActionKey();
//		if (actionKey.equals("/classroom_comments/save"))
//			controller.render("add.html");
//		else if (actionKey.equals("/classroom_comments/update"))
//			controller.render("edit.html");
		controller.renderText("handle error");
	}
}
