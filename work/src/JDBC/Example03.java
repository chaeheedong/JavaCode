package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {

		String choice = "";
		
		Scanner in = new Scanner(System.in);
		
		try {
			Connection con = null;
			Statement stmt = null;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";
			
			
			Class.forName(driver);
			System.out.println("����̹� ���� �Ϸ�");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Ŀ�ؼ� ���� �Ϸ�");
			stmt = con.createStatement();
			
			System.out.print("DELETE id : ");
			choice = in.next();
			
			String SQL = "DELETE FROM member WHERE id = '" + choice + "'";
			
			stmt.executeQuery(SQL);
			
			System.out.println("( choice : " + choice + " ) �Է¿Ϸ�");
			System.out.println("Query ����");
			System.out.println(choice + " DELETE �Ϸ�");
			System.out.println("number TABLE RECORD DELETE �Ϸ�");
			
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
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
