package poem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poem.dao.UpDateDao;
import poem.model.DataAndUser;
import poem.model.UpData;

@Service
public class updataService {
	@Autowired
	private UpDateDao upDateDao;
	
	/**
	 * 增加上传的资料
	 * @param upData
	 * @return
	 */
	public int addData(UpData upData) {
		return upDateDao.addData(upData);
	}
	
	/**
	 * 请求资料
	 * @param title
	 * @return
	 */
	public UpData[] selectUpDatas(String title) {
		return upDateDao.selectAllData(title);
	}
	
	/**
	 * 删除资料
	 * @param dataId
	 * @return
	 */
	public int deleteData(int dataId){
		return upDateDao.deleteData(dataId);
	}
	
	/**
	 * 根据编号查找data
	 * @param upId
	 * @return
	 */
	public DataAndUser selectDataById(int upId) {
		return upDateDao.selectDataById(upId);
	}
}
