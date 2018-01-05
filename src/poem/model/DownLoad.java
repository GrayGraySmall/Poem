package poem.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * dbo.DownLoad的model 用户下载上传的文件时，相关联
 * 
 * @author zephyr
 *
 */
@Component("downLoad")
public class DownLoad {
	private String userName; // 用户名
	private int upId; // 文件编号
	private Date downTime; // 下载时间

	public Date getDownTime() {
		return downTime;
	}

	public void setDownTime(Date downTime) {
		this.downTime = downTime;
	}

	public int getUpId() {
		return upId;
	}

	public void setUpId(int upId) {
		this.upId = upId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public DownLoad(String userName, int upId, Date downTime) {
		super();
		this.userName = userName;
		this.upId = upId;
		this.downTime = downTime;
	}

	public DownLoad() {
		super();
	}

}
