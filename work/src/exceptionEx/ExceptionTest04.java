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
		System.out.println("1==> sum ����");
		sum = x + y;
		System.out.println("1==> �� : " + sum);
		System.out.println("1==> sum ��");
	}

	// JVM���� ���� ArithmeticException�� �ٽ� �ڽ��� ȣ���� ������ ����(?, ����)��
	public void avg(int z) throws ArithmeticException {
		System.out.println("2==> avg ����");
		avg = sum / z; // z = 0 �ΰ�� �Ҵ�
		System.out.println("2.��� : " + avg);
		System.out.println("2==> avg ��");
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int i = in.nextInt();
		int j = in.nextInt();
		int k = in.nextInt();

		ExceptionTest04 et = new ExceptionTest04();
		et.sum(i, j);
		// ==> JVM���� ������, program���� throws�ϴ� Exception(����ó��)�� �ذ�å�� try - catch
		try {
			et.avg(k);
		} catch (ArithmeticException e) { // ���� ������ �ּ�ó���ϰ� �Ʒ��� �ּ��� Ǯ�� �����ϸ�..
			// }catch(Exception e){
			System.out.println("1.>> ====================");
			System.out.println("et.avg(k)���� Exception�� �߻��� ���");
			System.out.println("2.>> ====================");
			System.out.println(e);
			System.out.println("3.>> ====================");
			e.printStackTrace();
			System.out.println("4.>> ====================");
		}

		System.out.println("main Method End...");

	}

}
