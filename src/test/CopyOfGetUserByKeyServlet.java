package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/TestGetUserByKeyServlet")
public class CopyOfGetUserByKeyServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse resp){
		try {
			String data = printRequestXML(req.getInputStream());
			responseData(resp, data);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}


	private void responseData(HttpServletResponse resp, String data)
			throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("data:" + data);
		writer.flush();
	}
	
	
	public static String printRequestXML(InputStream is) {
		String dataStr = "";
		ByteArrayOutputStream byteArrayOutputStream = null;
		byte[] byteArray = new byte[4096];
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			int i = 0;
			while ((i = is.read(byteArray)) != -1) {
				byteArrayOutputStream.write(byteArray, 0, i);
			}
			dataStr = byteArrayOutputStream.toString();
			System.out.println("TestGetUserByKeyServlet:request data: "+dataStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dataStr;
	}
}
