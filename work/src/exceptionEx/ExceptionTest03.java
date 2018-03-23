package exceptionEx;

import java.util.Scanner;

public class ExceptionTest03 {

	// Field
	private int sum;
	private int avg;

	// Constructor
	public ExceptionTest03() {
	}

	// Method
	public void sum(int x, int y) {
		System.out.println("1==> sum 시작");
		sum = x + y;
		System.out.println("1==> 합 : " + sum);
		System.out.println("1==> sum 끝");
	}

	// JVM에서 던진 ArithmeticException을 다시 자신을 호출한 곳으로 던진(?, 위임)다
	public void avg(int z) throws ArithmeticException {
		System.out.println("2==> avg 시작");
		// z = 0 인경우 불능
		avg = sum / z;
		System.out.println("2.평균 : " + avg);
		System.out.println("2==> avg 끝");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();

		ExceptionTest03 et = new ExceptionTest03();
		et.sum(i, j);
		// ==> 어떤 Exception이 발생하는지 확인하자.
		et.avg(k);

		System.out.println("main Method End...");

	}

}
