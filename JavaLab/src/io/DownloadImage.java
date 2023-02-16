package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImage {

	public static void main(String[] args) throws MalformedURLException {
		//https://attach.mobile01.com/attach/202301/mobile01-0acf1e264cdef125a277bb57604d0766.jpg
		//網址不能有中文, MalformedURLException 
		URL url = new URL("https://attach.mobile01.com/attach/202301/mobile01-0acf1e264cdef125a277bb57604d0766.jpg");
		
	try(	InputStream is =url.openStream();
			FileOutputStream fos = new FileOutputStream("C:\\java\\a.jpg");
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(fos)
					
			){
			
			//
			byte[] buffer = new byte[1024];
			int length;
			while ((length = bis.read(buffer)) != -1) {
				System.out.println(length);//對方也是用Buffer傳
				bos.write(buffer, 0, length);//沒有東西時網站會回傳-1
			}
				
			System.out.println("done,下載完成 ");
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		
	}

}
