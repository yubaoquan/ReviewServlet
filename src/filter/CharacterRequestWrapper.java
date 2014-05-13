package filter;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterRequestWrapper extends HttpServletRequestWrapper {

	private Map<String, String> escapeMap;
	public CharacterRequestWrapper(HttpServletRequest request, Map<String, String>escapeMap) {
		super(request);
		this.escapeMap = escapeMap;
	}

	public String getParameter(String name) {
		return doEscape(this.getRequest().getParameter(name));
	}
	
	private String doEscape(String parameter) {
		if (parameter == null) {
			return null;
		}
		String result = parameter;
		Iterator<String> iterator = escapeMap.keySet().iterator();
		while (iterator.hasNext()) {
			String origin = iterator.next();
			String escape = escapeMap.get(origin);
			System.out.println(origin + "-->" + escape);
			result = result.replaceAll(origin, escape);
		}
		return result;
	}
}
