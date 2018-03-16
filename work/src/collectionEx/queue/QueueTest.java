package collectionEx.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList();

		String value = new String("1 : 홍길동");
		// offer(E e) : 용량 제한을 위반하지 않고, 지정된 요소를 즉시 큐에 삽입 할 수있는 경우는, 지정된 요소를이 큐에 삽입합니다.
		queue.offer(value);
		queue.offer(new String("2 : 이순신"));
		queue.offer("3 : 주몽");

		// poll() : 큐의 선두를 취득 해 삭제합니다. 큐가 하늘의 경우는 null를 돌려줍니다.
		String str1 = (String) queue.poll();
		System.out.println(str1);

		// peek() : 이 큐의 선두를 가져옵니다 만, 삭제하지 않습니다. 큐가 하늘의 경우는 null를 돌려줍니다.
		String str2 = (String) queue.peek();
		System.out.println(str2);

		// ==> peek()이 null을 return하는 시점은 / null을 return하는 시점을 이용 반복문...
		while (queue.peek() != null) {

			String str3 = (String) queue.poll();
			System.out.println(str3);

		}

	}

}
