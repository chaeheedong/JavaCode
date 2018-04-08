package exceptionEx.Ex2;

public class NullPointerExceptionExample {

	public static void main(String[] args) {
		
		String data = null;
		
		System.out.println(data.toString());
		
	}
	
}

/*
 * 
 * 가장 빈번하게 발생하는 java.lang.NullPointerException
 * 객체 참조가 없는상태
 * null값을 갖는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 때 발생
 * 객체가 없는 상태에서 객체를 사용하려 했으니 예외가 발생
 * 
 * 7번 라인에서 data 변수는 null값인데 9번라인에서 toString() 메소드를 호출하여 발생
 * 
 */
