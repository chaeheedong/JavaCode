package abstractEx;

abstract class BusCharge02 {

	// Field
	String section;

	// Constructor
	public BusCharge02() {
	}

	public BusCharge02(String section) {
		this.section = section;
	}

	// method
	public void information() {
		System.out.println("버스요금안내");
	}

	// ==> 사용되지 않으며, 하위클래스에 OverRiding을 가제하는 추상메서드 정의
	// public void charge() {
	// System.out.println("학생 : 300, 일반인 : 500, 어르신 : 공짜");
	// }

	public abstract void charge();

} // end of class

// abstract class 상속시 abstract method 필히 재정의 (OverRidng)해야함 <== 강제성
class Student02 extends BusCharge02 {

	public Student02() {
		super("학생");
	}

	// ==> 아래의 Method 주석처리하고 컴파일시.. 컴파일 에러를 확인하자.
	@Override
	public void charge() {
		System.out.println("300원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의 (OverRiding)해야함 <== 강제성
class Adult02 extends BusCharge02 {

	public Adult02() {
		super("일반인");
	}

	@Override
	public void charge() {
		System.out.println("500원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의(OverRiding)해야함 <== 강제성
class Old02 extends BusCharge02 {

	public Old02() {
		super("어르신");
	}

	@Override
	public void charge() {
		System.out.println("공짜");
	}

}// end of class

public class Display02 {

	public static void main(String[] args) {

		// 상위 레퍼런스로 하위 인스턴스를 참조가능(묵시적 형변환/ ~ is a ~ Relation)
		// abstract class는 객체 생성 불가 그러나 type 선언은 ????
		BusCharge02 bc1 = new Student02();
		BusCharge02 bc2 = new Adult02();
		BusCharge02 bc3 = new Old02();

		bc1.information();
		System.out.println(bc1.section);
		bc1.charge();

		bc2.information();
		System.out.println(bc2.section);
		bc2.charge();

		bc3.information();
		System.out.println(bc3.section);
		bc3.charge();

	}

}
