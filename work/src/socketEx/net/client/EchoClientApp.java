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
		
		// Server ��ſ� ClientSocketThread ���� �� Thread Start
		ClientSocketThread clientSocketThread = new ClientSocketThread(connectIp, connectPort);
		clientSocketThread.start();
		
		try {
			
			/*
			 * Main Thread �� ����ǰ� Sub Thread�� �����Ѵٸ�...
			 * Main Thread ���� Sub Thread�� ������ System����
			 * �޸� ������ ��Ÿ ������ �������� �� �� �ִ�.
			 * ��Ģ������ Main Thread�� Sub Thread ���������� ����
			 */
			
			// ClientSocketThread ���� �� Main Thread ���� join() ��� ==> API ����
			clientSocketThread.join();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n [ EchoClientApp Main Thread ] : SHUTDOWN...");
		System.out.println("==================================================");
		
	}
	
}
