package modifierEx;

class TopSecret01 {

	// Field
	int secretNo = 7777;

	// Constructor
	public TopSecret01() {
	}

	// Method
	public int getSecretNo() {
		return secretNo;
	}

}// end of class

public class ModifierTest01 {

	public static void main(String[] args) {

		TopSecret01 topSecret = new TopSecret01();
		System.out.println(topSecret.secretNo);
		
		//==> secretNo 변경하면...
		topSecret.secretNo = 1234;
		System.out.println(topSecret.getSecretNo());
		
	}

}// end of class
