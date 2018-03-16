package collectionEx.stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		Stack<String> stack = new Stack();

		String value = new String("1 : ȫ�浿");
		// push(E item) : ���������� ������ �� ���� �о� �ֽ��ϴ�.
		stack.push(value);
		stack.push(new String("2 : �̼���"));
		stack.push("3 : �ָ�");

		System.out.println("==> ����� Data ���� : " + stack.size());
		// pop() : �� ������ �� �����ִ� ��ü�� �����ϰ��� ��ü���� �Լ��� ������ ��ȯ�մϴ�.
		String str1 = stack.pop();
		System.out.println(str1);

		System.out.println("==> ����� Data ���� : " + stack.size());
		// peek() : ���� �� ���� ��ü�� ���ÿ��� �������� �ʰ� ���ϴ�.
		String str2 = stack.peek();
		System.out.println(str2);

		System.out.println("==> ����� Data ���� : " + stack.size());
		
		// empty() : �� ������ �ϴ����� �׽�Ʈ�մϴ�.
		while (!stack.isEmpty()) {

			String str3 = (String) stack.pop();
			System.out.println(str3);

		}

	}
}
