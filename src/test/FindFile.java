package test;

import static java.lang.System.out;

import java.io.File;
import java.net.URL;

public class FindFile {
	public static void main(String[] args) {
		File file ;
		URL url= ClassLoader.getSystemResource("Date.txt");
		String path = url.getFile();
		out.println(path);
//		FindFile.class.getResourceAsStream(name);
//		ClassLoader.getSystemResourceAsStream(name);
	}
}
