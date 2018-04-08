package exceptionEx.Ex2;

public class TryCatchFinallyExample {

	public static void main(String[] args) {
		
		try {
			Class clazz = Class.forName("java.lang.String2"); // ClassNotFoundException 발생 (java.lang.String2 존재 x)
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
	}
	
}
