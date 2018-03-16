package collectionEx.stack;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {

		Stack<String> stack = new Stack();

		String value = new String("1 : 홍길동");
		// push(E item) : 아이템을이 스택의 맨 위로 밀어 넣습니다.
		stack.push(value);
		stack.push(new String("2 : 이순신"));
		stack.push("3 : 주몽");

		System.out.println("==> 저장된 Data 갯수 : " + stack.size());
		// pop() : 이 스택의 맨 위에있는 객체를 제거하고이 객체를이 함수의 값으로 반환합니다.
		String str1 = stack.pop();
		System.out.println(str1);

		System.out.println("==> 저장된 Data 갯수 : " + stack.size());
		// peek() : 스택 맨 위의 객체를 스택에서 제거하지 않고 봅니다.
		String str2 = stack.peek();
		System.out.println(str2);

		System.out.println("==> 저장된 Data 갯수 : " + stack.size());
		
		// empty() : 이 스택이 하늘인지 테스트합니다.
		while (!stack.isEmpty()) {

			String str3 = (String) stack.pop();
			System.out.println(str3);

		}

	}
}
