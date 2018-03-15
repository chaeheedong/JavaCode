package callByEx;

public class CallByReferenceTest {

	// Field
	int number = 100;

	// Method
	public void referenceChange(CallByReferenceTest value) {
		System.out.println("===============");
		value.number = 100 + value.number;
		System.out.println("value.number : " + value.number);
		System.out.println("===============");
	}

	public static void main(String[] args) {

		CallByReferenceTest call = new CallByReferenceTest();

		// method의 인자 값으로 call(Reference Data Type)
		call.referenceChange(call);
		System.out.println("call.number : " + call.number);

	}

}
