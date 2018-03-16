package collectionEx.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest{

	public static void main(String[] args) 
	{
	
		Map<String, String> map = new HashMap();

		String key = new String("홍길동");
		String value = new String("의적");
		map.put(key, value);

		// put(K key, V value) : 이 맵 내의 지정된 키에 지정된 값을 관련 짓습니다.
		map.put("이순신", "수군 대장군");
		map.put("주몽", "고구려시조");

		String value01 = map.get("주몽");
		System.out.println("주몽 설명 : " + value01);

		// containsKey(Object key) : 이 맵이 지정된 키의 매핑을 보관 유지하는 경우는 true를 돌려줍니다.
		if(map.containsKey("이순신")){

			// get(Object key) : 지정된 키가 맵되고있는 값을 돌려줍니다. 맵에 키에 대한 맵핑이없는 경우는 null를 돌려줍니다.
			System.out.println("이순신을 key로 갖는 value가 있으며 value : " + map.get("이순신"));

		}
		
		if(map.containsKey("김유신")){

			System.out.println("김유신을 key로 갖는 value가 있으며 value : " + map.get("김유신"));

		}

		// containsValue(Object value) : 맵이 1 개 또는 복수의 키를 지정된 값에 매핑하고있는 경우에 true를 리턴합니다.
		if(map.containsValue("의적")){

			System.out.println("의적을 value로 갖는 data가 있습니다.");

		}

		if(map.containsValue("도적")){

			System.out.println("도적을 value로 갖는 data가 있습니다.");

		}

	}

}
