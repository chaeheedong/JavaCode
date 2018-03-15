package InterfaceEx.hanmiBank;

public interface Deposit {

	// interface Field(member variable) ==> public static final 특성을 갖는다.
	String deposit = "입금";

	// inferface method ==> public abstract특성을 갖는다.
	void deposit(int money);

}
