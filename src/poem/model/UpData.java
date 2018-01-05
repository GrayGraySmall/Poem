package poem.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

/**
 * 上传资料
 * 
 * @author zephyr
 *
 */
@Component("upData")
public class UpData {
	private int upId;// 上传id
	private String dataTitle;// 资料标题
	private Date upTime;// 上传时间
	private String intro;// 上传简介
	private long size;// 资料大小
	private String kindName;
	private String userName;
	private String src;

	public UpData(int upId, String dataTitle, Date upTime, String intro, long size, String kindName, String userName,
			String src) {
		super();
		this.upId = upId;
		this.dataTitle = dataTitle;
		this.upTime = upTime;
		this.intro = intro;
		this.size = size;
		this.kindName = kindName;
		this.userName = userName;
		this.src = src;
	}

	public UpData() {
		super();
	}

	public int getUpId() {
		return upId;
	}

	public void setUpId(int upId) {
		this.upId = upId;
	}

	public String getDataTitle() {
		return dataTitle;
	}

	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

}
