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
		System.out.println("1==> sum 시작");
		sum = x + y;
		System.out.println("1==> 합 : " + sum);
		System.out.println("1==> sum 끝");
	}

	// 인자값으로 0이 들어오면 문제 발생
	public void avg(int z) {
		System.out.println("2==> avg 시작");
		// try-catch 로 JVM에서 던지는 Exception 객체를 처리하자.
		// ==> 출력 결과를 확인하자
		try {
			avg = sum / z;
		} catch (ArithmeticException e) {
			System.out.println("1.>> ==========================");
			System.out.println("z값이 0인 모양입니다. 나누기 불가");
			System.out.println("2.>> ==========================");
			System.out.println(e); // System.out.println(e.toString());
			System.out.println("3.>> ==========================");
			e.printStackTrace();
			System.out.println("4.>> ==========================");
		}
		System.out.println("2.평균 : " + avg);
		System.out.println("2==> avg 끝");
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
