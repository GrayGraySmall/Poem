package poem.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KindDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * 查找所有的种类
	 * @return
	 */
	public String[] selectAllKind() {
		String sql = "select kindName from dbo.PomeKind";
		List<String> kindStr = jdbcTemplate.queryForList(sql, String.class);
		return kindStr.toArray(new String[0]);
	}
}
