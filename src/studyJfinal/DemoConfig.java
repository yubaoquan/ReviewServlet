package studyJfinal;

import model.User;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import controller.HelloController;

public class DemoConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.FREE_MARKER);
		me.setUploadedFileSaveDirectory("sth");
	}

	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);//controller key 默认成为freemarker的模板文件存放路径
	}

	public void configPlugin(Plugins me) {
//		testDB(me);
	}

	private void testDB(Plugins me) {
		//		C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/test", "root", "root");OK
				C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://192.168.42.26/test", "root", "!26mysqlrichifo!@#");//Exception
				me.add(cp);
				ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
				me.add(arp);
		//		arp.addMapping("user", User.class);
				arp.addMapping("ForTest", User.class);
	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}
