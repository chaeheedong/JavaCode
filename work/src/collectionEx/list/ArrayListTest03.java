package collectionEx.list;

import java.util.ArrayList;

public class ArrayListTest03 {

	public static void main(String[] args) {

		// ArrayList 생성시 관리(저장, 추출)될 객체의 DataType 선언
		ArrayList<String> arrayList = new ArrayList(10);

		// add(E obj) : E를 인자로 받는다는 의미는 ? :: Generic 사용으로 묵시적 형변환 불필요
		String s1 = new String("1.홍");
		arrayList.add(s1);
		arrayList.add(new String("2.길"));
		arrayList.add("3.님 안녕하세요.");

		// ArrayList 저장된 값을 출력
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

		System.out.println("\nJDK 1.5 추가 기능 :: Generic, Enhanced For Loop 사용");
		// ==> 위의 for문과 비교하여 이해하자 / JDK 1.5에 추가된 기능 :: Enhanced For Loop
		// ArrayList 내부에 저장된 값을 size()만큼 반복, 1EA씩 추출 String 준다 (Generic 사용으로...)
		for (String value : arrayList) {

			System.out.print(value);

		}

		System.out.println("\n==> API 확인");
		arrayList.add(1, "4.길");
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

		System.out.println("\n==> API 확인");
		arrayList.add(3, "4.홍길동");
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

		System.out.println("\n==> API 확인");
		arrayList.remove(3);
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

	}
}
