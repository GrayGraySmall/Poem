package poem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poem.dao.KindDao;

@Service
public class KindService {
	@Autowired
	private KindDao kindDao;

	/**
	 * 查询所有的用户类型
	 * @return
	 */
	public String[] selectAllKind() {
		return kindDao.selectAllKind();
	}
}
