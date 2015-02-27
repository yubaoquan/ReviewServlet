package controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import model.User;
import aop.interceptors.SomeInterceptor;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import freemarker.template.Configuration;


public class HelloController extends Controller {
	
	public void index() {
		renderText("Hello JFinal World.");
	}
	
	@ActionKey("somemethod")
	
	public void someMethod() {
//		setTemplateLocation();
		setAttr("name", "dengqinglin");
		renderFreeMarker("free.html");
	}
	
	@ActionKey("db")
	public void testDB() {
		//for localhost
//		User user = User.dao.findById(1, "name");
//		renderText("data in database:" + user.getStr("name"));
		//for 192.168.42.26
		User user = User.dao.findById(1, "qword_id");
		renderText("data in database:" + user.getStr("qword_id"));
		
	}
	
	@ActionKey("upload")
	public void upload() {
		UploadFile f = this.getFile();
		long size = f.getFile().length();
		StringBuffer sb = new StringBuffer();
		sb.append("文件长度:").append(size);
		sb.append("\n绝对路径:").append(f.getFile().getAbsolutePath());
		sb.append("\nsavedir:").append(f.getSaveDirectory());
		renderText(sb.toString());
		
	}
	
	@ActionKey("test_upload") 
	public void testUpload() {
		render("upload.html");
	}
	
}