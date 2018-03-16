package collectionEx.list;

import java.util.ArrayList;

public class ArrayListTest03 {

	public static void main(String[] args) {

		// ArrayList ������ ����(����, ����)�� ��ü�� DataType ����
		// ArrayList(int initialCapacity) : ������ �ʱ� �뷮�� ������ �� ���� (empty)�� ����Ʈ�� �ۼ��մϴ�.
		ArrayList<String> arrayList = new ArrayList(10);

		// add(E obj) : E�� ���ڷ� �޴´ٴ� �ǹ̴� ? :: Generic ������� ������ ����ȯ ���ʿ�
		String s1 = new String("1.ȫ");
		// 	add(E e) : ������ ��Ҹ��̸���Ʈ�� ���̿� �߰��մϴ�.
		arrayList.add(s1);
		arrayList.add(new String("2.��"));
		arrayList.add("3.�� �ȳ��ϼ���.");

		// ArrayList ����� ���� ���
		for (int i = 0; i < arrayList.size(); i++) {

			// get(int index) : ����Ʈ ���� ������ ��ġ�� ��Ҹ� �����ݴϴ�.
			System.out.print(arrayList.get(i));

		}

		System.out.println("\nJDK 1.5 �߰� ��� :: Generic, Enhanced For Loop ���");
		// ==> ���� for���� ���Ͽ� �������� / JDK 1.5�� �߰��� ��� :: Enhanced For Loop
		// ArrayList ���ο� ����� ���� size()��ŭ �ݺ�, 1EA�� ���� String �ش� (Generic �������...)
		for (String value : arrayList) {

			System.out.print(value);

		}

		System.out.println("\n==> API Ȯ��");
		arrayList.add(1, "4.��");
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

		System.out.println("\n==> API Ȯ��");
		arrayList.add(3, "4.ȫ�浿");
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

		System.out.println("\n==> API Ȯ��");
		arrayList.remove(3);
		for (int i = 0; i < arrayList.size(); i++) {

			System.out.print(arrayList.get(i));

		}

	}
}
