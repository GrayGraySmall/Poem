package poem.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * dbo.PoemPosts 用户发帖
 * 
 * @author zephyr
 *
 */
@Component("poemPosts")
public class PoemPosts {
	private int poemId;// 帖子id
	private String kindName;// 类型
	private Date publishTime;// 发布时间
	private String poemTitle;// 发布名称
	private String poemContent;// 发布内容
	private String userName;// 发帖用户
	private String preContent;
	private int fine;// 是否加精

	public PoemPosts(int poemId, String kindName, Date publishTime, String poemTitle, String poemContent,
			String userName, String preContent, int fine) {
		super();
		this.poemId = poemId;
		this.kindName = kindName;
		this.publishTime = publishTime;
		this.poemTitle = poemTitle;
		this.poemContent = poemContent;
		this.userName = userName;
		this.preContent = preContent;
		this.fine = fine;
	}

	public PoemPosts() {
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

	public String getPoemContent() {
		return poemContent;
	}

	public void setPoemContent(String poemContent) {
		this.poemContent = poemContent;
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

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}
}
