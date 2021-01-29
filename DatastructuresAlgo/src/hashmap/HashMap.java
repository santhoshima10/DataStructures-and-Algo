package hashmap;

public class HashMap<K,V> {
	
	private Object[] elements;
	
	public HashMap(){
		elements = new Object[15];
	}

	public void put(K key, V value) {
		
		
		//Hash the key
		// find the index
		// Store the entry into the array
		int hashcode = key.hashCode();
		int index = Math.abs(hashcode)%elements.length;
		Entry<K,V> entry = new Entry(hashcode, key, value);
		
		if(elements[index] == null) {
			
			elements[index]  = entry;
			
		}
		else {
			Entry<K,V> entryNode = (Entry<K,V>)elements[index];
			while(entryNode.getNext()!=null && entryNode != null) {
				entryNode = entryNode.getNext();
			}
			entryNode.setNext(entry);
			
		}
		
		
	}

	public Object get(K key) {
		//Hash the key
        // find the index
       // Store the entry into the array
		Object returnValue = null;
		int hashcode = key.hashCode();
		int index = Math.abs(hashcode)%elements.length;
		
		Entry<K,V> node = (Entry<K,V>) elements[index];
		
		if(node == null) {
			return null;
		}
	//	System.out.println("Input :"+key);
	//	System.out.println(node.getValue());
	//	System.out.println(node.getHashcode());
	//	System.out.println(node.getKey());
	//	System.out.println(hashcode);
		
		if((node.getKey().equals(key)) && (hashcode==node.getHashcode())) {
			
			
			returnValue = node.getValue();
			
			
		}
		else {
			
			while(node.getNext()!=null) {
				
			//	System.out.println("Else "+node.getKey());
				
				if((node.getKey().equals(key)) && (hashcode==node.getHashcode())) {
					returnValue = node.getValue();
					break;
				}
				node = node.getNext();
				
			}
			if((node.getKey().equals(key)) && (hashcode==node.getHashcode())) {
				returnValue = node.getValue();
	
			}
			
		}
		
		//System.out.println("returnValue"+returnValue);
		
		return returnValue;
	}

	public void remove(K key) {
		//Hash the key
        // find the index
       //Find the node from the Array based on the index
		
		int hashcode = key.hashCode();
		int index = Math.abs(hashcode)%elements.length;
		
		Entry<K,V> node = (Entry<K,V>) elements[index];
		Entry<K,V> prev = null;
		

		
		if((node.getKey().equals(key)) && (hashcode==node.getHashcode())) {
			
			
			if (node.getNext() != null)
			{
				elements[index] = node.getNext();

			}
			else {
				elements[index] = null;
			}
			
			
		}
		else {
			
			while(node.getNext()!= null) {
				
				
				if((node.getKey().equals(key)) && (hashcode==node.getHashcode())) {
					prev.setNext(node.getNext());
					break;
				}
				
				prev = node;
				node = node.getNext();
				
			}
			
			if((node.getKey().equals(key)) && (hashcode==node.getHashcode())) {
				prev.setNext(node.getNext());
				
			}
			
		}
		
		
		
	}
	
	

}
