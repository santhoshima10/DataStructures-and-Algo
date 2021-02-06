package hashmap;

public class HashMap<K,V> {
	
	private Object[] elements;
	
	private int size = 0;

	private double loadFactor = 0.75;
	
	//threshold = loadfactor * size of the array
	

	public int getSize() {
		return size;
	}
	
	public HashMap(){
		elements = new Object[16];
	}
	
	private void put(K key, V value, Object[] backingArray) {
		
		        //Hash the key
				// find the index
				// Store the entry into the array
		
		       // System.out.println("BackingArray Length"+backingArray.length);
				int hashcode = key.hashCode();
				int index = Math.abs(hashcode)%backingArray.length;
				Entry<K,V> entry = new Entry(hashcode,key, value);
				
				if(backingArray[index] == null) {
					
					backingArray[index]  = entry;
					
				}
				else {
					Entry<K,V> entryNode = (Entry<K,V>)backingArray[index];
					while(entryNode.getNext()!=null && entryNode != null) {
						entryNode = entryNode.getNext();
					}
					entryNode.setNext(entry);
					
				}
				size++;
				
				if(shouldGrowHashMap(backingArray)) {
					growHashMap();
				}
				

		
	}

	public void put(K key, V value) {
		
		put(key, value,elements);
				
	}

	private void growHashMap() {
		
		size = 0;
		
		Object[] newArray = new Object[elements.length * 2];
		Entry<K,V> entry = null;
		
		for(int i = 0; i < elements.length; i++) {
			entry = (Entry<K,V>) elements[i];
	
				while(entry!= null) {
					put(entry.getKey(), entry.getValue(), newArray);
					entry = entry.getNext();
					
				}
			
			
		}
		elements = newArray;
		System.out.println("After Grow "+elements.length);
	}

	private boolean shouldGrowHashMap(Object[] backingArray) {
		
		
		
		if(size > (loadFactor * backingArray.length)) {
			System.out.println("Before Grow "+backingArray.length);
			return true;
		}
		
		
		return false;
	}

	public Object get(K key) {
		//Hash the key
        // find the index
       // Store the entry into the array
		
		Object returnValue = null;
		int hashcode = key.hashCode();
		int index = Math.abs(hashcode)%elements.length;
		
		//System.out.println("Input :"+key);
		//System.out.println("Input HashCode :"+hashcode);
		//System.out.println("Index :"+index);
		
		Entry<K,V> node = (Entry<K,V>) elements[index];
		
		if(node == null) {
			return null;
		}
	
		//System.out.println(node.getValue());
		//System.out.println(node.getHashcode());
		//System.out.println(node.getKey());
		
		
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
		
        if(node == null) {
        	return;
        }
		
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
		size--;
		
		
	}
	
	

}
