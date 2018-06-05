package socketEx.base.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * ServerApp01 ���� ���� �� ����
 */
public class SocketClientApp {

	// Server Computer ������ ���� Socket ����
	private Socket socket;
	// Server�� Data�� �ۼ��� : FilterStream�� BufferedReader / PrintWriter ���
	private BufferedReader fromServer;
	private PrintWriter toServer;
	
	public SocketClientApp() throws Exception {
		
		// Ư�� IP, PORT�� Server ������ ���� connect() Method Call
		this.connect("127.0.0.1", "7000");
		
		// Server�� data�� �ְ� �޴� dataSendAndReceive() Method Call
		this.dataSendAndReceive();
		
	}
	
	public void connect(String connectIp, String connectPort) {
		
		try {
			
			socket = new Socket(connectIp, Integer.parseInt(connectPort));
			
			// TimeOut 3��
			// Socket Stream read() IO Block 3�ʵ��� Data ���ٸ� SocketTimeoutException �߻�
			socket.setSoTimeout(3000);
			
			// Client�� Data�� �ۼ��� �ϱ� ���� FilterStream�� BufferedReader / PrintWriter ���
			toServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// ���� ������ Server�� data �ۼ���
	public void dataSendAndReceive() {
		
		// Keyboard �Է� Stream
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			while(true) {
				
				System.out.println(" [ Client ] : Server�� ������ Data => ");
				String content = keyboard.readLine();
				
				// quit �Է½� ����
				if(content.equals("quit")) {
					break;
				}
				
				// content server ����
				toServer.println(content);
				
				// Server ���� �б� : read() IO Block ���� :: �� Server data �۽ŵɶ� ���� waiting
				// ==> socket.setSoTimeout(3000) ���� 3�� �̻� ��������� Exception �߻�
				String serverData = fromServer.readLine();
				
				System.out.println(" [ Client ] : Server�� ���� ���� Data ==> " + serverData);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		new SocketClientApp();
	}
	
}
