package poem.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import poem.model.UpData;
import poem.service.UserService;
import poem.utils.DateUtils;

@MultipartConfig
@Controller
public class IconRest {
	@Autowired
	private UserService userService;

	/**
	 * 资料上传
	 * 
	 * @param uploadFile
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/iconUpLoad" })
	public String fileUpload(MultipartFile uploadFile, HttpServletRequest request, HttpSession session) {
		System.out.println(System.getProperty("Poem.root"));
		String uploadPath = System.getProperty("Poem.root") + File.separator + "resources" + File.separator + "img"
				+ File.separator + uploadFile.getOriginalFilename();
		String path = "resources" + File.separator + "img" + File.separator
				+ uploadFile.getOriginalFilename();
		System.out.println(path);
		try {
			FileOutputStream fs = new FileOutputStream(uploadPath);
			fs.write(uploadFile.getBytes());
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}
		String userName = (String) session.getAttribute("userName");// 通过session获取时间
		if (userService.updateIcon(userName, path) == -1) {
			return "/error";
		}
		return "/success";
	}
}
