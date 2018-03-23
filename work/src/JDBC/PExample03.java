package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class PExample03 {

	public static void main(String[] args) {
		
String choice = "";
		
		Scanner in = new Scanner(System.in);
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			
			
			Class.forName(driver);
			System.out.println("����̹� ���� �Ϸ�");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Ŀ�ؼ� ���� �Ϸ�");
			pstmt = con.prepareStatement("DELETE FROM member WHERE id = ?");
			
			System.out.print("DELETE id : ");
			choice = in.next();
			
			pstmt.setString(1, choice);
			
			pstmt.executeQuery();
			
			System.out.println("( choice : " + choice + " ) �Է¿Ϸ�");
			System.out.println("Query ����");
			System.out.println(choice + " DELETE �Ϸ�");
			System.out.println("number TABLE RECORD DELETE �Ϸ�");
			
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				System.out.println("con / stmt�� ������ ����");
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			
			System.out.println("Error");
			e.printStackTrace();
			
		}
		
	}
	
}
