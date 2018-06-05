package socketEx.base.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * FileName : ServerApp02.java
 * 
 * :: 1. ServerApp01.java : ServerSocket.accept() 역할 : 1회성
 * :: 2. ServerSocket.accept() 무한 loop 돌려 여러번 수행 한다면
 * ==> 여러 client 접속을 할 수 있다 이를 구현해보자.
 * ==> 실행 결과는 ? 문제점은 ?
 */
public class ServerApp02 {

	public ServerApp02(Socket socket) {
		
		try {
			
			// Client와 Data를 송수신 : FilterStream인 BufferedReader / PrintWriter 사용
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			System.out.println(" [ Server ] : client 접속 후 data를 받기위한 무한 loop start");
			
			// Client와 data를 주고받는 무한 loop
			while(true) {
				
				// ==> read() IO block 상태 :: 즉 client data 송신될때 까지 waiting
				String clientData = fromClient.readLine();
				
				System.out.println(" [ Server ] : client로 부터 전송 받은 Data ==> " + clientData);
				toClient.println("server 회신 [ Data receiver OK ]");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// 특정 port를 open하는 ServerSocket 생성
		ServerSocket serverSocket = new ServerSocket(7000);
		
		// accept() : 무한loop 내부 여러번 작업할 수 있도록 함.
		while(true) {
			
			System.out.println(" [ Server ] : Client의 접속을 기다린다...");
			
			// accept() : Client를 기다리는 waiting 즉 block상태
			// 			: Client 접속시 접속을 추상화한 Socket 생성 Return
			Socket socket = serverSocket.accept();
			System.out.println(" [ Server ] : client 연결 완료...");
			
			// Socket() 생성자에 전달
			new ServerApp02(socket);
			
			System.out.println("\n\n\n\t>>>>>>>>>>>>>>>>>>> 여기는 main의 while문 끝...\n\n\n");
			
		}
		
		
	}
	
}
