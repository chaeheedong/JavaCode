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
		System.out.println("1==> sum 시작");
		sum = x + y;
		System.out.println("1==> 합 : " + sum);
		System.out.println("1==> sum 끝");
	}

	// 인자값으로 0이 들어오면 문제 발생
	public void avg(int z) {
		System.out.println("2==> avg 시작");
		// z = 0 인 경우 불능
		avg = sum / z;
		System.out.println("2==> 평균 : " + avg);
		System.out.println("2==> avg 끝");
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
