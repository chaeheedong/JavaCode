package exceptionEx.Ex2;

public class NumberFormatExceptionExample {

	public static void main(String[] args) {

		String data1 = "100";
		String data2 = "a100";

		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2); // NumberFormatException 발생

		int result = value1 + value2;
		System.out.println(data1 + " + " + data2 + " = " + result);

	}

}

/*
 * 
 * 문자열로 되어 있는 데이터를 숫자로 변경하는 경우가 자주 발생
 * 변환될 수 없는 문자가 포함되어 있다면 NumberFormatException 발생
 * 
 * data2는 숫자로 변환할 수 없음
 * 
 */
