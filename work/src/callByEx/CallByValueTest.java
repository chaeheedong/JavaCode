package callByEx;

public class CallByValueTest {

	// Field
	int number = 100;

	// Method
	public void valueChange(int value) {
		System.out.println("===============");
		value += 100;
		System.out.println("value : " + value);
		System.out.println("===============");
	}

	public static void main(String[] args) {

		CallByValueTest call = new CallByValueTest();

		// method의 인자 값으로 int (primitive Data Type)
		call.valueChange(call.number);
		System.out.println("number : " + call.number);

	}

}
