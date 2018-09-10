package JavaCassicalAlgorithm;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.FactoryConfigurationError;

public class CacheLRU<K, V> {
    private int capacity;
    private LinkedHashMap<K, V> map;
    private float factor = 0.75f; 
    
    public CacheLRU (int capacity){
        this.capacity = capacity;
        this.map = new LinkedHashMap<K, V>(capacity,factor,true){
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size()>CacheLRU.this.capacity;
            }
        };
    }

    public synchronized V get(K key){
        return map.get(key);
    }
    
    public synchronized void put(K key, V value){
        map.put(key, value);
    }
    
    public synchronized void clear(){
        map.clear();
    }
    
    public synchronized int usedSize(){
        return map.size();
    }
    
    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
          System.out.print(entry.getValue() + "--");
        }
        System.out.println();
      }
    
    
    public static void main(String[] args) {
        CacheLRU test = new CacheLRU<Integer,Integer>(8);
        for(int i=0;i<30;i++){
            int j = (int) Math.floor(Math.random()*15);
            System.out.println(j);
            test.put(j, j);
            test.print();
        }
    }

}
