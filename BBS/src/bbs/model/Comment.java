package bbs.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * user model.
 */
@SuppressWarnings("serial")
public class Comment extends Model<Comment> {
	public static final Comment dao = new Comment();
}
