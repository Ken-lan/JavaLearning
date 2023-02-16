package exam_finished.e9;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/*
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
*/
public class ParseCSV {

	public static void main(String[] args) {
		/*
		 * 將exam/e8/Employee.csv Copy至c:\java 只能利用Commons csv
		 * library來處理csv檔案,注意cvs檔案編碼為MS950 網址如下
		 * https://commons.apache.org/proper/commons-csv/
		 * 1.下載commons-csv-1.9-bin.zip，解壓縮後將jar放至lib目錄 2.eclipse中設定library 3.參考官方的User
		 * Guide處理此csv 4.所有有實作AutoCloseable的物件都必須close 5.不可自行將csv中的千分號移除，不可以改動csv中的內容
		 * 取得薪水的加總
		 */
/*
		try (Reader in = new FileReader("c:\\Java\\Employees.csv");

				CSVParser parser = CSVParser.parse(in, CSVFormat.RFC4180);

		) {

			Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
			int num = 0;
			int sum = 0;
			int counter = 0;
			for (CSVRecord record : records) {
				String salary = record.get(2);
				counter++;
				if (counter == 1) {
					continue;// 跳過欄位名稱這一列
				}
				String salaryNum = salary.replace(",", "");
				num = Integer.parseInt(salaryNum);
				sum += num;
			}
			System.out.printf("薪水加總=%d元%n", sum);

		} catch (IOException e) {

		} catch (Exception ex) {

		}
*/
	}
}
