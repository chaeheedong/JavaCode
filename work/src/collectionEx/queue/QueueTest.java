package collectionEx.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList();

		String value = new String("1 : 홍길동");
		queue.offer(value);
		queue.offer(new String("2 : 이순신"));
		queue.offer("3 : 주몽");

		String str1 = (String) queue.poll();
		System.out.println(str1);

		String str2 = (String) queue.peek();
		System.out.println(str2);

		// ==> peek()이 null을 return하는 시점은 / null을 return하는 시점을 이용 반복문...
		while (queue.peek() != null) {

			String str3 = (String) queue.poll();
			System.out.println(str3);

		}

	}

}
