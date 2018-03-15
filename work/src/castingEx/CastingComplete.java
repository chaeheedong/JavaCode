package castingEx;

class Super {
	public void a() {
		System.out.println("Super : a()");
	}
}// end of class

class Sub extends Super {
	public void a() {
		System.out.println("overriding�� Sub : a()");
	}

	public void b() {
		System.out.println("sub : b()");
	}
}// end of class

public class CastingComplete {

	public static void main(String[] args) {

		// �ϳ� : ���� class �ν��Ͻ� ���� ( Data type == �ν��Ͻ��� ��� )
		System.out.println("\n����� Super s1 = new Super()�κ�");
		Super s1 = new Super();
		s1.a();

		// �ο� : ���� class �ν��Ͻ� ���� ( Data type == �ν��Ͻ��� ��� )
		System.out.println("\n����� Sub s2 = new Sub()�κ�");
		Sub s2 = new Sub();
		s2.a();
		s2.b();

		// ���� : ���� data type���� ���� �ν��Ͻ� ���� ( Data type != �ν��Ͻ� )
		System.out.println("\n����� Super s3 = new Sub()�κ�");
		Super s3 = new Sub(); // <=== ������ ����ȯ
		s3.a();
		// �Ʒ��� ������ error�� �߻��Ѵ�. s3�� b()�� ������ �� ���� ( �� ���� )
		// s3.b();

		// s3.a()�� ����Ϸ��� ==> casting ������ ��� (�� �ڽ��� �����º���(?))
		System.out.println("\n s3�� b()�� ���� �Ұ��ϴ�.");
		System.out.println("casting �����ڸ� �̿� Sub sub = (Sub)s3 ����� ����ȯ");
		Sub sub = (Sub) s3;
		sub.b();

		// �׿� : ���� data type���� ���� �ν��Ͻ� ���� ( Data type != �ν��Ͻ� )
		// error ���� ( ���� ���۷��� ������ ���� �ν��Ͻ��� ���۷��� �� �� ���� )
		// Sub s4 = new Sub();

	}

}
