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
			System.out.println("����̹� ���� �Ϸ�");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Ŀ�ؼ� ���� �Ϸ�");

			pstmt = con.prepareStatement("INSERT INTO member VALUES(?, ?, ?)");
			
			try {
				
				System.out.print("no �Է� : ");
				no = in.nextInt();
				System.out.println();
				
				System.out.print("id �Է� : ");
				id = in.next();
				System.out.println();
				
				System.out.print("pwd �Է� : ");
				pwd = in.next();
				System.out.println();
				
			} catch (Exception e) {
				System.out.println("�Է� ����");
				e.printStackTrace();
			}
			
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			
			int confirm = pstmt.executeUpdate();
			System.out.println("( no : " + no + ", id : " + id + ", pwd : " + pwd + " ) �Է¿Ϸ�");
			System.out.println("Query ����");
			
			if(confirm == 1) {
				System.out.println("member TABLE DATA INSERT �Ϸ�");
			}else {
				System.out.println("member TABLE DATA INSERT ����");
			}


			try {
				
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				
			} catch (Exception e) {
				System.out.println("�ݱ� ����");
				e.printStackTrace();
			}
			
		} catch (Exception e) {

			System.out.println("�Է� ����");
			e.printStackTrace();

		}

	}

}
