package InterfaceEx.hanmiBank;

public abstract class Bank {

	// Field
	private String name;

	// Constructor
	public Bank() {
	}

	// Constructor
	public Bank(String name) {
		this.name = name;
	}

	// Method
	// ������� ����ϴ� display method�� �߻�Method�� ����
	public abstract void display();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
