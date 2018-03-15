package ioEx.userVO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObjectFile {

	public static void main(String[] args) throws Exception {

		// 1.File에서 instance를 읽을 SinkStream :: FileInputStream생성
		// 2.instance를 읽는 FilterStream : ObjectInputStream 생성
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UserInfo.obj"));

		UserVO user01 = (UserVO) ois.readObject(); // ==> API 확인 ==> 명시적인 형변환이유?
		UserVO user02 = (UserVO) ois.readObject(); // ==> API 확인 ==> 명시적인 형변환이유?

		System.out.println("1번째 회원정보 :: " + user01);
		System.out.println("2번째 회원정보 :: " + user02);

		// Stream close();
		ois.close();

	}

}
