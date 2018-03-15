package exceptionEx;

public class OuterClass02 {

	// Field
	private String outer = "outerClass의 Field";

	// Constructor
	public OuterClass02() {
	}

	// Method
	public void outerMethod() {
		System.out.println(":: " + this.getClass().getName() + " start...");

		final String localVariable = "OuterClass 내의 outerMethod 의 localVariable";

		// Inner local Class
		class innerLocalClass {

			// Field
			private String inner = "innerClass의 Field";

			// Constructor
			public innerLocalClass() {
			}

			// Method
			public void innerMethod() {
				System.out.println("==> " + this.getClass().getName() + " start...");
				// innerClass에서 OuterClass로 접근하기
				System.out.println(localVariable);
				System.out.println(outer);
				System.out.println(inner);
				System.out.println("==> " + this.getClass().getName() + " end...");
			}
		}

		System.out.println(":: " + this.getClass().getName() + " start...");

		// inner local class를 둘러싼 method에서 인스턴스 생성가능
		InnerLocalClass ilc = new innerLocalClass();
		ilc.innerMethod();

	}

	public static void main(String[] args) {

		new OuterClass02().outerMethod();

	}

}
