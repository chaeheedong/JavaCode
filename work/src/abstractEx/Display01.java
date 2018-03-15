package abstractEx;

abstract class BusCharge {

	// Field
	String section;

	// Constructor
	public BusCharge() {
	}

	public BusCharge(String section) {
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
class Student extends BusCharge {

	public Student() {
		super("학생");
	}

	// ==> 아래의 Method 주석처리하고 컴파일시.. 컴파일 에러를 확인하자.
	@Override
	public void charge() {
		System.out.println("300원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의 (OverRiding)해야함 <== 강제성
class Adult extends BusCharge {

	public Adult() {
		super("일반인");
	}

	@Override
	public void charge() {
		System.out.println("500원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의(OverRiding)해야함 <== 강제성
class Old extends BusCharge {

	public Old() {
		super("어르신");
	}

	@Override
	public void charge() {
		System.out.println("공짜");
	}

}// end of class

public class Display01 {

	public static void main(String[] args) {

		Student b1 = new Student();
		Adult b2 = new Adult();
		Old b3 = new Old();

		b1.information();
		System.out.println(b1.section);
		b1.charge();

		b2.information();
		System.out.println(b2.section);
		b2.charge();

		b3.information();
		System.out.println(b3.section);
		b3.charge();

		// ==> 아래의 주석을 차레로 풀어 컴파일 에러를 확인하자.
		// ==> 1. abstract class는 객체 생성 불가
		// BusCharge bc01 = new BusCharge();

		// ==> 2. 객체 생성은 불가하나, 변수의 선언(Data Type)은 가능하다.
		// BusCharge bc02;

	}

}
