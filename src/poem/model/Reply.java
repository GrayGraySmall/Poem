package poem.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 用户回帖表
 * 
 * @author zephyr
 *
 */
@Component("reply")
public class Reply {
	private String userName;// 回复用户
	private int poemId;// 回帖的id
	private String replyContent;// 回复内容
	private Date replyTime;
	private int replyId;

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public Reply(String userName, int poemId, String replyContent, Date replyTime, int replyId) {
		super();
		this.userName = userName;
		this.poemId = poemId;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replyId = replyId;
	}

	public Reply() {
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

}
