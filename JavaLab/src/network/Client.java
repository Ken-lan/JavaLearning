package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入連線的IP:");
		String ip = scanner.nextLine();// 輸入ip
		try (Socket socket = new Socket(ip, 8080);
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf8");
				OutputStreamWriter osw = new OutputStreamWriter(os, "utf8");
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);) {
			System.out.println("成功連上" + ip);

			Thread senThread = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("請輸入要傳送的訊息");
					String message;
					while ((message = scanner.nextLine()) != null) {
						if (message.equalsIgnoreCase("b")) {
							try {
								socket.close();
							} catch (IOException e) {
								e.printStackTrace();
							}

						}

						try {
							bw.write(message);
							// client端也是透過readLine,所以要送出換行
							bw.newLine();
							bw.flush();// 強制送出，因為buffer一定沒有滿
							System.out.println("請輸入要傳送的訊息:輸入b中斷");
						} catch (IOException e) {
							e.printStackTrace();
						}

					}

				}
			});
			senThread.start();

			String messageFromServer;
			while ((messageFromServer = br.readLine()) != null) {
				System.out.println("接受到訊息:" + messageFromServer);

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
