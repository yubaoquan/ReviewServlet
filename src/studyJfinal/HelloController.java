package studyJfinal;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.Render;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class HelloController extends Controller {
	public void index() {
		renderText("Hello JFinal World.");
	}
	
	@ActionKey("somemethod")
	public void someMethod() {
		setAttr("name", "dengqinglin");
		renderFreeMarker("free.html");
	}
}