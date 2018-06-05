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
			
			// Client ����� ���� Stream ����
			fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			// Stream ���� OK
			loopFlag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		System.out.println("\n [ ServerSocketThread (" + list.indexOf(this) + ") :]: data�� ����, �۽� Loop Start");
		
		String fromClientData = null;
		
		while(loopFlag) {
			try {
			/*
			 * 	Client ���� Data Wait : IO Block
			 * 1. Server Application ���� �����
			 * 	: RST(Reset)Packet ���۵� => Client : InputStream.read() SocketException �߻�
			 * 2. Server���� Socket.close() ���������
			 * 	: FIN(Final)Packet ���۵� => Client : InputStream.read() null �Էµ�
			 */
			if((fromClientData = fromClient.readLine()) != null) {
				
				System.out.println("\n [ ServerSocketThread (" + list.indexOf(this) + ")] : Client ���۹��� Data ==> " + fromClientData);
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
	
		System.out.println("\n [ ServerSocketThread (" + list.indexOf(this) + ") :]: data�� ����, �۽� Loop End");
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
			
			// List�� ������ ����
			list.remove(this);
			
			System.out.println("������ �� : " + list.size());
			
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
	