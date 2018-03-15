package collectionEx.list.vector;

import java.util.Vector;

public class VectorTest03 {

	public static void main(String[] args) {

		// Vector ��ü ������ ����(����, ����)�� �ν��Ͻ� Data Type ���
		Vector<String> vector = new Vector(10, 10);

		// Vector�� String ����
		// add(E obj) : E�� ���ڷ� �޴´ٴ� �ǹ̴� ? :: Generic ������� ������ ����ȯ ���ʿ�
		String s1 = new String("1.ȫ");
		vector.add(s1);
		vector.add(new String("2.��"));
		vector.add("3.�� �ȳ��ϼ���.");

		// Vector ����� ���� ���
		for (int i = 0; i < vector.size(); i++) {

			String s = vector.elementAt(i);
			System.out.print(s);

		}

		System.out.println("\nJDK1.5 �߰� ��� :: Generic, Enhanced For Loop ���");
		// ==> ���� for ���� ���Ͽ� �������� / JDK 1.5�� �߰� ��� :: Enhanced For Loop
		// Vector ���ο� ����� ���� size() ��ŭ �ݺ�, 1EA�� ���� String �ش�.(Generic�������...)
		for (String value : vector) {
			System.out.print(value);
		}

		System.out.println("\n==> API Ȯ��");
		vector.insertElementAt("4.��", 1);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print(vector.elementAt(i));
		}

		System.out.println("\n==> API Ȯ��");
		vector.setElementAt("5.,ȫ���", 3);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print(vector.elementAt(i));
		}

		System.out.println("\n==> API Ȯ��");
		vector.removeElementAt(3);
		for (int i = 0; i < vector.size(); i++) {
			System.out.print(vector.elementAt(i));
		}

	}

}
