package bbs.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * user model.
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
	public static final User dao = new User();
}
