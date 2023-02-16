package exception;

import java.io.File;
import java.io.FileNotFoundException;

public class TestException2 {

	public static void main(String[] args) {
		
		try {
			checkFile("c:\\java\\HelloWorld1.java");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("done");
		System.err.println("done");//印出來有時間差
	}
	public static void checkFile (String filePath) 
						throws FileNotFoundException
	{
		File file = new File(filePath);
		if (!file.exists()) {
			//FileNotFoundException fne = new FileNotFoundException();
			throw new FileNotFoundException(filePath+"找不到檔案");//實務上比較常用這種寫法
			//實務上比較常用這種寫法，建構方法中的文字會出現在訊息中很重要。
			
		}
	}
	
}
