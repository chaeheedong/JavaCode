package exceptionEx;

import java.util.Scanner;

public class ExceptionTest01 {

	// Field
	private int sum;
	private int avg;

	// Constructor
	public ExceptionTest01() {
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
		// z = 0 �� ��� �Ҵ�
		avg = sum / z;
		System.out.println("2==> ��� : " + avg);
		System.out.println("2==> avg ��");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();

		ExceptionTest01 et = new ExceptionTest01();
		et.sum(i, j);
		et.avg(k);

		System.out.println("main Method End...");

	}

}
