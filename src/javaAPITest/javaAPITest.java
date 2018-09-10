package javaAPITest;

import java.nio.ByteBuffer;


public class javaAPITest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(0, 12L);  
        
        byte[] bytes = buffer.array();   
        System.out.println(bytes); 
        buffer.clear();
        buffer.put(bytes, 0, bytes.length);    
        buffer.flip();//need flip     
        System.out.println(buffer.getLong()); 
        
    }

}
