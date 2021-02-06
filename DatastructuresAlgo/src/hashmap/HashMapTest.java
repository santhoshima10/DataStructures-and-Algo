package hashmap;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class HashMapTest {
	
	private static final int dataSet = 5000;

	@Test
	public void should_insert_and_retrieve_value() {
		
		HashMap<String,Integer> sut = new HashMap<>();
		
		sut.put("My First String",1);
		
		assertEquals(1, (int)sut.get("My First String"));
		
		assertEquals(1, sut.getSize());
		
	}
	
	@Test
	public void should_insert_and_retrieve_all_value() {
		
		HashMap<String,Integer> sut = new HashMap<>();
		
		sut.put("My First String",1);	
		assertEquals(1, sut.get("My First String"));
		
		sut.put("My Second String",2);	
		assertEquals(2, sut.get("My Second String"));
		
		sut.put("My Third String",3);	
		assertEquals(3, sut.get("My Third String"));
		
		sut.put("My Seventh String",7);	
		assertEquals(7, sut.get("My Seventh String"));
		
		assertEquals(4, sut.getSize());
		
	}
	
	@Test
	public void should_delete_value() {
		
		HashMap<String,Integer> sut = new HashMap<>();
		
		sut.put("My First String",1);
		
		assertEquals(1, sut.get("My First String"));
		
		sut.remove("My First String");
		
		assertEquals(null, sut.get("My First String"));
		
		
		sut.put("My Second String",2);	
		assertEquals(2, sut.get("My Second String"));
		
		sut.put("My Third String",3);	
		assertEquals(3, sut.get("My Third String"));
		
		
		sut.put("My Seventh String",7);	
		assertEquals(7, sut.get("My Seventh String"));
		
		
        sut.remove("My Seventh String");	
		assertEquals(null, sut.get("My Seventh String"));
		
		
	}
	
	@Test
	public void should_insert_and_delete_large_sets() {
		
		HashMap<Integer,Integer> sut = new HashMap<>();
		
		for(int i = 0;i < dataSet; i++) {
			sut.put(i, i+10);
		}
		
		for(int i = 0;i < dataSet; i++) {
			assertEquals(i+10,sut.get(i));
		}
		
		
		for(int i = 0;i < dataSet; i++) {
			sut.remove(i);
		    assertEquals(null,sut.get(i));
		}
		assertEquals(0, sut.getSize());
		
	}

}
;