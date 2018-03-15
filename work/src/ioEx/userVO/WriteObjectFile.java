package ioEx.userVO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObjectFile {

	public static void main(String[] args) throws Exception {

		// 1.instance�� File�� ������ SinkStream :: FileOutputStream ����
		// 2.instance�� �����ϴ� FilterStream : ObjectOutputStream ����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserInfo.obj"));

		oos.writeObject(new UserVO(1, "ȫ�浿")); // ==> API Ȯ��
		oos.writeObject(new UserVO(2, "ȫ���")); // ==> API Ȯ��

		// Stream close()
		oos.close();

	}

}
