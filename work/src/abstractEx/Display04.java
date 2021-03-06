package abstractEx;

class BusCharge04 {

	// Field
	String section;

	// Constructor
	public BusCharge04() {
	}

	public BusCharge04(String section) {
		this.section = section;
	}

	// method
	public void information() {
		System.out.println("버스요금안내");
	}

} // end of class

interface Fee {

	public void charge();

}

// abstract class 상속시 abstract method 필히 재정의 (OverRidng)해야함 <== 강제성
class Student04 extends BusCharge04 implements Fee {

	public Student04() {
		super("학생");
	}

	@Override
	public void charge() {
		System.out.println("300원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의 (OverRiding)해야함 <== 강제성
class Adult04 extends BusCharge04 implements Fee {

	public Adult04() {
		super("일반인");
	}

	@Override
	public void charge() {
		System.out.println("500원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의(OverRiding)해야함 <== 강제성
class Old04 extends BusCharge04 implements Fee {

	public Old04() {
		super("어르신");
	}

	@Override
	public void charge() {
		System.out.println("공짜");
	}

}// end of class

public class Display04 {

	public static void main(String[] args) {

		/// * << 구현1 >> 아래의 구현은 문제없이 출력된다.
		Student04 b1 = new Student04();
		Adult04 b2 = new Adult04();
		Old04 b3 = new Old04();

		b1.information();
		System.out.println(b1.section);
		b1.charge();

		b2.information();
		System.out.println(b2.section);
		b2.charge();

		b3.information();
		System.out.println(b3.section);
		b3.charge();
		// */

		/*
		 * << 구현 2 >> 아래의 구현에서 문제 발생 : 컴파일시 에러 하나 : 문제가 발생한 이유 두울 : 문제를 해결하여 출력이 될 수 있도록
		 * 구현을 수정할것 ==> 힌트 : CastingComplete.java의 세번째를 이해하자 / casting 연산자를 사용한 이유는??
		 * Fee[] fee = new Fee[3]; fee[0] = new Student04(); fee[1] = new Adult04();
		 * fee[2] = new Old04();
		 * 
		 * for (int i = 0; i < fee.length; i++) { fee[i].information();
		 * System.out.print(fee[i].section); fee[i].charge();
		 */

	}

}
