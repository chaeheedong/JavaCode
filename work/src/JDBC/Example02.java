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
			System.out.println("����̹� ���� �Ϸ�");
			con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Ŀ�ؼ� ���� �Ϸ�");
			stmt = con.createStatement();

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

			String SQL = "INSERT INTO member VALUES('" + no + "','" + id + "','" + pwd + "')";

			stmt.executeQuery(SQL);
			System.out.println("( no : " + no + ", id : " + id + ", pwd : " + pwd + " ) �Է¿Ϸ�");
			System.out.println("Query ����");
			System.out.println("number TABLE DATA INSERT �Ϸ�");

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

			System.out.println("�Է� ����");
			e.printStackTrace();

		}

	}

}
