package collectionEx.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList();

		String value = new String("1 : ȫ�浿");
		// offer(E e) : �뷮 ������ �������� �ʰ�, ������ ��Ҹ� ��� ť�� ���� �� ���ִ� ����, ������ ��Ҹ��� ť�� �����մϴ�.
		queue.offer(value);
		queue.offer(new String("2 : �̼���"));
		queue.offer("3 : �ָ�");

		// poll() : ť�� ���θ� ��� �� �����մϴ�. ť�� �ϴ��� ���� null�� �����ݴϴ�.
		String str1 = (String) queue.poll();
		System.out.println(str1);

		// peek() : �� ť�� ���θ� �����ɴϴ� ��, �������� �ʽ��ϴ�. ť�� �ϴ��� ���� null�� �����ݴϴ�.
		String str2 = (String) queue.peek();
		System.out.println(str2);

		// ==> peek()�� null�� return�ϴ� ������ / null�� return�ϴ� ������ �̿� �ݺ���...
		while (queue.peek() != null) {

			String str3 = (String) queue.poll();
			System.out.println(str3);

		}

	}

}
