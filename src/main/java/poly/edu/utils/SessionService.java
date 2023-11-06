package poly.edu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
	
	@Autowired
	HttpSession session;

	//name ten Attrib
	@SuppressWarnings("unchecked")
	public <T> T get(String name) {   //doc gtri atrib trong sess
		return (T) session.getAttribute(name); //retuer gtri doc duoc hoac null k ton tai
	}
	
	// name ten Attrib
	//defaultvalue gttr mat dinh
	public <T> T get(String name, T defaultValue) { // doc gtri attrib trong sses
		T value = get(name);
		return value != null ? value : defaultValue; // gtri doc duoc hoac defau k ton tai
	}
	
	public void set(String name, Object value) { // thay doi hoac tao Attrib trong sses
		session.setAttribute(name, value);
	}
	
	public void remove(String name) {  // xoa Attri trong sses
		session.removeAttribute(name);
	}
	
	
}
