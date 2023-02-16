package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class ReadCSV {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("C:\\Java\\Employees.csv");
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);

		) {
			String line;
			// int counter = 0;
			int sum = 0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				// counter++;
				// if (counter == 1) {
				// continue;//跳過欄位名稱這一列
			//}
			String[] cols = line.split(",");// ["1","王小明","20"]
			// 如果第三個欄位是數字，才做加總
			if (isNumber(cols[2])) {
				System.out.println(cols[2]);
				sum += Integer.parseInt(cols[2]);
			}
			
			
		}

			System.out.println("薪水總和 = "+sum);
	}
	
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}

	}
	

	

	private static boolean isNumber(String content) {

		// char[] chars = content.toCharArray();
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			if (!Character.isDigit(c)) {
				return false;

			}
			
		}
		return true;

	}
}

