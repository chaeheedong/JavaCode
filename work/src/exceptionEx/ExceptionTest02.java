package exceptionEx;

import java.util.Scanner;

public class ExceptionTest02 {

	// Field
	private int sum;
	private int avg;

	// Constructor
	public ExceptionTest02() {
	}

	// Method
	public void sum(int x, int y) {
		System.out.println("1==> sum ����");
		sum = x + y;
		System.out.println("1==> �� : " + sum);
		System.out.println("1==> sum ��");
	}

	// ���ڰ����� 0�� ������ ���� �߻�
	public void avg(int z) {
		System.out.println("2==> avg ����");
		// try-catch �� JVM���� ������ Exception ��ü�� ó������.
		// ==> ��� ����� Ȯ������
		try {
			avg = sum / z;
		} catch (ArithmeticException e) {
			System.out.println("1.>> ==========================");
			System.out.println("z���� 0�� ����Դϴ�. ������ �Ұ�");
			System.out.println("2.>> ==========================");
			System.out.println(e); // System.out.println(e.toString());
			System.out.println("3.>> ==========================");
			e.printStackTrace();
			System.out.println("4.>> ==========================");
		}
		System.out.println("2.��� : " + avg);
		System.out.println("2==> avg ��");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();

		ExceptionTest02 et = new ExceptionTest02();
		et.sum(i, j);
		et.avg(k);

		System.out.println("main Method End...");

	}

}
