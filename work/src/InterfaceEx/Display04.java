package InterfaceEx;

class BusCharge04 {

	// Field
	String section;

	// Constructor
	public BusCharge04() {
	}

	public BusCharge04(String section) {
		this.section = section;
	}

	// method
	public void information() {
		System.out.println("������ݾȳ�");
	}

} // end of class

// charge()�� ������ interface
// ==> ����� ����(��ɸ� �����Ͽ� �����Ѵٸ�...) : ����ö, �װ�, �ý� ��ݿ��� ��밡��
interface Fee {
	public void charge();
}

// abstract class ��ӽ� abstract method ���� ������ (OverRidng)�ؾ��� <== ������
class Student04 extends BusCharge04 implements Fee {

	public Student04() {
		super("�л�");
	}

	@Override
	public void charge() {
		System.out.println("300��");
	}

	// ==> �Ʒ��� Method �ּ�ó���ϰ� �����Ͻ�.. ������ ������ Ȯ������.

}// end of class

// abstract class ��ӽ� abstract method ���� ������ (OverRiding)�ؾ��� <== ������
class Adult04 extends BusCharge04 implements Fee {

	public Adult04() {
		super("�Ϲ���");
	}

	@Override
	public void charge() {
		System.out.println("500��");
	}

}// end of class

// abstract class ��ӽ� abstract method ���� ������(OverRiding)�ؾ��� <== ������
class Old04 extends BusCharge04 implements Fee {

	public Old04() {
		super("���");
	}

	@Override
	public void charge() {
		System.out.println("��¥");
	}

}// end of class

public class Display04 {

	public static void main(String[] args) {

		/// * <<����1>> �Ʒ��� ������ �������� ��µȴ�.
		Student04 bc1 = new Student04();
		Adult04 bc2 = new Adult04();
		Old04 bc3 = new Old04();

		bc1.information();
		System.out.println(bc1.section);
		bc1.charge();

		bc2.information();
		System.out.println(bc2.section);
		bc2.charge();

		bc3.information();
		System.out.println(bc3.section);
		bc3.charge();
		// */

		/*
		 * <<���� 2 >> �Ʒ��� �������� ���� �߻� : �����Ͻ� ���� // �ϳ� : ������ �߻��� ���� // �ο� : ������ �ذ��Ͽ� ����� ��
		 * �� �ֵ��� ������ ������ �� // ==> ��Ʈ : CastingComplete.java�� ����°�� �������� / casting�����ڸ� �����
		 * ������?? Fee[] fee = new Fee[3]; fee[0] = new Student04(); fee[1] = new
		 * Adult04(); fee[2] = new Old04();
		 * 
		 * for (int i = 0; i < fee.length; i++) { fee[i].information();
		 * System.out.println(fee[i].section); fee[i].charge();
		 */
	}
}
