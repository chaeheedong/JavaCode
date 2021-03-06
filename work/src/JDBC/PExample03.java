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
			System.out.println("드라이버 연결 완료");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("커넥션 연결 완료");
			pstmt = con.prepareStatement("DELETE FROM member WHERE id = ?");
			
			System.out.print("DELETE id : ");
			choice = in.next();
			
			pstmt.setString(1, choice);
			
			pstmt.executeQuery();
			
			System.out.println("( choice : " + choice + " ) 입력완료");
			System.out.println("Query 실행");
			System.out.println(choice + " DELETE 완료");
			System.out.println("number TABLE RECORD DELETE 완료");
			
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
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
