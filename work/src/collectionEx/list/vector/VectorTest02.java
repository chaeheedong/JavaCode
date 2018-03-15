package collectionEx.list.vector;

import java.util.Vector;

// Vector�� final class�� �ƴ϶�� Ȯ�� ����
// Vector�� Ȯ���Ͽ� �ʿ��� ���(method)�� �߰�
public class VectorTest02 extends Vector {

	public VectorTest02() {
		super();
	}

	public VectorTest02(int initialCapacity, int capacityIncrement) {
		super(initialCapacity, capacityIncrement);
	}

	// Vector�� ����(?, ����)�� ���ڿ� ���� ����ϴ� Method ����
	public void pringString(Vector vector) {

		// for (int i = 0; i < vector.size(); i++) {
		// System.out.println((String)vector.elementAt(i));
		// }

		// ���� for���� ���Ͽ� ��������. / JDK1.5�� �߰��� ��� :: Enhanced For Loop
		// Vector���ο� ����� ���� size()��ŭ �ݺ�, 1EA�� ���� Object�� ���(?) �ش�
		for (Object object : vector) {

			// ==> ���� for���� elementAt()�� Casting�� �Ͱ� ���Ͽ� ����
			System.out.println((String) object);

		}

	}

	public static void main(String[] args) {

		// Vector Ȯ���Ͽ� �߰��� ���(pringString())�� ������ VectorTest02 �ν��Ͻ� ����
		VectorTest02 vectorTest = new VectorTest02(10, 10);

		// Vector�� Object����
		String s1 = new String("1.ȫ");
		vectorTest.add(s1);
		vectorTest.add(new String("2.��"));
		vectorTest.add("3.�� �ȳ��ϼ���.");
		// Vector ����� �� ���
		vectorTest.pringString(vectorTest);

		System.out.println("\t==> API Ȯ��");
		vectorTest.insertElementAt("4.��", 1);
		vectorTest.pringString(vectorTest);

		System.out.println("\t==> API Ȯ��");
		vectorTest.setElementAt("5.,ȫ���", 3);
		vectorTest.pringString(vectorTest);

		System.out.println("\t==> API Ȯ��");
		vectorTest.removeElementAt(3);
		vectorTest.pringString(vectorTest);
	}

}
