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
 * Server�� ����ϴ� Thread
 * 
 * - Server�� ��������� ���
 * 
 * 	1. Server Application ���� �����
 * 		: RST(reset) Packet ���۵� ==> Client : InputStream.read() SocketException �߻�
 * 	2. Server���� Socket.close() ���������
 * 		: FIN(final) Packet ���۵� ==> Client : InputStream.read() null �Էµ�
 * 
 * - Packet
 * 	: ��ǻ�� ��Ʈ��ũ�� �����ϴ� �������� ����ȭ�� ���
 * 	: ��Ʈ��ũ ������ �뷮 ����
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
			
			// Host ���� : Socket ������
			this.socket = new Socket();
			
			// Timeout 3�� : Stream read() ���� 3�ʵ��� Data ������ SocketTimeoutException �߻�
			socket.setSoTimeout(timeOut);
			// Socket ����� ��� : Server�� �������� �뵵
			socket.setSoLinger(true, timeOut);
			
			// Server ���� : timeout ���� : API Ȯ��
			SocketAddress socketAddress = new InetSocketAddress(connectIp, connectPost);
			socket.connect(socketAddress, timeOut);
			
			// Server ����� ���� Stream ����
			toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			// Socket, Stream ���� Ok
			loopFlag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	public void run() {
		
		System.out.println(" [ Client Thread ] : ClientSocketThread.run() START...");
		
		while(loopFlag) {
			
			try {
				
				System.out.println("\n [ ClientThread ] : Server�� data ����, �۽� ���� Loop");
				System.out.print(" [ ���۹����Է� [ ����� Quit ] ] : ");
				String toHostValue = new BufferedReader(new InputStreamReader(System.in)).readLine();
				
				if(toHostValue.equals("Quit")) {
					break;
				}
				
				// Server�� ����
				toServer.println(toHostValue);
				
				// Server Data Wait : IO Block
				// Timeout 3�� :: Stream read() 3�� ���� Data ������ SocketTimeoutException �߻�
				String fromHostData = fromServer.readLine();
				
				/*
				 * 1. Server Application ���� �����
				 * 	: RST(Reset)Packet ���۵� => Client : InputStream.read() SocketException �߻�
				 * 2. Server���� Socket.close() ���������
				 * 	: FIN(Final)Packet ���۵� => Client : InputStream.read() null �Էµ�
				 */
				
				if(fromHostData == null) {
					break;
				}
				
				System.out.println(":: Server���� ���� Data : " + fromHostData);
				
			}catch (SocketTimeoutException stoe) {
				stoe.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				// Server�� data ����, �۽� ���� Loop ����
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
			
			// Server���� ���������� close �Ҷ� ���� ���
			Thread.sleep(timeOut);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(" :: close() end ...");
		
	}
	
}
