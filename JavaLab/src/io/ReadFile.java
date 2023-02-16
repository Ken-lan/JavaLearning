package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//ctrl+shift+0 清除Import
public class ReadFile {

	public static void main(String[] args) {
		// JDBC
		try (FileInputStream fis = new FileInputStream("C:\\Java\\io_1.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);) {

			System.out.println(bis.available());
			int b = bis.read();// 讀一個byte
			char c = (char) b;
			System.out.println("byte值" + b + ",文字" + c);
			System.out.println(bis.available());

			while ((b = bis.read()) != -1) {
				c = (char) b;
				System.out.println("byte值" + b + ",文字" + c);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
//		}finally {
//			//fis cannot be resolved
//			//Unhandled exception type IOException
//			//The local variable fis may not have been initialized
//			try {
//				if(fis != null) {//不檢查會有NullPointException
//				fis.close();//如果沒有close,其他程式可能無法對這個檔案做任何修改或刪除
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//		}

	}

}
