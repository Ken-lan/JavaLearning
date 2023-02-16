package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		
		try(FileOutputStream fos = new FileOutputStream("C:\\Java\\io_2.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos)){
			
			String content = "Java 好好玩";
			byte[] bytes = content.getBytes();//文字轉byte
			fos.write(bytes);
			System.out.println("done");
					
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
