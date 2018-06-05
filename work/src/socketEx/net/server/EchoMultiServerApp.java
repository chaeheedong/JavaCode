package socketEx.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import socketEx.net.server.thread.ServerSocketThread;

/*
 * Echo Server Application
 */
public class EchoMultiServerApp {

	public static void main(String[] args) {
		
		System.out.println("=====================================================");
		System.out.println(" [ EchoMultiServerApp Main Thread ] : STARTUP...");
		
		// ServerSocketThread(������ Client ���� Thread) ���� ���� ����
		List<ServerSocketThread> list = new Vector<ServerSocketThread>(10, 10);
		
		// Client ������ ���� ServerSocket, Socket
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		// Client ��� Thread
		ServerSocketThread serverSocketThread = null;
		
		// ���ѷ��� ����� Flag
		boolean loopFlag = false;
		
		try {
			
			// Server Port Open : ServerSocket ����
			serverSocket = new ServerSocket(7000);
			// ServerSocket ���� OK�� ���
			loopFlag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// ���� Loop : Client Connection Wait
		while (loopFlag) {
			
			try {
				
				System.out.println("\n\t\t\t/////////////////////////////////////////////////////////////////////////////////");
				System.out.println("\t\t\t [ Echo MultiServerApp Main Thread ] : Client Connection Wait");
				
				// accept() : Client Connection Wait : Network block ����
				// 			: Client Connection �� Socket ���� Return
				socket = serverSocket.accept();
				
				System.out.println("\n\t\t\t [ Host Main Thread ] : client " + socket.getRemoteSocketAddress() + " ����");
				
				// Client�� ����ϴ� ServerSocketThread ����
				serverSocketThread = new ServerSocketThread(socket, list);
				
				// Client ���� ���� chatServerSocketThread ����
				list.add(serverSocketThread);
				
				System.out.println("\t\t\t [ EchoMultiServerApp Main Thread ] : ���� �����ڼ� " + list.size() + "\n");
				// Thread Start
				serverSocketThread.start();
				
			}catch (Exception e) {
				e.printStackTrace();
				loopFlag = false;
			}
			
		}
		
		System.out.println("\t\t\t [ Echo MultiServerApp Main Thread ] : Client Connection Wait END");
		System.out.println("\n\t\t\t/////////////////////////////////////////////////////////////////////////////////\n");
		
		// EchoMultiServerApp Main Thread ����� : �������� ServerSocketThread ����
		// synchronized Block : ����ȭ����
		synchronized (list) {
		
			for (ServerSocketThread thread : list) {
				
				thread.setLoopFlag(false);
				
			}
			
		}
		
		// ServerSocketThread ���� Ȯ�� : list���� remove�� Ȯ��
		// Sub Thread ������ Main Thread ���� ���� sleep()
		while(true) {
			
			if(list.size() != 0) {
				
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {}
				
			}else {
				break;
			}
			
		}
		
		
		// SocketServer close()
		try {
			if( serverSocket != null) {
				serverSocket.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\t\t\t [ Echo MultiServerApp Main Thread ] : SHUTDOWN...");
		System.out.println("\n\t\t\t/////////////////////////////////////////////////////////////////////////////////\n");
		
	}
	
}
