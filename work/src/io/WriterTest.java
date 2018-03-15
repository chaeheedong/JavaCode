package io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class WriterTest {

	public static void main(String[] args) {

		try {

			// InputStream :: ǥ���Է���ġ �߻�ȭ�� class
			InputStream inputStream = System.in;
			// ����ó���� ���� Reader�� ����
			Reader reader = new InputStreamReader(inputStream);

			// OutputStream :: ǥ�������ġ �߻�ȭ�� class
			OutputStream outputStream = System.out;
			// ����ó���� ���� Writer�� ����
			Writer writer = new OutputStreamWriter(outputStream);

			System.out.println("�Է��� ��ٸ��ϴ�...");

			while (true) {

				int i = reader.read();
				writer.write(i);
				writer.flush();

				if ((char) i == 'x') {
					break;
				}

			}
			// ==> while�� ������ flush()�� ���� flush()�� �ǹ̴�?
			// w.flush();

			// Stream close()
			reader.close();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
