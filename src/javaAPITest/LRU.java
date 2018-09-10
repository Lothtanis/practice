package javaAPITest;

import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用LinkedHashMap 实现LRU
 * @author zwq
 *
 * @param <K>
 * @param <V>
 */
public class LRU<K,V> extends LinkedHashMap<K, V> implements Map<K, V> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final int maxQueue = 6;
            
    public LRU(int initialCapacity, float loadFactor, boolean accessOrder){
        super(initialCapacity, loadFactor, accessOrder);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > maxQueue){
            return true;
        }
        return false;
    };

    public static void main(String[] args) {
        
        
        LRU<Character, Integer> lru = new LRU<Character, Integer>( 16, 0.75f, true);

        String s = "abcdefghijkl";
        for (int i = 0; i < s.length(); i++) {
            lru.put(s.charAt(i), i);
        }
        System.out.println("LRU中key为h的Entry的值为： " + lru.get('h'));
        System.out.println("LRU的大小 ：" + lru.size());
        System.out.println("LRU ：" + lru);
        
    }

}
