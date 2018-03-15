package abstractEx;

abstract class BusCharge02 {

	// Field
	String section;

	// Constructor
	public BusCharge02() {
	}

	public BusCharge02(String section) {
		this.section = section;
	}

	// method
	public void information() {
		System.out.println("������ݾȳ�");
	}

	// ==> ������ ������, ����Ŭ������ OverRiding�� �����ϴ� �߻�޼��� ����
	// public void charge() {
	// System.out.println("�л� : 300, �Ϲ��� : 500, ��� : ��¥");
	// }

	public abstract void charge();

} // end of class

// abstract class ��ӽ� abstract method ���� ������ (OverRidng)�ؾ��� <== ������
class Student02 extends BusCharge02 {

	public Student02() {
		super("�л�");
	}

	// ==> �Ʒ��� Method �ּ�ó���ϰ� �����Ͻ�.. ������ ������ Ȯ������.
	@Override
	public void charge() {
		System.out.println("300��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������ (OverRiding)�ؾ��� <== ������
class Adult02 extends BusCharge02 {

	public Adult02() {
		super("�Ϲ���");
	}

	@Override
	public void charge() {
		System.out.println("500��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������(OverRiding)�ؾ��� <== ������
class Old02 extends BusCharge02 {

	public Old02() {
		super("���");
	}

	@Override
	public void charge() {
		System.out.println("��¥");
	}

}// end of class

public class Display02 {

	public static void main(String[] args) {

		// ���� ���۷����� ���� �ν��Ͻ��� ��������(������ ����ȯ/ ~ is a ~ Relation)
		// abstract class�� ��ü ���� �Ұ� �׷��� type ������ ????
		BusCharge02 bc1 = new Student02();
		BusCharge02 bc2 = new Adult02();
		BusCharge02 bc3 = new Old02();

		bc1.information();
		System.out.println(bc1.section);
		bc1.charge();

		bc2.information();
		System.out.println(bc2.section);
		bc2.charge();

		bc3.information();
		System.out.println(bc3.section);
		bc3.charge();

	}

}
