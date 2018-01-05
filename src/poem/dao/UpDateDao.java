package poem.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import poem.model.DataAndUser;
import poem.model.UpData;
import poem.utils.JsonUtils;

@Repository
public class UpDateDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 资料上传
	 * 
	 * @param data
	 * @return
	 */
	public int addData(UpData data) {
		String sql = "insert into dbo.UpData(kindName, userName, dataTitle, upTime, intro, size, src) values(?, ?, ?, ?, ?, ?, ?)";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { data.getKindName(), data.getUserName(), data.getDataTitle(),
					data.getUpTime(), data.getIntro(), data.getSize(), data.getSrc() });
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("datadao+addData->出错了");
			return -1;
		}
		return ret;
	}

	/**
	 * 查找资料
	 * 
	 * @param userName
	 * @return
	 */
	public UpData[] selectAllData(String title) {
		String sql = "select * from dbo.UpData";
		if (title.equals("-1") == false) {
			sql += " where dataTitle like '%" + title + "%'";
		}
		List<UpData> datas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UpData.class));
		if (datas.size() == 0) {
			return null;
		}
		System.out.println("selectAllData--------->" + JsonUtils.objectToJson(datas));
		return datas.toArray(new UpData[0]);
	}

	/**
	 * 删除资料
	 * 
	 * @param dataId
	 * @return
	 */
	public int deleteData(int dataId) {
		String sql = "delete from dbo.UpData where upId = ?";
		int ret = -1;
		try {
			ret = jdbcTemplate.update(sql, new Object[] { dataId });
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("deleteData-------->删除出错");
			return -1;
		}
		return ret;
	}

	/**
	 * 根据id请求资料信息
	 * 
	 * @param upId
	 * @return
	 */
	public DataAndUser selectDataById(int upId) {
		String sql = "select UpData.userName,  dataTitle, upTime, UpData.intro, size, src, userIcon "
				+ "from dbo.UpData, dbo.PoemUser where upId = ? and PoemUser.userName = UpData.userName";
		List<DataAndUser> datas = jdbcTemplate.query(sql, new Object[] { upId },
				BeanPropertyRowMapper.newInstance(DataAndUser.class));
		if (datas.size() == 0) {
			return null;
		}
		System.out.println(JsonUtils.objectToJson(datas));
		return datas.get(0);
	}
}
