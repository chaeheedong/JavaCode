package socketEx.base.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * FileName : ServerApp01.java
 * 
 * :: ServerComputer는...
 * :: 1. Client의 접속을 Waiting
 * :: 2. 접속 후 접속을 추상화한 Socket Instance를 Return하는 ServerSocket 사용
 */
public class ServerApp01 {

	public static void main(String[] args) throws IOException {
		
		// 특정 port를 open하는 ServerSocket 생성
		ServerSocket serverSocket = new ServerSocket(7000);
		
		System.out.println(" [ Server ] : client의 접속을 기다린다...");
		
		// accept() : Client를 기다리는 waiting 즉 block 상태
		//			: Client 접속시 접속을 추상화한 Socket 생성 Return
		Socket socket = serverSocket.accept();
		System.out.println(" [ Server ] : client 연결 완료 ...");
		
		// Client와 Data를 송수신 : FilterStream인 BufferedReader / PrintWriter 사용
		BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		
		System.out.println(" [ Server ] : client 접속 후 data를 받기위한 무한 loop start");
		
		// Client와 data를 주고 받는 무한 loop
		while(true) {
			
			// ==> read() IO block 상태 :: 즉 client data 송신될때 까지 waiting
			String clientData = fromClient.readLine();
			
			System.out.println(" [ Server ] : client로 부터 전송 받은 Data ==> " + clientData);
			toClient.println(" server 회신 [ Data receiver OK ]");
			
		}
		
		
	}
	
}
