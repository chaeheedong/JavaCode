package collectionEx.list.vector;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {

		// Vector ���� : API�� �����ڸ� Ȯ��, ���ڷ� ���޵� 10, 10 �ǹ� Ȯ��
		// Vector(int initialCapacity, int capacityIncrement) : ������ �ʱ� �뷮 �� ������ ����Ͽ� �� ���͸� �����մϴ�.
		Vector vector = new Vector(10, 10);

		// Vector�� Object ���� ==> add(Object obj) : Object�� ���ڷ� �޴´ٴ� �ǹ̴�?
		String s1 = new String("1.ȫ");
		// add(E e) : ������ ��Ҹ� Vector�� ���̿� �߰��մϴ�.
		vector.add(s1);
		vector.add(new String("2.��"));
		vector.add("3.�� �ȳ��ϼ���");

		// Vector ����� ���� ��� :: vector.capacity() ������ return �ϴ°� ...
		for (int i = 0; i < vector.size(); i++) {
			// 	elementAt(int index) : ������ �ε����� ���۳�Ʈ�� �����ݴϴ�.
			Object obj = vector.elementAt(i);
			String s = (String) obj;
			// String s = (String)vector.elementAt(i);
			System.out.print(s);
			// System.out.print((String)vector.elementAt(i));
		}

		// 	insertElementAt(E obj, int index) : �� ������ ������ �ε������ִ� ���� ��ҷ� ������ ��ü�� �����մϴ�.
		vector.insertElementAt("4.��", 1);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print((String) vector.elementAt(i));
		}

		System.out.println("\n ==> API Ȯ��");
		// 	setElementAt(E obj, int index) : �� ������ ������ �ε������ִ� ������Ʈ�� ������ ��ü�� �����մϴ�.
		vector.setElementAt("5.ȫ���", 3);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print((String) vector.elementAt(i));
		}

		System.out.println("\n ==> API Ȯ��");
		// removeElementAt(int index) : ������ �ε������ִ� ���� ��Ҹ� �����մϴ�.
		vector.removeElementAt(3);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print((String) vector.elementAt(i));
		}

	}

}
