package Midterm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class JavaIO extends Url implements Address {


	//從網址產生BufferedInputStream物件
	public static BufferedInputStream urlInput(String dburl) throws IOException {

		URL url = new URL(dburl);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		return bis;
	}
	
	
	//將位址String轉成BufferedOutputStream物件
	public static BufferedOutputStream downloadDestination(String dest) throws FileNotFoundException {

		FileOutputStream fos = new FileOutputStream(dest);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		return bos;

	}

	//用Byte陣列下載
	public static void Download(BufferedInputStream bis, BufferedOutputStream bos) throws IOException {

		byte[] buffer = new byte[1024];
		int length;
		while ((length = bis.read(buffer)) != -1) {

			bos.write(buffer, 0, length);

		}
		System.out.println("done,下載完成 ");

	}
	
	//從位置產生BufferedInputStream物件
	public static BufferedInputStream fileInput(String read) throws FileNotFoundException {
		
		FileInputStream fis = new FileInputStream(read);
		BufferedInputStream bis = new BufferedInputStream(fis);
		return bis;
		
	}
	
	
	//用BufferedInputStream物件編碼成ms950轉出成BufferedReader
	public static BufferedReader Reader(BufferedInputStream bis) throws UnsupportedEncodingException {
		
		InputStreamReader isr = new InputStreamReader(bis,"ms950");
		BufferedReader br = new BufferedReader(isr);
		return br;
		
	}
	
	
	//傳回副檔名字串的方法
	public static String findExtension(File file) {
		String FileName = file.toString();
		int index = FileName.lastIndexOf(".");
		String extension ="";
	    if(index > 0) {
		extension = FileName.substring(index + 1);
	    }
	    return extension;
		
		
		
	}
	
	
}
