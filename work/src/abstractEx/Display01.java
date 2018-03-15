package abstractEx;

abstract class BusCharge {

	// Field
	String section;

	// Constructor
	public BusCharge() {
	}

	public BusCharge(String section) {
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
class Student extends BusCharge {

	public Student() {
		super("�л�");
	}

	// ==> �Ʒ��� Method �ּ�ó���ϰ� �����Ͻ�.. ������ ������ Ȯ������.
	@Override
	public void charge() {
		System.out.println("300��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������ (OverRiding)�ؾ��� <== ������
class Adult extends BusCharge {

	public Adult() {
		super("�Ϲ���");
	}

	@Override
	public void charge() {
		System.out.println("500��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������(OverRiding)�ؾ��� <== ������
class Old extends BusCharge {

	public Old() {
		super("���");
	}

	@Override
	public void charge() {
		System.out.println("��¥");
	}

}// end of class

public class Display01 {

	public static void main(String[] args) {

		Student b1 = new Student();
		Adult b2 = new Adult();
		Old b3 = new Old();

		b1.information();
		System.out.println(b1.section);
		b1.charge();

		b2.information();
		System.out.println(b2.section);
		b2.charge();

		b3.information();
		System.out.println(b3.section);
		b3.charge();

		// ==> �Ʒ��� �ּ��� ������ Ǯ�� ������ ������ Ȯ������.
		// ==> 1. abstract class�� ��ü ���� �Ұ�
		// BusCharge bc01 = new BusCharge();

		// ==> 2. ��ü ������ �Ұ��ϳ�, ������ ����(Data Type)�� �����ϴ�.
		// BusCharge bc02;

	}

}
