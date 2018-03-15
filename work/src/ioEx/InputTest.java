package ioEx;

import java.io.InputStream;

public class InputTest {

	public static void main(String[] args) {

		// InputStream :: ǥ���Է���ġ �߻�ȭ�� class
		InputStream inputStream = System.in;

		System.out.print("�Է��� ��ٸ��ϴ�...");

		try {

			// ���� �о���̴� ���� loop ����
			while (true) {

				// 1.java.io�� ����(block)�� �� �ִ�.
				int i = inputStream.read();
				char c = (char) i;

				// 2.java.io�� FIFO�� ����
				System.out.println("�Է��Ͻ� �� : " + c);

				// ==> char 'x'�� �ԷµǸ� while����
				if (c == 'x') {
					inputStream.close();
					break;
				}
				// �ѱ� �Է½� ������... �ѱ� 1EA�� 2�� ����� ���� Ȯ������
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
