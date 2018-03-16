package apiEx.string;

public class StringTest03 {

	public static void main(String[] args) {

		String name = "012ABCdef";
		String hi = "Hi !";

		// concat(String str) : ������ ���ڿ����� ���ڿ��� ���� �����մϴ�.
		String s1 = hi.concat(name);
		System.out.println(s1);

		// substring(int beginIndex) : �� ���ڿ��� ���� ���ڿ� �� �� ���ڿ��� ��ȯ�մϴ�.
		String s2 = s1.substring(7);
		System.out.println(s2);

		// indexOf(String str) : �� ĳ���� ���� ������, ������ ���ڰ� ���ʷ� �����ϴ� ��ġ�� �ε����� �����ݴϴ�.
		int a = name.indexOf("ABC");
		System.out.println(a);
		System.out.println(name.substring(a));

		
		int b = name.indexOf("ABC");
		System.out.println(b);
		System.out.println(name.substring(b));
		// 	substring(int beginIndex, int endIndex) : �� ���ڿ��� ���� ���ڿ� �� �� ���ڿ��� ��ȯ�մϴ�.
		System.out.println(name.substring(b, 5));

		// �� ��ü�� ��Ÿ���� ���� �������� ���ڰ� ó�� ������ ����. ���ڰ����� ��� -1.
		int c = name.indexOf("z");
		System.out.println(c);

	}

}
