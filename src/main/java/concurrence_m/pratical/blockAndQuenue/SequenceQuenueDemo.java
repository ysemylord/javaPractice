package concurrence_m.pratical.blockAndQuenue;

/**
 * https://blog.csdn.net/XSF50717/article/details/39937085
 * 顺序队列
 * 队列的顺序存储结构称为顺序队列，顺序队列实际上是运算受限的顺序表。
 * 缺陷：当队头追赶上队尾时，造成"假上溢"
 */
public class SequenceQuenueDemo<T> {
    public static void main(String[] args) {
        SequenceQuenueDemo sequenceQuenueDemo = new SequenceQuenueDemo(10);
        sequenceQuenueDemo.get();
        sequenceQuenueDemo.get();
        int n=12;
        while(n-->0) {
            sequenceQuenueDemo.put("123");
        }
        n=12;
        while(n-->0){
            sequenceQuenueDemo.get();
        }
    }


    private int capacity=0;
    private T[] items;
    private int head = 0, tail = 0;

    public SequenceQuenueDemo(int capacity) {
        this.capacity=capacity;
        this.items = (T[]) new Object[capacity];
    }
    public void put(T object) {
        if (tail < items.length) {//顺序队列未满
            items[tail] = object;
            tail++;
            System.out.println("插入元素");
        } else {
            System.out.println("队列已满");
        }
    }

    public Object get() {
        Object item = null;
        if (head < tail) {//队列不为空
            item = items[head];
            head++;
            System.out.println("取出元素");
        } else {
            System.out.println("队列已空");
        }
        return item;
    }
}
