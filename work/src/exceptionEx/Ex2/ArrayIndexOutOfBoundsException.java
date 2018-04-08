package exceptionEx.Ex2;

public class ArrayIndexOutOfBoundsException {

	public static void main(String[] args) {
		
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("args[0] : " + data1);
		System.out.println("args[1] : " + data2);
		
	}
	
}


/*
*
* 배열에서 인덱스 범위를 초과하여 사용할 경우 ArrayIndexOutOfBoundsException 발생
* 두 개의 실행 매개값을 주지 않았기 때문에 args[0], args[1]과 같이 인덱스를 사용할 수 없다.
*
*/