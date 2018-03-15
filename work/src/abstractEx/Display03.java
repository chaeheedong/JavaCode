package abstractEx;

abstract class BusCharge03 {

	// Field
	String section;

	// Constructor
	public BusCharge03() {
	}

	public BusCharge03(String section) {
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
class Student03 extends BusCharge03 {

	public Student03() {
		super("학생");
	}

	// ==> 아래의 Method 주석처리하고 컴파일시.. 컴파일 에러를 확인하자.
	@Override
	public void charge() {
		System.out.println("300원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의 (OverRiding)해야함 <== 강제성
class Adult03 extends BusCharge03 {

	public Adult03() {
		super("일반인");
	}

	@Override
	public void charge() {
		System.out.println("500원");
	}

}// end of class

// abstract class 상속시 abstract method 필히 재정의(OverRiding)해야함 <== 강제성
class Old03 extends BusCharge03 {

	public Old03() {
		super("어르신");
	}

	@Override
	public void charge() {
		System.out.println("공짜");
	}

}// end of class

public class Display03 {

	public static void main(String[] args) {

		// 상위 레퍼런스로 하위 인스턴스를 참조가능(묵시적 형변환/ ~ is a ~ Relation)
		// abstract class는 객체 생성 불가 그러나 type 선언은 ????
		BusCharge03 bc1 = new Student03();
		BusCharge03 bc2 = new Adult03();
		BusCharge03 bc3 = new Old03();

		bc1.information();
		System.out.println(bc1.section);
		bc1.charge();

		bc2.information();
		System.out.println(bc2.section);
		bc2.charge();

		bc3.information();
		System.out.println(bc3.section);
		bc3.charge();

		// ==> 위의 코딩과 아래의 코딩을 비교하면...
		// ==> 1. 반복된 부분은 없는가
		// ==> 2. 같은 Data Type 묶음(배열 : Array)을 이용하여 일괄적으로 관리할 수는 없는가.
		BusCharge03[] bc = new BusCharge03[3];
		bc[0] = new Student03();
		bc[1] = new Adult03();
		bc[2] = new Old03();

		for (int i = 0; i < bc.length; i++) {

			bc[i].information();
			System.out.println(bc[i].section);
			bc[i].charge();

		}

	}

}
