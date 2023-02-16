package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipException;

public class TestCheckedException {

	public static void main(String[] args) throws IOException {
		//FileNotFoundException,ZipException
		// 不是RunTimeException的子類別
		// windows上檔案路徑，區隔符號是\\，跳脫字元，c:\\java\\aaa.txt
		// Unhandled exception type FileNotFoundException
		// 一定要用try catch處理的
		// 對錯誤按ctrl+1

		FileReader fr = new FileReader("C:\\Java\\HelloWorld.java");
		System.out.println("1");

		System.out.println("2");

	}

}
