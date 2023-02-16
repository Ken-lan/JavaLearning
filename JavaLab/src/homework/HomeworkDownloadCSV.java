package homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeworkDownloadCSV {

	public static void main(String[] args) throws MalformedURLException {

		URL url = new URL(
				"https://data.moi.gov.tw/MoiOD/System/DownloadFile.aspx?DATA=63A7CF4C-74E1-4903-AE43-3B4A4BB0E83D");
		try (

				InputStream is = url.openStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				FileWriter fw = new FileWriter("C:\\Users\\Student\\Desktop\\中央警察大學109學年度第1學期各學系(所)導師名冊.csv");
				InputStreamReader isr = new InputStreamReader(bis, "UTF8");
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(fw);

		)

		{
			String tempString;
			while ((tempString=br.readLine()) != null) {
				bw.write(tempString);
				bw.newLine();
			}

			System.out.println("done, 下載完成");

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
