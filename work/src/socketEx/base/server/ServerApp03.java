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
 * 1. ServerApp02.java : �ι�° Client ���� �Ұ��� ���� ?
 * 	�� accept() method �ٽ� ������� �ʴ´�.
 * 	==> �� �����ڿ��� Client�� Data�� �ְ� �޴� ���� loop�� �� ����
 *  ==> accept()�� �ִ� main() method�� ���� Loop�� ���ư��� ����
 *  
 * 2. 1���� main Thread�δ� ���� �Ұ�
 * 	==> ���� ���� �� thread �ʿ伺
 */
public class ServerApp03 {

	public static void main(String[] args) throws IOException {

		// Ư�� port�� open�ϴ� ServerSocket ��ü����
		ServerSocket serverSocket = new ServerSocket(7000);

		// accept() : ���� loop ���� ������ �۾��� �� �ֵ��� ��.
		while (true) {

			System.out.println(" [ Server ] : client�� ������ ��ٸ���...");

			// accept() : ���� loop ���� ������ �۾��� �� �ֵ��� ��
			// : Client ���ӽ� ������ �߻�ȭ�� Socket ���� Return
			Socket socket = serverSocket.accept();
			System.out.println(" [ Server ] : client ���� �Ϸ� ...");

			// Thread ���� Socket ��ü�� ������ ���� Thread start()
			new SocketThread(socket).start();
			System.out.println("\n\n\n\t>>>>>>>>>>>>>>>>>>> ����� main�� while�� ��...\n\n\n");

		}

	}

}

// ==> Thread ���� Bean
// ServerApp03 : client ������ ��ٸ��� Main thread
// SocketThread : ���ӵ� Client data�� Data �ְ� �޴� Thread 
class SocketThread extends Thread {
	
	private BufferedReader fromClient;
	private PrintWriter toClient;
	
	public SocketThread() {
		super();
	}
	
	public SocketThread(Socket socket) {
		
		try {
			
			// Client�� Data�� �ۼ��� : FilterStream�� BufferedReader / PrintWriter ���
			fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		
		try {
			
			// Client�� data�� �ְ� �޴� ���� loop
			while(true) {
				
				//==> read() IO block ���� :: �� client data �۽ŵɶ� ���� waiting
				String clientData = fromClient.readLine();
				
				System.out.println(" [ Server ] : client�� ���� ���� ���� Data ==> " + clientData);
				toClient.println("server ȸ�� [ Data receiver OK ]");
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}