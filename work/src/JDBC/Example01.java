package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example01 {

	public static void main(String[] args) {

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
			
			String SQL = 
					"CREATE TABLE member"
			+ "(no 		NUMBER,"
			+ " id 		VARCHAR2(10),"
			+ " pwd 	VARCHAR2(10))";
			
			stmt.executeUpdate(SQL);
			System.out.println("Query ����");
			System.out.println("member TABLE ���� �Ϸ�");
			
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
			System.out.println("Setting ����");
			e.printStackTrace();
		}

	}

}
