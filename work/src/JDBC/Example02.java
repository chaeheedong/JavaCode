package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Example02 {

	public static void main(String[] args) {

		int no = 0;
		String id = "";
		String pwd = "";

		Scanner in = new Scanner(System.in);

		try {

			Connection con = null;
			Statement stmt = null;
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String driver = "oracle.jdbc.driver.OracleDriver";

			Class.forName(driver);
			System.out.println("드라이버 연결 완료");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("커넥션 연결 완료");
			stmt = con.createStatement();

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

			String SQL = "INSERT INTO member VALUES('" + no + "','" + id + "','" + pwd + "')";

			stmt.executeQuery(SQL);
			System.out.println("( no : " + no + ", id : " + id + ", pwd : " + pwd + " ) 입력완료");
			System.out.println("Query 실행");
			System.out.println("number TABLE DATA INSERT 완료");

			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				System.out.println("con / stmt가 닫히지 않음");
				e.printStackTrace();
			}
			
		} catch (Exception e) {

			System.out.println("입력 에러");
			e.printStackTrace();

		}

	}

}
