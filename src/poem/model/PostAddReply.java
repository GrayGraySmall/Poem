package poem.model;

import java.sql.Date;

/**
 * 多表查询+回复数量
 * 
 * @author zephyr
 *
 */
public class PostAddReply {
	private int poemId;// 帖子id
	private String kindName;// 类型
	private Date publishTime;// 发布时间
	private String poemTitle;// 发布名称
	private String userName;// 发帖用户
	private String preContent;
	private int reply;// 回复数量
	private int fine;

	public PostAddReply(int poemId, String kindName, Date publishTime, String poemTitle, String userName,
			String preContent, int reply, int fine) {
		super();
		this.poemId = poemId;
		this.kindName = kindName;
		this.publishTime = publishTime;
		this.poemTitle = poemTitle;
		this.userName = userName;
		this.preContent = preContent;
		this.reply = reply;
		this.fine = fine;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public PostAddReply() {
		super();
	}

	public int getPoemId() {
		return poemId;
	}

	public void setPoemId(int poemId) {
		this.poemId = poemId;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPoemTitle() {
		return poemTitle;
	}

	public void setPoemTitle(String poemTitle) {
		this.poemTitle = poemTitle;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPreContent() {
		return preContent;
	}

	public void setPreContent(String preContent) {
		this.preContent = preContent;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

}
