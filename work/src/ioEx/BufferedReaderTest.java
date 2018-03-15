package ioEx;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {

		// read �� count ���� ����
		int readCount = 0;

		// SinkStream ==> ���ܿ��� �ܼ� ����¸� ���
		FileReader fr = new FileReader(args[0]);
		// FilterStream ==> �߰����� ����� ����
		BufferedReader br = new BufferedReader(fr);

		// ==> ���� �� line�� �Ʒ��� ������.
		// BufferedReader br = new BufferedReader(new FileReader(args[0]));

		String oneLine = null;

		while (true) {

			readCount++;

			oneLine = br.readLine(); // API Ȯ��
			if (oneLine == null) { // API Ȯ��
				break;
			}
			System.out.println("���� ��� : " + readCount + " " + oneLine);

		}

		// Stream close
		br.close();
		fr.close();

	}

}
