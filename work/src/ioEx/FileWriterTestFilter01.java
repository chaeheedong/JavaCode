package ioEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterTestFilter01 {

	public static void main(String[] args) throws IOException {

		// 필요객체 Stream / String 인스턴스 declaration
		BufferedReader br = null;
		BufferedWriter bw = null;
		String fileName = "";
		String copyFileName = "";

		int readCount = 0; // read를 Count하기 위한 변수

		System.out.print("copy할 file 이름을 입력하세요 : ");
		// copy할 FileName을 입력받기...
		fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

		// => 원본 파일 Data를 read 할 수 있는 BufferedReader 생성
		br = new BufferedReader(new FileReader(fileName));

		// => 사본파일 이름 만들기
		copyFileName = fileName + "_copy";
		// => Data를 write할 수 있는 BufferedWriter 생성
		bw = new BufferedWriter(new FileWriter(copyFileName));

		// read / write 하는 while문
		String source = null;
		while ((source = br.readLine()) != null) {
			bw.write(source);
			readCount++;
		}
		bw.flush(); // ==> 잊지 말 것

		// Stream close
		bw.close();
		br.close();

		System.out.println("===============");
		System.out.println("=====>>> read 횟수 readCount : " + readCount);
		System.out.println("===============");
	}

}
