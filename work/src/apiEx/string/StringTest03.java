package apiEx.string;

public class StringTest03 {

	public static void main(String[] args) {

		String name = "012ABCdef";
		String hi = "Hi !";

		// concat(String str) : 지정된 문자열을이 문자열의 끝에 연결합니다.
		String s1 = hi.concat(name);
		System.out.println(s1);

		// substring(int beginIndex) : 이 문자열의 하위 문자열 인 새 문자열을 반환합니다.
		String s2 = s1.substring(7);
		System.out.println(s2);

		// indexOf(String str) : 이 캐릭터 라인 내에서, 지정된 문자가 최초로 출현하는 위치의 인덱스를 돌려줍니다.
		int a = name.indexOf("ABC");
		System.out.println(a);
		System.out.println(name.substring(a));

		
		int b = name.indexOf("ABC");
		System.out.println(b);
		System.out.println(name.substring(b));
		// 	substring(int beginIndex, int endIndex) : 이 문자열의 하위 문자열 인 새 문자열을 반환합니다.
		System.out.println(name.substring(b, 5));

		// 이 객체가 나타내는 문자 순서에서 문자가 처음 나오는 색인. 문자가없는 경우 -1.
		int c = name.indexOf("z");
		System.out.println(c);

	}

}
