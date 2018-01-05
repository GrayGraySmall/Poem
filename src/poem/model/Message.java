package poem.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 用户私信表 dbo.Message
 * 
 * @author zephyr
 *
 */
@Component("message")
public class Message {
	private String userName; // 发送用户
	private String sendUserName;// 接收用户
	private String messContent; // 消息内容
	private Date sendTime;// 发送时间

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getMessContent() {
		return messContent;
	}

	public void setMessContent(String messContent) {
		this.messContent = messContent;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Message(String userName, String sendUserName, String messContent, Date sendTime) {
		super();
		this.userName = userName;
		this.sendUserName = sendUserName;
		this.messContent = messContent;
		this.sendTime = sendTime;
	}

	public Message() {
		super();
	}

}
