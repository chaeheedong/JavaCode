package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PExample02 {

	public static void main(String[] args) {

		int no = 0;
		String id = "";
		String pwd = "";

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

			pstmt = con.prepareStatement("INSERT INTO member VALUES(?, ?, ?)");
			
			try {
				
				System.out.print("no 입력 : ");
				no = in.nextInt();
				System.out.println();
				
				System.out.print("id 입력 : ");
				id = in.next();
				System.out.println();
				
				System.out.print("pwd 입력 : ");
				pwd = in.next();
				System.out.println();
				
			} catch (Exception e) {
				System.out.println("입력 에러");
				e.printStackTrace();
			}
			
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			
			int confirm = pstmt.executeUpdate();
			System.out.println("( no : " + no + ", id : " + id + ", pwd : " + pwd + " ) 입력완료");
			System.out.println("Query 실행");
			
			if(confirm == 1) {
				System.out.println("member TABLE DATA INSERT 완료");
			}else {
				System.out.println("member TABLE DATA INSERT 실패");
			}


			try {
				
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				
			} catch (Exception e) {
				System.out.println("닫기 에러");
				e.printStackTrace();
			}
			
		} catch (Exception e) {

			System.out.println("입력 에러");
			e.printStackTrace();

		}

	}

}
