package io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderTest {

	public static void main(String[] args) {

		try {

			// InputStream :: 표준입력장치 추상화한 class
			InputStream inputStream = System.in;
			// InputStream을 Reader로 변경(byte 처리 ==> 문자 처리 변경 )
			Reader reader = new InputStreamReader(inputStream);

			System.out.println("입력을 기다립니다...");

			// 값을 일거들이는 무한 loop를 시작.
			while (true) {

				// 1.java.io는 지연(block)될 수 있다.
				int i = reader.read();
				char c = (char) i;

				// 2.java.io는 FIFO의 구조
				System.out.println("입력하신 값 : " + c);

				// ==> char 'x'가 입력되면 while 종료
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
