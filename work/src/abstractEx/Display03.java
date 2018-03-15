package abstractEx;

abstract class BusCharge03 {

	// Field
	String section;

	// Constructor
	public BusCharge03() {
	}

	public BusCharge03(String section) {
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
class Student03 extends BusCharge03 {

	public Student03() {
		super("�л�");
	}

	// ==> �Ʒ��� Method �ּ�ó���ϰ� �����Ͻ�.. ������ ������ Ȯ������.
	@Override
	public void charge() {
		System.out.println("300��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������ (OverRiding)�ؾ��� <== ������
class Adult03 extends BusCharge03 {

	public Adult03() {
		super("�Ϲ���");
	}

	@Override
	public void charge() {
		System.out.println("500��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������(OverRiding)�ؾ��� <== ������
class Old03 extends BusCharge03 {

	public Old03() {
		super("���");
	}

	@Override
	public void charge() {
		System.out.println("��¥");
	}

}// end of class

public class Display03 {

	public static void main(String[] args) {

		// ���� ���۷����� ���� �ν��Ͻ��� ��������(������ ����ȯ/ ~ is a ~ Relation)
		// abstract class�� ��ü ���� �Ұ� �׷��� type ������ ????
		BusCharge03 bc1 = new Student03();
		BusCharge03 bc2 = new Adult03();
		BusCharge03 bc3 = new Old03();

		bc1.information();
		System.out.println(bc1.section);
		bc1.charge();

		bc2.information();
		System.out.println(bc2.section);
		bc2.charge();

		bc3.information();
		System.out.println(bc3.section);
		bc3.charge();

		// ==> ���� �ڵ��� �Ʒ��� �ڵ��� ���ϸ�...
		// ==> 1. �ݺ��� �κ��� ���°�
		// ==> 2. ���� Data Type ����(�迭 : Array)�� �̿��Ͽ� �ϰ������� ������ ���� ���°�.
		BusCharge03[] bc = new BusCharge03[3];
		bc[0] = new Student03();
		bc[1] = new Adult03();
		bc[2] = new Old03();

		for (int i = 0; i < bc.length; i++) {

			bc[i].information();
			System.out.println(bc[i].section);
			bc[i].charge();

		}

	}

}
