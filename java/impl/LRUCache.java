public class LRUCache {
    private int size = 0;
	private Map<Object, Object> cache = null;
	private Queue<Object> keyQ = null;

	public LRUCache(int capacity) {
		size = capacity;
		cache = new HashMap<Object, Object>(capacity);
		keyQ = new LinkedList<Object>();
    }

    public Object get(Object key) {

    	Object val = cache.get(key);
    	if (val != null) {
    		//Cache Hit
    		keyQ.remove(key);//Remove the key from an old position.
    		keyQ.add(key);//Add to the tail end, in the access order.
    	}
    	return val;
    }

    public void put(Object key, Object value) {

    	if (cache.containsKey(key)) {
    		return;
    	}

    	if (cache.size() >= size) {
    		//Size limit reached. Evict the least used key
    		Object evictedKey = keyQ.remove();// The key at the head would be least used.
    		if (evictedKey != null) {
                //If the evicted key exist remove the key from the Map
    			cache.remove(evictedKey);
    		}
    	} else {
    		keyQ.add(key);//Add to the tail end, in the insertion order.
    	}
    	cache.put(key, value);
    }
}
