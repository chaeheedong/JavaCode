package InterfaceEx.hanmiBank;

public class HanmiBank extends Bank implements PayOut, Deposit {

	// Field

	// Constructor
	public HanmiBank() {
	}

	public HanmiBank(String name) {
		super(name);
	}

	@Override
	public void deposit(int money) {
		System.out.println(money + "�� �Ա��մϴ�.");
	}

	@Override
	public void payOut(int money) {
		System.out.println(money + "�� ����մϴ�.");
	}

	@Override
	public void display() {
		System.out.println("����� : " + this.getName());
	}

	public static void main(String[] args) {

		HanmiBank hb = new HanmiBank("�ѹ�����");
		hb.display();
		hb.deposit(100);
		hb.payOut(200);

		// interface ���ο� ����� Field�ǹ̸� ��������.
		// interface�� Field�� Ȯ���ϰ�...
		System.out.println(Deposit.deposit); // static�� ���ٹ����?
		System.out.println(hb.payOut); // static�� ���ٹ����?

		// Field�� ���°��� �����غ���
		// Deposit.deposit = "�Ա�";
		// PayOut.payOut = "���";
		// ==> compile error �߻� interface�� ����Ǵ� ������ final static�� Ư¡�� ����
	}

}
