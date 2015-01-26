package studyJfinal;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class HelloController extends Controller {
	public void index() {
		renderText("Hello JFinal World.");
	}
	
	@ActionKey("somemethod")
	public void someMethod() {
		renderText("some method.");
	}
}