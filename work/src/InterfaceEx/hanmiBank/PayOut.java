package InterfaceEx.hanmiBank;

public interface PayOut {

	// interface Field(member variable) ==> public static final특성을 갖는다.
	public static final String payOut = "출금";

	// interface method ==> public abstract 특성을 갖는다.
	public abstract void payOut(int money);

}
