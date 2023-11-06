package poly.edu.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;
	
	//@param name tham so
	//@param defaultValue gtri mat dinh
	//...... gtri tham so hoac gtri mat dinh khong ton tai
	
	
	public String getString(String name, String defaultValue) { // doc chuoi gtri tham so
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;
	}
	
	public int getInt(String name, int defaultvalue) { // doc gtri cua tham so
		String value = getString(name, String.valueOf(defaultvalue));
		return Integer.parseInt(value);
	}
	
	public double getDouble(String name, double defaultValue) { // doc gtri so thuc cua tham so
		String value = getString(name, String.valueOf(defaultValue));
		return Double.parseDouble(value);
	}
	
	public boolean getBoolean(String name, Boolean defaultValue) { // doc gtri boolean cua tham so
		String value = getString(name, String.valueOf(defaultValue));
		return Boolean.parseBoolean(value);
	}
	
	// throws RintimeEx neu k dung dinh dang
	
	public Date getDate(String name, String pattern) {  // doc gtri thoi gian
		String value = getString(name, "");
		try {
			return new SimpleDateFormat(pattern).parse(value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public File save(MultipartFile file, String path) { // luu file upload vao thu muc
		if (!file.isEmpty()) {
			File dir = new File(request.getServletContext().getRealPath(path));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			try {
				File savedFile = new File(dir, file.getOriginalFilename());
				file.transferTo(savedFile);
				return savedFile;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
}
