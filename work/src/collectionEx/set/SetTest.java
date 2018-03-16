package collectionEx.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {

		Set<String> hs = new HashSet();

		String str = new String("A");
		// add(E e) : 지정된 요소가이 세트에없는 경우 (지정된 오퍼레이션), 세트에 추가합니다.
		boolean isAddOk = hs.add(str);
		System.out.println("저장유무 : " + isAddOk);

		isAddOk = hs.add("b");
		System.out.println("저장유무 : " + isAddOk);

		isAddOk = hs.add("B");
		System.out.println("저장유무 : " + isAddOk);

		isAddOk = hs.add("B");
		System.out.println("저장유무 : " + isAddOk);

		System.out.println("저장된 data 갯수 : " + hs.size());

		// contains(Object o) : 세트가 지정된 요소를 보관 유지하고있는 경우에 true를 리턴합니다.
		if (hs.contains("b")) {

			System.out.println("저장된 data b 를 삭제함.");
			// remove(Object o) : 지정된 요소가 있으면, 세트로부터 삭제합니다.
			hs.remove("b");

		}

		System.out.println("저장된 data 갯수 : " + hs.size());

	}
}
