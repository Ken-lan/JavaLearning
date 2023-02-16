package Midterm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class View extends JDBCConnection implements DBUrl, LoginInformation, Statement {

	public void pannel() {

		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("功能清單");
				System.out.println("(1)下載資料至DB");
				System.out.println("(2)從DB讀取資料");
				System.out.println("(3)搜尋以及刪除指定DB資料");
				System.out.println("(4)存入圖片至DB");
				System.out.println("(5)從DB讀取圖片並建立檔案");
				System.out.println("其他鍵結束功能");
				System.out.println("輸入數字選擇功能:");
				String Input = scanner.next();
				Integer number = Integer.parseInt(Input);

				if (number == 1) {
					System.out.println("你選擇的是: 下載資料至DB");
					setUrl("https://www.ttl.com.tw/files/opendata/all/%E8%87%BA%E7%81%A3%E8%8F%B8%E9%85%92%E8%82%A1%E4%BB%BD%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8%E7%94%A2%E5%93%81%E5%83%B9%E7%9B%AE%E8%A1%A8.csv");
					String line;
					String Array[];
					try

					{
						BufferedInputStream bis = urlInput(getUrl());
						BufferedReader br = Reader(bis);
						br.readLine();
						Connection conn = conn(DB_URL, USERNAME, PASSWORD);
						PreparedStatement prepStat = prepStat(conn, INSERT);

						while ((line = br.readLine()) != null) {
							Array = line.split(",");
							// System.out.println(line);
							for (int i = 1; i < 8; i++) {
								prepStat.setString(i, Array[i - 1]);
							}

							prepStat.execute();
						}
						int count = prepStat.executeUpdate();
						if (count > 0)
							System.out.println("success");
						prepStat.close();
						conn.close();
						br.close();
						bis.close();


					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					continue;
				} else if (number == 2) {

					System.out.println("你選擇的是: 從DB讀取資料");
					System.out.println("請輸入id:");
					String selectID = scanner.next();

					String content = "";
					Connection conn;
					try {
						conn = conn(DB_URL, USERNAME, PASSWORD);
						PreparedStatement prepStat = prepStat(conn, QUERY);
						prepStat.setString(1, selectID);
						ResultSet rs = prepStat.executeQuery();
						while (rs.next()) {

							content += "編號 =" + rs.getString("id") + ",";
							content += "產品類別 =" + rs.getString("category") + ",";
							content += "產品代號=" + rs.getString("code") + ",";
							content += "品名=" + rs.getString("name") + ",";
							content += "包裝=" + rs.getString("size") + ",";
							content += "單位=" + rs.getString("unit") + ",";
							content += "建議售價=" + rs.getString("price") + ",";
							content += "備註=" + rs.getString("memo");
							System.out.println(content);
						}

						// 下載成txt檔
						String dest = String.format("C:\\Users\\Student\\Desktop\\%s.txt", selectID);
						BufferedOutputStream bos = downloadDestination(dest);

						// 將內容轉成Byte陣列並寫入
						byte[] bytes = content.getBytes();
						bos.write(bytes);
						System.out.println("success!!");
						bos.close();
						rs.close();
						prepStat.close();
						conn.close();

					} catch (SQLException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();

					}

					continue;
				} else if (number == 3) {


					
					System.out.println("你選擇的是: 搜尋以及刪除指定DB資料");
					System.out.println("請輸入品名");

					try {
						Connection conn = conn(DB_URL, USERNAME, PASSWORD);
						PreparedStatement prepStat = prepStat(conn, DELETE);
						String condition = scanner.next();
						prepStat.setString(1, "%" + condition + "%");
						prepStat.executeUpdate();

						prepStat.close();
						conn.close();

						System.out.println("success!");
					} catch (SQLException e) {
						// e.printStackTrace();
						System.out.println("沒有指定項目，程式結束");
						break;
					}
					
					
					continue;

				} else if (number == 4) {
					System.out.println("你選擇的是: 存入圖片至DB");

					File file = new File("C:\\Java\\Tomcat.gif");
					try {

						Connection conn = conn(DB_URL, USERNAME, PASSWORD);
						PreparedStatement prepStat = prepStat(conn, INSERT_PIC);
						BufferedInputStream bis = fileInput(IMAGE_DEST);// 圖片位置

						prepStat.setString(1, file.getName());
						prepStat.setBinaryStream(2, bis);
						prepStat.setString(3, findExtension(file));
						int count = prepStat.executeUpdate();
						if (count > 0)
							System.out.println("success!");

						bis.close();
						prepStat.close();
						conn.close();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					continue;

				} else if (number == 5) {
					System.out.println("你選擇的是: 從DB讀取圖片並建立檔案");
					System.out.println("請輸入ID");
					String selectID = scanner.next();
					String content = "";
					String filename ="";
					try {
						Connection conn = conn(DB_URL, USERNAME, PASSWORD);
						PreparedStatement prepStat = prepStat(conn, QUERY_PIC);
						prepStat.setString(1, selectID);
						ResultSet rs = prepStat.executeQuery();
						while (rs.next()) {
							
							
							content += "ID=" + rs.getString("fileID") + ",";
							content += "檔名=" + rs.getString("fileName") + ",";
							content += "檔案內容=" + rs.getString("fileContent") + ",";
							content += "副檔名=" + rs.getString("fileType");
							System.out.println(content);
							filename = rs.getString("fileName");
							
						};
						
						String destFileName = String.format("C:\\Java\\%s", filename);
						
						// 寫入
						prepStat.setString(1, selectID);
						rs = prepStat.executeQuery();
						FileOutputStream fos = new FileOutputStream(destFileName);
						// 要等到有東西時才儲存
						while (rs.next()) {
							Blob b = rs.getBlob("fileContent");
							byte[] bytes = b.getBytes(1, (int) b.length());
							fos.write(bytes);
						}
						System.out.println("儲存成功!");

						fos.close();
						rs.close();
						prepStat.close();
						conn.close();

					} catch (Exception e) {
						e.printStackTrace();
					}

					continue;

				} else {
					Input = null;
					System.out.println("結束");
					scanner.close();
					break;
				}
				// TODO: handle exception
			}
			scanner.close();
		} catch (Exception e) {
		} 
	}

}
