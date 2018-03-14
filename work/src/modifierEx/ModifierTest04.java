package modifierEx;

final class TopSecret04 {

	// Field
	// ==> access modifier를 활용한 information hiding
	// ==> final modifier를 활용한 수정불가
	private final int secretNo = 7777;

	// Constructor
	// ==> Access modifier를 통한 객체생성불가(private Constructor을 사용한 이유를 이해)
	public TopSecret04() {
	}

	// Method
	// getter Method
	// => method를 통해 조건을 충족할 경우만 secretNo를 return
	public int getSecretNo(int pwd) {
		if (pwd == 0) {
			return secretNo;
		} else {
			return 0;
		}
	}

	// static method를 이용한 instance return하게 하여 다른 class에서 사용가능함.
	// ==>managerNo를 인자로 받아 Instance를 return할 것인지를 판단하다.
	public static TopSecret04 getInstance(int managerNo) {
		if (managerNo == 1234) {
			return new TopSecret04();
		} else {
			return null;
		}
	}
}

public class ModifierTest04 {

	public static void main(String[] args) {

		// instance생성 불가로 static method를 통해 인스턴스 return받는다.
		// ==> 또한 instance를 return받는 경우도 조건(managerNo)을 충족해야 함.

		TopSecret04 topSecret = TopSecret04.getInstance(1234);
		System.out.println(topSecret.getSecretNo(0));

		// ==> ModifierTest01.class ~ ModifierTest04.class까지 변경하면서
		// ==> Access Modifier와 Modifier의 사용, 활용을 이해하자.

	}

}
