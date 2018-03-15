package castingEx;

class Super {
	public void a() {
		System.out.println("Super : a()");
	}
}// end of class

class Sub extends Super {
	public void a() {
		System.out.println("overriding된 Sub : a()");
	}

	public void b() {
		System.out.println("sub : b()");
	}
}// end of class

public class CastingComplete {

	public static void main(String[] args) {

		// 하나 : 상위 class 인스턴스 생성 ( Data type == 인스턴스의 경우 )
		System.out.println("\n여기는 Super s1 = new Super()부분");
		Super s1 = new Super();
		s1.a();

		// 두울 : 하위 class 인스턴스 생성 ( Data type == 인스턴스의 경우 )
		System.out.println("\n여기는 Sub s2 = new Sub()부분");
		Sub s2 = new Sub();
		s2.a();
		s2.b();

		// 세엣 : 상위 data type으로 하위 인스턴스 생성 ( Data type != 인스턴스 )
		System.out.println("\n여기는 Super s3 = new Sub()부분");
		Super s3 = new Sub(); // <=== 묵시적 형변환
		s3.a();
		// 아래의 사항은 error가 발생한다. s3은 b()를 참조할 수 없다 ( 꼭 이해 )
		// s3.b();

		// s3.a()를 사용하려면 ==> casting 연산자 사용 (즉 자신의 원상태복귀(?))
		System.out.println("\n s3은 b()에 접근 불가하다.");
		System.out.println("casting 연산자를 이용 Sub sub = (Sub)s3 명시적 형변환");
		Sub sub = (Sub) s3;
		sub.b();

		// 네엣 : 하위 data type으로 상위 인스턴스 생성 ( Data type != 인스턴스 )
		// error 부위 ( 하위 레퍼런스 변수는 상위 인스턴스를 레퍼런스 할 수 없다 )
		// Sub s4 = new Sub();

	}

}
