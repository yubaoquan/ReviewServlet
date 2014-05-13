package filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.sun.istack.internal.logging.Logger;

/**
 * Servlet Filter implementation class CharacterFilter
 */
@WebFilter(urlPatterns = "/bookmark", initParams = { @WebInitParam(name = "ESCAPE_LIST", value = "/WEB-INF/escapelist.txt") })
public class CharacterFilter implements Filter {

	private Map<String, String> escapeMap;

	public CharacterFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CharacterFilter do filter");
		HttpServletRequest requestWrapper = new CharacterRequestWrapper((HttpServletRequest) request, escapeMap);
		chain.doFilter(requestWrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		BufferedReader reader = null;
		try {
			String escapeListFile = fConfig.getInitParameter("ESCAPE_LIST");
			System.out.println(escapeListFile);
			reader = new BufferedReader(new InputStreamReader(fConfig.getServletContext().getResourceAsStream(escapeListFile)));
			String input = null;
			escapeMap = new HashMap<>();
			while ((input = reader.readLine()) != null) {
				String[] tokens = input.split("\t");
				escapeMap.put(tokens[0], tokens[1]);

			}
		} catch (IOException ex) {
			Logger.getLogger(CharacterFilter.class).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ex) {
				Logger.getLogger(CharacterFilter.class).log(Level.SEVERE, null, ex);
			}
		}
	}

}
