package socketEx.net.client.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

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
public class ClientSocketThread extends Thread {

	private BufferedReader fromServer;
	private PrintWriter toServer;
	private Socket socket;
	private int timeOut = 3000;
	private boolean loopFlag;

	public ClientSocketThread() {
	}

	public ClientSocketThread(String connectIp, int connectPost) {
		
		try {
			
			// Host 접속 : Socket 생성만
			this.socket = new Socket();
			
			// Timeout 3초 : Stream read() 에서 3초동안 Data 없으면 SocketTimeoutException 발생
			socket.setSoTimeout(timeOut);
			// Socket 종료시 대기 : Server와 정상종료 용도
			socket.setSoLinger(true, timeOut);
			
			// Server 접속 : timeout 지정 : API 확인
			SocketAddress socketAddress = new InetSocketAddress(connectIp, connectPost);
			socket.connect(socketAddress, timeOut);
			
			// Server 통신을 위한 Stream 생성
			toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			// Socket, Stream 생성 Ok
			loopFlag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public void run() {
		
		System.out.println(" [ Client Thread ] : ClientSocketThread.run() START...");
		
		while(loopFlag) {
			
			try {
				
				System.out.println("\n [ ClientThread ] : Server와 data 수신, 송신 무한 Loop");
				System.out.print(" [ 전송문자입력 [ 종료시 Quit ] ] : ");
				String toHostValue = new BufferedReader(new InputStreamReader(System.in)).readLine();
				
				if(toHostValue.equals("Quit")) {
					break;
				}
				
				// Server로 전송
				toServer.println(toHostValue);
				
				// Server Data Wait : IO Block
				// Timeout 3초 :: Stream read() 3초 동안 Data 없으면 SocketTimeoutException 발생
				String fromHostData = fromServer.readLine();
				
				/*
				 * 1. Server Application 강제 종료시
				 * 	: RST(Reset)Packet 전송됨 => Client : InputStream.read() SocketException 발생
				 * 2. Server에서 Socket.close() 정상종료시
				 * 	: FIN(Final)Packet 전송됨 => Client : InputStream.read() null 입력됨
				 */
				
				if(fromHostData == null) {
					break;
				}
				
				System.out.println(":: Server에서 수신 Data : " + fromHostData);
				
			}catch (SocketTimeoutException stoe) {
				stoe.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				// Server와 data 수신, 송신 무한 Loop 종료
				loopFlag = false;
			}
			
		}
		
		// Socket /Stream close()
		this.close();
		
		System.out.println(" [ Client Thread : ClientSocketThread.run() END.......");
		
	}
	
	public void close() {
		
		System.out.println(" :: close() start...");
		
		try {
			
			if( toServer != null ) {
				toServer.close();
				toServer = null;
			}
			
			if( fromServer != null ) {
				fromServer.close();
				fromServer = null;
			}
			
			if( socket != null ) {
				socket.close();
				socket = null;
			}
			
			// Server에서 정상적으로 close 할때 까지 대기
			Thread.sleep(timeOut);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(" :: close() end ...");
		
	}
	
}
