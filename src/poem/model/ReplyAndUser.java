package poem.model;

import java.sql.Date;

/**
 * 用户回复详细信息，包括回复信息和用户的信息
 * @author zephyr
 *
 */
public class ReplyAndUser {
	private String userName;
	private int poemId;
	private String replyContent;
	private Date replyTime;
	private int replyId;
	private String userIcon;

	public ReplyAndUser(String userName, int poemId, String replyContent, Date replyTime, int replyId,
			String userIcon) {
		super();
		this.userName = userName;
		this.poemId = poemId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyId = replyId;
		this.userIcon = userIcon;
	}

	public ReplyAndUser() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPoemId() {
		return poemId;
	}

	public void setPoemId(int poemId) {
		this.poemId = poemId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

}
