package collectionEx.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest{

	public static void main(String[] args) 
	{
	
		Map<String, String> map = new HashMap();

		String key = new String("ȫ�浿");
		String value = new String("����");
		map.put(key, value);

		// put(K key, V value) : �� �� ���� ������ Ű�� ������ ���� ���� �����ϴ�.
		map.put("�̼���", "���� ���屺");
		map.put("�ָ�", "��������");

		String value01 = map.get("�ָ�");
		System.out.println("�ָ� ���� : " + value01);

		// containsKey(Object key) : �� ���� ������ Ű�� ������ ���� �����ϴ� ���� true�� �����ݴϴ�.
		if(map.containsKey("�̼���")){

			// get(Object key) : ������ Ű�� �ʵǰ��ִ� ���� �����ݴϴ�. �ʿ� Ű�� ���� �����̾��� ���� null�� �����ݴϴ�.
			System.out.println("�̼����� key�� ���� value�� ������ value : " + map.get("�̼���"));

		}
		
		if(map.containsKey("������")){

			System.out.println("�������� key�� ���� value�� ������ value : " + map.get("������"));

		}

		// containsValue(Object value) : ���� 1 �� �Ǵ� ������ Ű�� ������ ���� �����ϰ��ִ� ��쿡 true�� �����մϴ�.
		if(map.containsValue("����")){

			System.out.println("������ value�� ���� data�� �ֽ��ϴ�.");

		}

		if(map.containsValue("����")){

			System.out.println("������ value�� ���� data�� �ֽ��ϴ�.");

		}

	}

}
