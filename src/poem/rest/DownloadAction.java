package poem.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 这是网上找到的代码，所以是这样的
 * 
 * @author zephyr
 *
 */
@Controller
public class DownloadAction {
	/**
	 * * @Description 下载文件 * @author zhangyd * @date 2015年12月11日 下午6:11:33
	 * * @param fileName * @param file * @return * @throws IOException
	 */
	@RequestMapping("downloadfile/{src}")
	public String download(@PathVariable("src") String src, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (src == null) {
			return null;
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName=" + "test");
		String filepath = System.getProperty("Poem.root") + src;
		InputStream inputStream = new FileInputStream(new File(filepath));
		OutputStream os = response.getOutputStream();
		byte[] b = new byte[2048];
		int length;
		while ((length = inputStream.read(b)) > 0) {
			os.write(b, 0, length);
		}
		// 这里主要关闭。
		os.close();
		inputStream.close();
		return null;
	}
}
