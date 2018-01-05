package poem.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import poem.model.DataAndUser;
import poem.model.UpData;
import poem.service.updataService;
import poem.utils.DateUtils;

@MultipartConfig
@Controller
public class DataRest {
	@Autowired
	private updataService updataService;

	/**
	 * 资料上传
	 * 
	 * @param uploadFile
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/fileUpLoad" })
	public String fileUpload(MultipartFile uploadFile, HttpServletRequest request, HttpSession session) {
		System.out.println(System.getProperty("Poem.root"));
		String uploadPath = System.getProperty("Poem.root") + File.separator + "uploads" + File.separator
				+ uploadFile.getOriginalFilename();
		String path = File.separator + "uploads" + File.separator + uploadFile.getOriginalFilename();
		System.out.println(path);
		try {
			FileOutputStream fs = new FileOutputStream(uploadPath);
			fs.write(uploadFile.getBytes());
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
		// 获取参数
		String dataTitle = request.getParameter("data_title");
		String intro = request.getParameter("date_content");
		String kindName = request.getParameter("data_kind");
		String userName = (String) session.getAttribute("userName");// 通过session获取时间
		// 获取文件大小
		long size = uploadFile.getSize();
		System.out.println(userName + "-->" + kindName + size);
		// 设置时间
		String date = DateUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"); // 获取服务器当前时间,并格式化
		java.sql.Date upTime = new java.sql.Date(DateUtils.strToDate(date, "yyyy-MM-dd HH:mm:ss").getTime());
		UpData data = new UpData(-1, dataTitle, upTime, intro, size, kindName, userName, path);
		if (updataService.addData(data) == -1) {
			return "/error";
		}
		return "/success";
	}

	/**
	 * 请求资料
	 * 
	 * @param title
	 * @return
	 */
	@RequestMapping(value = { "queryData/{title}" }, method = RequestMethod.GET)
	public @ResponseBody UpData[] selectAllDatas(@PathVariable("title") String title) {
		System.out.println("queryData---->请求资料信息");
		return updataService.selectUpDatas(title);
	}

	/**
	 * 删除帖子
	 * 
	 * @param dataId
	 * @return
	 */
	@RequestMapping(value = { "deleteData/{dataId}" }, method = RequestMethod.GET)
	public @ResponseBody int deleteData(@PathVariable("dataId") int dataId) {
		return updataService.deleteData(dataId);
	}
	
	/**
	 * 删除帖子
	 * 
	 * @param dataId
	 * @return
	 */
	@RequestMapping(value = { "showData/{upId}" }, method = RequestMethod.GET)
	public @ResponseBody DataAndUser delectDataById(@PathVariable("upId") int upId) {
		return updataService.selectDataById(upId);
	}
}
