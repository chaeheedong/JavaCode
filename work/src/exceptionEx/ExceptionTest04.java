package exceptionEx;

import java.util.Scanner;

public class ExceptionTest04 {

	// Field
	private int sum;
	private int avg;

	// Constructor
	public ExceptionTest04() {
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
		avg = sum / z; // z = 0 인경우 불능
		System.out.println("2.평균 : " + avg);
		System.out.println("2==> avg 끝");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();

		ExceptionTest04 et = new ExceptionTest04();
		et.sum(i, j);
		// ==> JVM에서 던지건, program에서 throws하던 Exception(예외처리)의 해결책은 try - catch
		try {
			et.avg(k);
		} catch (ArithmeticException e) { // 현재 라인을 주석처리하고 아래를 주석을 풀고 실행하면..
			// }catch(Exception e){
			System.out.println("1.>> ====================");
			System.out.println("et.avg(k)에서 Exception이 발생한 모양");
			System.out.println("2.>> ====================");
			System.out.println(e);
			System.out.println("3.>> ====================");
			e.printStackTrace();
			System.out.println("4.>> ====================");
		}

		System.out.println("main Method End...");

	}

}
