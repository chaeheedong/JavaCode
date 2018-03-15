package ioEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTestFilter01 {

	public static void main(String[] args) throws IOException {

		// �ʿ䰴ü Stream / String �ν��Ͻ� declaration
		BufferedReader br = null;
		BufferedWriter bw = null;
		String fileName = "";
		String copyFileName = "";

		int readCount = 0; // read�� Count�ϱ� ���� ����

		System.out.print("copy�� file �̸��� �Է��ϼ��� : ");
		// copy�� FileName�� �Է¹ޱ�...
		fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

		// => ���� ���� Data�� read �� �� �ִ� BufferedReader ����
		br = new BufferedReader(new FileReader(fileName));

		// => �纻���� �̸� �����
		copyFileName = fileName + "_copy";
		// => Data�� write�� �� �ִ� BufferedWriter ����
		bw = new BufferedWriter(new FileWriter(copyFileName));

		// read / write �ϴ� while��
		String source = null;
		while ((source = br.readLine()) != null) {
			bw.write(source);
			readCount++;
		}
		bw.flush(); // ==> ���� �� ��

		// Stream close
		bw.close();
		br.close();

		System.out.println("===============");
		System.out.println("=====>>> read Ƚ�� readCount : " + readCount);
		System.out.println("===============");
	}

}
