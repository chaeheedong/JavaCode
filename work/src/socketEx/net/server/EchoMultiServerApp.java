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
		
		// ServerSocketThread(각각의 Client 접속 Thread) 관리 위해 저장
		List<ServerSocketThread> list = new Vector<ServerSocketThread>(10, 10);
		
		// Client 접속을 위한 ServerSocket, Socket
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		// Client 통신 Thread
		ServerSocketThread serverSocketThread = null;
		
		// 무한루프 제어용 Flag
		boolean loopFlag = false;
		
		try {
			
			// Server Port Open : ServerSocket 생성
			serverSocket = new ServerSocket(7000);
			// ServerSocket 생성 OK인 경우
			loopFlag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// 무한 Loop : Client Connection Wait
		while (loopFlag) {
			
			try {
				
				System.out.println("\n\t\t\t/////////////////////////////////////////////////////////////////////////////////");
				System.out.println("\t\t\t [ Echo MultiServerApp Main Thread ] : Client Connection Wait");
				
				// accept() : Client Connection Wait : Network block 상태
				// 			: Client Connection 시 Socket 생성 Return
				socket = serverSocket.accept();
				
				System.out.println("\n\t\t\t [ Host Main Thread ] : client " + socket.getRemoteSocketAddress() + " 연결");
				
				// Client와 통신하는 ServerSocketThread 생성
				serverSocketThread = new ServerSocketThread(socket, list);
				
				// Client 관리 위한 chatServerSocketThread 저장
				list.add(serverSocketThread);
				
				System.out.println("\t\t\t [ EchoMultiServerApp Main Thread ] : 현재 접속자수 " + list.size() + "\n");
				// Thread Start
				serverSocketThread.start();
				
			}catch (Exception e) {
				e.printStackTrace();
				loopFlag = false;
			}
			
		}
		
		System.out.println("\t\t\t [ Echo MultiServerApp Main Thread ] : Client Connection Wait END");
		System.out.println("\n\t\t\t/////////////////////////////////////////////////////////////////////////////////\n");
		
		// EchoMultiServerApp Main Thread 종료시 : 진행중인 ServerSocketThread 정리
		// synchronized Block : 동기화문제
		synchronized (list) {
		
			for (ServerSocketThread thread : list) {
				
				thread.setLoopFlag(false);
				
			}
			
		}
		
		// ServerSocketThread 종료 확인 : list에서 remove로 확인
		// Sub Thread 종료후 Main Thread 종료 위해 sleep()
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
