package ioEx;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {

		// File을 읽어 들이는 Stream선언
		FileReader fr = null;
		// read()수 count 위한 변수
		int readCount = 0;

		try {

			fr = new FileReader(args[0]);

			while (true) {
				int i = fr.read();

				if (i == -1) { // i = -1의 의미는 ==> API 확인할 것
					break;
				}

				char c = (char) i;
				System.out.print(c);

				readCount++;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			System.out.println("\n\n===============");
			System.out.println("=====>>> read 횟수 readCount : " + readCount);
			System.out.println("===============");
			try {
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
