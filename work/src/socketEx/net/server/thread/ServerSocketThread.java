package socketEx.net.server.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/*
 * Server와 통신하는 Thread
 * 
 * - Server와 연결상태의 경우
 * 
 * 	1. Server Application 강제 종료시
 * 		: RST(reset) Packet 전송됨 ==> Client : InputStream.read() SocketException 발생
 * 	2. Server에서 Socket.close() 정상종료시
 * 		: FIN(final) Packet 전송됨 ==> Client : InputStream.read() null 입력됨
 * 
 * - Packet
 * 	: 컴퓨터 네트워크가 전달하는 데이터의 형식화된 블록
 * 	: 네트워크 전송의 용량 단위
 */
public class ServerSocketThread extends Thread {

	private BufferedReader fromClient;
	private PrintWriter toClient;
	private Socket socket;
	private List<ServerSocketThread> list;
	private boolean loopFlag;
	
	public ServerSocketThread() {
	}
	
	public ServerSocketThread(Socket socket, List<ServerSocketThread> list) {
		
		this.socket = socket;
		this.list = list;
		
		try {
			
			// Client 통신을 위한 Stream 생성
			fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			// Stream 생성 OK
			loopFlag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		System.out.println("\n [ ServerSocketThread (" + list.indexOf(this) + ") :]: data를 수신, 송신 Loop Start");
		
		String fromClientData = null;
		
		while(loopFlag) {
			try {
			/*
			 * 	Client 전송 Data Wait : IO Block
			 * 1. Server Application 강제 종료시
			 * 	: RST(Reset)Packet 전송됨 => Client : InputStream.read() SocketException 발생
			 * 2. Server에서 Socket.close() 정상종료시
			 * 	: FIN(Final)Packet 전송됨 => Client : InputStream.read() null 입력됨
			 */
			if((fromClientData = fromClient.readLine()) != null) {
				
				System.out.println("\n [ ServerSocketThread (" + list.indexOf(this) + ")] : Client 전송받은 Data ==> " + fromClientData);
				toClient.println(fromClientData);
				
			}else {
				break;
			}
			
		}catch (SocketException se) {
			se.printStackTrace();
			loopFlag = false;
		}catch (Exception e) {
			e.printStackTrace();
			loopFlag = false;
		}
		
	}
	
		System.out.println("\n [ ServerSocketThread (" + list.indexOf(this) + ") :]: data를 수신, 송신 Loop End");
		// socket / Stream close()
		this.close();
}

	public void close() {
		
		System.out.println(" :: close() start...");
		
		try {
			if(toClient != null) {
				toClient.close();
				toClient = null;
			}
			if(fromClient != null) {
				fromClient.close();
				fromClient = null;
			}
			if(socket != null) {
				socket.close();
				socket = null;
			}
			
			// List에 내정보 삭제
			list.remove(this);
			
			System.out.println("접속자 수 : " + list.size());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" :: close() end...\n");
		}
		
	// getter / setter Method
	public void setLoopFlag(boolean loopFlag) {
		this.loopFlag = loopFlag;
	}
	
}
	