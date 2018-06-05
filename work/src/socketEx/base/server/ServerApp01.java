package socketEx.base.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * FileName : ServerApp01.java
 * 
 * :: ServerComputer��...
 * :: 1. Client�� ������ Waiting
 * :: 2. ���� �� ������ �߻�ȭ�� Socket Instance�� Return�ϴ� ServerSocket ���
 */
public class ServerApp01 {

	public static void main(String[] args) throws IOException {
		
		// Ư�� port�� open�ϴ� ServerSocket ����
		ServerSocket serverSocket = new ServerSocket(7000);
		
		System.out.println(" [ Server ] : client�� ������ ��ٸ���...");
		
		// accept() : Client�� ��ٸ��� waiting �� block ����
		//			: Client ���ӽ� ������ �߻�ȭ�� Socket ���� Return
		Socket socket = serverSocket.accept();
		System.out.println(" [ Server ] : client ���� �Ϸ� ...");
		
		// Client�� Data�� �ۼ��� : FilterStream�� BufferedReader / PrintWriter ���
		BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		PrintWriter toClient = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
		
		System.out.println(" [ Server ] : client ���� �� data�� �ޱ����� ���� loop start");
		
		// Client�� data�� �ְ� �޴� ���� loop
		while(true) {
			
			// ==> read() IO block ���� :: �� client data �۽ŵɶ� ���� waiting
			String clientData = fromClient.readLine();
			
			System.out.println(" [ Server ] : client�� ���� ���� ���� Data ==> " + clientData);
			toClient.println(" server ȸ�� [ Data receiver OK ]");
			
		}
		
		
	}
	
}
