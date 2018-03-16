package collectionEx.list.vector;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {

		// Vector 생성 : API의 생성자를 확인, 인자로 전달된 10, 10 의미 확인
		// Vector(int initialCapacity, int capacityIncrement) : 지정된 초기 용량 및 증분을 사용하여 빈 벡터를 구성합니다.
		Vector vector = new Vector(10, 10);

		// Vector에 Object 저장 ==> add(Object obj) : Object를 인자로 받는다는 의미는?
		String s1 = new String("1.홍");
		// add(E e) : 지정된 요소를 Vector의 말미에 추가합니다.
		vector.add(s1);
		vector.add(new String("2.동"));
		vector.add("3.님 안녕하세요");

		// Vector 저장된 값을 출력 :: vector.capacity() 무엇을 return 하는가 ...
		for (int i = 0; i < vector.size(); i++) {
			// 	elementAt(int index) : 지정된 인덱스의 컴퍼넌트를 돌려줍니다.
			Object obj = vector.elementAt(i);
			String s = (String) obj;
			// String s = (String)vector.elementAt(i);
			System.out.print(s);
			// System.out.print((String)vector.elementAt(i));
		}

		// 	insertElementAt(E obj, int index) : 이 벡터의 지정된 인덱스에있는 구성 요소로 지정된 객체를 삽입합니다.
		vector.insertElementAt("4.길", 1);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print((String) vector.elementAt(i));
		}

		System.out.println("\n ==> API 확인");
		// 	setElementAt(E obj, int index) : 이 벡터의 지정된 인덱스에있는 컴포넌트를 지정된 객체로 설정합니다.
		vector.setElementAt("5.홍길순", 3);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print((String) vector.elementAt(i));
		}

		System.out.println("\n ==> API 확인");
		// removeElementAt(int index) : 지정된 인덱스에있는 구성 요소를 삭제합니다.
		vector.removeElementAt(3);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print((String) vector.elementAt(i));
		}

	}

}
