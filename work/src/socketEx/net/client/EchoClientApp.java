package socketEx.net.client;

import socketEx.net.client.thread.ClientSocketThread;

/*
 * Echo Client Application
 */
public class EchoClientApp {

	public static void main(String[] args) {
		
		System.out.println("==================================================");
		System.out.println(" [ EchoClientApp Main Thread ] : STARTUP");
		
		String connectIp = "127.0.0.1";
		int connectPort = 7000;
		
		// Server 통신용 ClientSocketThread 생성 및 Thread Start
		ClientSocketThread clientSocketThread = new ClientSocketThread(connectIp, connectPort);
		clientSocketThread.start();
		
		try {
			
			/*
			 * Main Thread 는 종료되고 Sub Thread만 존재한다면...
			 * Main Thread 없이 Sub Thread만 구동시 System에서
			 * 메모리 부족등 기타 사유로 강제종료 될 수 있다.
			 * 원칙적으로 Main Thread는 Sub Thread 종료전까지 존재
			 */
			
			// ClientSocketThread 종료 후 Main Thread 종료 join() 사용 ==> API 참조
			clientSocketThread.join();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n [ EchoClientApp Main Thread ] : SHUTDOWN...");
		System.out.println("==================================================");
		
	}
	
}
