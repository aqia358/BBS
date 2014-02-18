package bbs.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * user model.
 */
@SuppressWarnings("serial")
public class Session extends Model<Session> {
	public static final Session dao = new Session();
}
