package collectionEx.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {

		Set<String> hs = new HashSet();

		String str = new String("A");
		// add(E e) : ������ ��Ұ��� ��Ʈ������ ��� (������ ���۷��̼�), ��Ʈ�� �߰��մϴ�.
		boolean isAddOk = hs.add(str);
		System.out.println("�������� : " + isAddOk);

		isAddOk = hs.add("b");
		System.out.println("�������� : " + isAddOk);

		isAddOk = hs.add("B");
		System.out.println("�������� : " + isAddOk);

		isAddOk = hs.add("B");
		System.out.println("�������� : " + isAddOk);

		System.out.println("����� data ���� : " + hs.size());

		// contains(Object o) : ��Ʈ�� ������ ��Ҹ� ���� �����ϰ��ִ� ��쿡 true�� �����մϴ�.
		if (hs.contains("b")) {

			System.out.println("����� data b �� ������.");
			// remove(Object o) : ������ ��Ұ� ������, ��Ʈ�κ��� �����մϴ�.
			hs.remove("b");

		}

		System.out.println("����� data ���� : " + hs.size());

	}
}
