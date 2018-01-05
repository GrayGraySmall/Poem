package poem.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 用户好友表 dbo.Friends
 * 
 * @author zephyr
 *
 */
@Component("friends")
public class Friends {
	private String userName;// 用户编号
	private String makeUserName;// 关注编号
	private Date makeTime;// 关注时间

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMakeUserName() {
		return makeUserName;
	}

	public void setMakeUserName(String makeUserName) {
		this.makeUserName = makeUserName;
	}

	public Date getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}

	public Friends(String userName, String makeUserName, Date makeTime) {
		super();
		this.userName = userName;
		this.makeUserName = makeUserName;
		this.makeTime = makeTime;
	}

	public Friends() {
		super();
	}
}
