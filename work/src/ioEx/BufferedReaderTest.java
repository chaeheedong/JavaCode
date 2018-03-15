package ioEx;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTest {

	public static void main(String[] args) throws Exception {

		// read 수 count 위한 변수
		int readCount = 0;

		// SinkStream ==> 말단에서 단순 입출력만 담당
		FileReader fr = new FileReader(args[0]);
		// FilterStream ==> 추가적인 기능을 제공
		BufferedReader br = new BufferedReader(fr);

		// ==> 위의 두 line과 아래를 비교하자.
		// BufferedReader br = new BufferedReader(new FileReader(args[0]));

		String oneLine = null;

		while (true) {

			readCount++;

			oneLine = br.readLine(); // API 확인
			if (oneLine == null) { // API 확인
				break;
			}
			System.out.println("한줄 출력 : " + readCount + " " + oneLine);

		}

		// Stream close
		br.close();
		fr.close();

	}

}
