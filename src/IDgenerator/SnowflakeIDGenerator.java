package IDgenerator;

/**
 * Twitter_Snowflake<br>
 * SnowFlake的结构如下(每部分用-分开):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1位标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0<br>
 * 41位时间截(毫秒级)，注意，41位时间截不是存储当前时间的时间截，而是存储时间截的差值（当前时间截 - 开始时间截)
 * 得到的值），这里的的开始时间截，一般是我们的id生成器开始使用的时间，由我们程序来指定的（如下下面程序IdWorker类的startTime属性）。41位的时间截，可以使用69年，年T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10位的数据机器位，可以部署在1024个节点，包括5位datacenterId和5位workerId<br>
 * 12位序列，毫秒内的计数，12位的计数顺序号支持每个节点每毫秒(同一机器，同一时间截)产生4096个ID序号<br>
 * 加起来刚好64位，为一个Long型。<br>
 * SnowFlake的优点是，整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞(由数据中心ID和机器ID作区分)，并且效率较高，经测试，SnowFlake每秒能够产生26万ID左右。
 */
public class SnowflakeIDGenerator {

    /** 开始时间戳 1970/1/1 8:0:0 = 0*/
    private final long startpoch = 1420041600000L; // 2015-01-01
    
    private final long workerIdBits = 5L;
    
    private final long datacenterIdBits = 5L;
    
    private final long sequenceBits =12L;
    
    /** 5位最大数据标识 = 31 */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    
    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);
    
    /** 各分段左移位数 */
    private final long workerIdShift = sequenceBits; // 12bits
    private final long datacenterIdShift = sequenceBits + workerIdBits; // 17bits
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits; // 22bits
    
    /** 工作机器ID(0~31) */
    private long workerId;
    /** 数据中心ID(0~31) */
    private long datacenterId;
    /** 毫秒内序列(0~4095) */
    private long sequence = 0L;
    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;
    
    public SnowflakeIDGenerator (long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    
    /** 下一个ID （ 线程安全）*/
    public synchronized long nextId() {
       long timestamp = timeGen(); // 生成当前时间戳
       
       if(timestamp<lastTimestamp){
           throw new RuntimeException(String.format("clock moved back, refusing to generate id for %d milliseconds ", lastTimestamp-timestamp));
       }
       if(lastTimestamp==timestamp){
           sequence = (sequence +1)&sequenceMask;
           // 毫秒内序列溢出？因为经过掩码？
           if(sequence==0){
               timestamp = tilNextMillis(timestamp);
           }
       // 时间戳改变，序列重置为0
       } else { 
           sequence=0;
       }
       lastTimestamp = timestamp;
       return ((timestamp-startpoch)<< timestampLeftShift)
               | (datacenterId<<datacenterIdShift)
               | (workerId << workerIdShift)
               | sequence;
    }
    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }
    public static void main(String[] args) {
        SnowflakeIDGenerator idGenerator = new SnowflakeIDGenerator(0, 0);
        for (int i =0; i<1000; i++){
            long id = idGenerator.nextId();
            System.out.println(id);
            System.out.println(Long.toBinaryString(id));
        }

    }

}