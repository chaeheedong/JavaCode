package socketEx.base.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * FileName : ServerApp03.java
 * 
 * 1. ServerApp02.java : 두번째 Client 접속 불가능 이유 ?
 * 	ㅇ accept() method 다시 실행되지 않는다.
 * 	==> 즉 생성자에서 Client와 Data를 주고 받는 무한 loop가 미 종료
 *  ==> accept()가 있는 main() method의 무한 Loop로 돌아가지 못함
 *  
 * 2. 1개의 main Thread로는 진행 불가
 * 	==> 다중 진행 즉 thread 필요성
 */
public class ServerApp03 {

	public static void main(String[] args) throws IOException {

		// 특정 port를 open하는 ServerSocket 객체생성
		ServerSocket serverSocket = new ServerSocket(7000);

		// accept() : 무한 loop 내부 여러번 작업할 수 있도록 함.
		while (true) {

			System.out.println(" [ Server ] : client의 접속을 기다린다...");

			// accept() : 무한 loop 내부 여러번 작업할 수 있도록 함
			// : Client 접속시 접속을 추상화한 Socket 생성 Return
			Socket socket = serverSocket.accept();
			System.out.println(" [ Server ] : client 연결 완료 ...");

			// Thread 생성 Socket 객체를 생성자 전달 Thread start()
			new SocketThread(socket).start();
			System.out.println("\n\n\n\t>>>>>>>>>>>>>>>>>>> 여기는 main의 while문 끝...\n\n\n");

		}

	}

}

// ==> Thread 구현 Bean
// ServerApp03 : client 접속을 기다리는 Main thread
// SocketThread : 접속된 Client data와 Data 주고 받는 Thread 
class SocketThread extends Thread {
	
	private BufferedReader fromClient;
	private PrintWriter toClient;
	
	public SocketThread() {
		super();
	}
	
	public SocketThread(Socket socket) {
		
		try {
			
			// Client와 Data를 송수신 : FilterStream인 BufferedReader / PrintWriter 사용
			fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		try {
			
			// Client와 data를 주고 받는 무한 loop
			while(true) {
				
				//==> read() IO block 상태 :: 즉 client data 송신될때 까지 waiting
				String clientData = fromClient.readLine();
				
				System.out.println(" [ Server ] : client로 부터 전송 받은 Data ==> " + clientData);
				toClient.println("server 회신 [ Data receiver OK ]");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}