package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		System.out.println("伺服器啟動中:8080...");
		try(ServerSocket ssc = new ServerSocket(8080);
				Socket socket = ssc.accept();
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf8");
				OutputStreamWriter osw = new OutputStreamWriter(os, "utf8");
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				Scanner scanner = new Scanner(System.in);
				){
			
			InetSocketAddress remote = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("收到來自"+remote.getAddress().getHostAddress()+"的連線");
			
			Thread senThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("請輸入回應的訊息:");
					String message;
					while( (message = scanner.nextLine())!= null) {
						try {
							bw.write(message);
							//client端也是透過readLine,所以要送出換行
							bw.newLine();
							bw.flush();//強制送出，因為buffer一定沒有滿
							System.out.println("請輸入回應的訊息:");
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					}

						
					
				}
			});
			senThread.start();
			
			
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("接收到:"+line);
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
