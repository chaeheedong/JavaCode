package socketEx.base.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * ServerApp01 먼저 실행 후 실행
 */
public class SocketClientApp {

	// Server Computer 연결을 위한 Socket 선언
	private Socket socket;
	// Server와 Data를 송수신 : FilterStream인 BufferedReader / PrintWriter 사용
	private BufferedReader fromServer;
	private PrintWriter toServer;
	
	public SocketClientApp() throws Exception {
		
		// 특정 IP, PORT로 Server 접속을 위해 connect() Method Call
		this.connect("127.0.0.1", "7000");
		
		// Server와 data를 주고 받는 dataSendAndReceive() Method Call
		this.dataSendAndReceive();
		
	}
	
	public void connect(String connectIp, String connectPort) {
		
		try {
			
			socket = new Socket(connectIp, Integer.parseInt(connectPort));
			
			// TimeOut 3초
			// Socket Stream read() IO Block 3초동안 Data 없다면 SocketTimeoutException 발생
			socket.setSoTimeout(3000);
			
			// Client와 Data를 송수신 하기 위한 FilterStream인 BufferedReader / PrintWriter 사용
			toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 무한 루프로 Server와 data 송수신
	public void dataSendAndReceive() {
		
		// Keyboard 입력 Stream
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			while(true) {
				
				System.out.println(" [ Client ] : Server로 전송할 Data => ");
				String content = keyboard.readLine();
				
				// quit 입력시 종료
				if(content.equals("quit")) {
					break;
				}
				
				// content server 전송
				toServer.println(content);
				
				// Server 응답 읽기 : read() IO Block 상태 :: 즉 Server data 송신될때 까지 waiting
				// ==> socket.setSoTimeout(3000) 으로 3초 이상 응답없으면 Exception 발생
				String serverData = fromServer.readLine();
				
				System.out.println(" [ Client ] : Server로 부터 받은 Data ==> " + serverData);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new SocketClientApp();
	}
	
}
