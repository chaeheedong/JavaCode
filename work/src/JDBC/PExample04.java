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
			System.out.println("드라이버 연결 완료");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("커넥션 연결 완료");
			pstmt = con.prepareStatement("SELECT * FROM member");

			rs = pstmt.executeQuery();
			System.out.println("Query 실행");

			while (rs.next()) {

				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");

				System.out.println("회원정보 => 번호 : " + no + "\tid : " + id + "\tpwd : " + pwd);

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
				System.out.println("con / stmt가 닫히지 않음");
				e.printStackTrace();
			}

		} catch (Exception e) {

			System.out.println("Error");
			e.printStackTrace();

		}
		
	}
	
}
