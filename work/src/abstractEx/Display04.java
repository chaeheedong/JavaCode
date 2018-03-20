package abstractEx;

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

		/// * << ����1 >> �Ʒ��� ������ �������� ��µȴ�.
		Student04 b1 = new Student04();
		Adult04 b2 = new Adult04();
		Old04 b3 = new Old04();

		b1.information();
		System.out.println(b1.section);
		b1.charge();

		b2.information();
		System.out.println(b2.section);
		b2.charge();

		b3.information();
		System.out.println(b3.section);
		b3.charge();
		// */

		/*
		 * << ���� 2 >> �Ʒ��� �������� ���� �߻� : �����Ͻ� ���� �ϳ� : ������ �߻��� ���� �ο� : ������ �ذ��Ͽ� ����� �� �� �ֵ���
		 * ������ �����Ұ� ==> ��Ʈ : CastingComplete.java�� ����°�� �������� / casting �����ڸ� ����� ������??
		 * Fee[] fee = new Fee[3]; fee[0] = new Student04(); fee[1] = new Adult04();
		 * fee[2] = new Old04();
		 * 
		 * for (int i = 0; i < fee.length; i++) { fee[i].information();
		 * System.out.print(fee[i].section); fee[i].charge();
		 */

	}

}
