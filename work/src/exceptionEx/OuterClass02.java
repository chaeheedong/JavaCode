package exceptionEx;

public class OuterClass02 {

	// Field
	private String outer = "outerClass�� Field";

	// Constructor
	public OuterClass02() {
	}

	// Method
	public void outerMethod() {
		System.out.println(":: " + this.getClass().getName() + " start...");

		final String localVariable = "OuterClass ���� outerMethod �� localVariable";

		// Inner local Class
		class innerLocalClass {

			// Field
			private String inner = "innerClass�� Field";

			// Constructor
			public innerLocalClass() {
			}

			// Method
			public void innerMethod() {
				System.out.println("==> " + this.getClass().getName() + " start...");
				// innerClass���� OuterClass�� �����ϱ�
				System.out.println(localVariable);
				System.out.println(outer);
				System.out.println(inner);
				System.out.println("==> " + this.getClass().getName() + " end...");
			}
		}

		System.out.println(":: " + this.getClass().getName() + " start...");

		// inner local class�� �ѷ��� method���� �ν��Ͻ� ��������
		InnerLocalClass ilc = new innerLocalClass();
		ilc.innerMethod();

	}

	public static void main(String[] args) {

		new OuterClass02().outerMethod();

	}

}
