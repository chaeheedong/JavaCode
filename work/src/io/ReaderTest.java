package io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderTest {

	public static void main(String[] args) {

		try {

			// InputStream :: ǥ���Է���ġ �߻�ȭ�� class
			InputStream inputStream = System.in;
			// InputStream�� Reader�� ����(byte ó�� ==> ���� ó�� ���� )
			Reader reader = new InputStreamReader(inputStream);

			System.out.println("�Է��� ��ٸ��ϴ�...");

			// ���� �ϰŵ��̴� ���� loop�� ����.
			while (true) {

				// 1.java.io�� ����(block)�� �� �ִ�.
				int i = reader.read();
				char c = (char) i;

				// 2.java.io�� FIFO�� ����
				System.out.println("�Է��Ͻ� �� : " + c);

				// ==> char 'x'�� �ԷµǸ� while ����
				if (c == 'x') {
					inputStream.close();
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
