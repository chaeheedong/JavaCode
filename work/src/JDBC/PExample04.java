package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PExample04 {

	public static void main(String[] args) {
		
		try {
			Connection con = null;
			PreparedStatement pstmt;
			ResultSet rs = null;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driver);
			System.out.println("����̹� ���� �Ϸ�");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Ŀ�ؼ� ���� �Ϸ�");
			pstmt = con.prepareStatement("SELECT * FROM member");

			rs = pstmt.executeQuery();
			System.out.println("Query ����");

			while (rs.next()) {

				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");

				System.out.println("ȸ������ => ��ȣ : " + no + "\tid : " + id + "\tpwd : " + pwd);

			}

			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
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
