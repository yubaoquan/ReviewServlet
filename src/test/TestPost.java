package test;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestPost {

	private static InputStream inputStream = null;
	private static OutputStream outputStream = null;
	private static ByteArrayOutputStream byteArrayOutputStream = null;
	private static byte[] data = new byte[4096];

	public static void printResult() {
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			int i = 0;
			while ((i = inputStream.read(data)) != -1) {
				byteArrayOutputStream.write(data, 0, i);
			}
			out.println("response: " + byteArrayOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStreams(inputStream, byteArrayOutputStream);
		}
	}

	public static void initStreamsPOST(String requestURL, String params,
			String cookies) throws Exception {
		URL url = new URL(requestURL);
		URLConnection connection = (HttpURLConnection) url.openConnection();

		// connection.setRequestProperty("Cookie", cookies);
		connection.setRequestProperty("accept", "*/*");
		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		//connection.setRequestMethod("POST");
		outputStream = connection.getOutputStream();
//		inputStream = connection.getInputStream();
		System.out.println("params:");
		System.out.println(params);

		PrintWriter outPrintWriter = new PrintWriter(outputStream);
		outPrintWriter.print(params);
		outPrintWriter.flush();
		inputStream = connection.getInputStream();
		out.println("init ok");
        outputStream.close();
	}

	private static void closeStreams(InputStream inputStream,
			ByteArrayOutputStream byteArrayOutputStream) {
		try {
			if (inputStream != null) {
				inputStream.close();
				inputStream = null;
			}

			if (byteArrayOutputStream != null) {
				byteArrayOutputStream.close();
				byteArrayOutputStream = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
private static final String GET_USER_BY_KEY= "http://localhost:8080/ReviewServlet/TestGetUserByKeyServlet";
	
	private static void mainTest() {
		String requestURL = GET_USER_BY_KEY;
		try {
			initStreamsPOST(requestURL, "data hahaha", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		printResult();
	}
	
	public static void main(String[] args) {
		mainTest();
//		String sr=sendPost(GET_USER_BY_KEY, "key=123&v=456789");
//        System.out.println(sr);
	}
	

    public static String sendPost(String url, String param) {
        PrintWriter out = null;
       // BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result += line;
//            }
            inputStream = conn.getInputStream();
            printResult();
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            if(out!=null){
			    out.close();
			}
//                if(in!=null){
//                    in.close();
//                }
        }
        return result;
    }    
}

