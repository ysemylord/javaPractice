package concurrence_m.pratical.blockAndQuenue;

/**
 * https://blog.csdn.net/XSF50717/article/details/39937085
 * 循环队列
 * 将向量空间想象为一个首尾相接的圆环，并称这种向量为循环向量。
 * 存储在其中的队列称为循环队列（Circular Queue）。
 * 即：循环队列中进行出队、入队操作时，头尾指针仍要加1，朝前移动。只不过当头尾指针指向向量上界（QueueSize-1）时，其加1操作的结果是指向向量的下界0。
 */
public class CircularQuenueDemo<T> {
    public static void main(String[] args) {
        CircularQuenueDemo sequencequenuedemo=new CircularQuenueDemo(10);
        int n=10;
        while(n-->0){
            sequencequenuedemo.put(new Object());
        }
        n=10;
        while(n-->0){
            sequencequenuedemo.get();
        }

        //不会出现出现"假上溢出"
        n=10;
        while(n-->0){
            sequencequenuedemo.put(new Object());
        }
        n=10;
        while(n-->0){
            sequencequenuedemo.get();
        }
    }



   private T[] items;
   private int head=0,tail=0,count=0,capacity;

    public CircularQuenueDemo(int capacity) {
        this.capacity = capacity;
        items= (T[]) new Object[capacity];
    }

    private void put(T object){
       if(count==items.length) {
           System.out.println("队列已满");
       }else{
           items[tail] = object;
           tail++;
           count++;
           if(tail>=items.length){//到达上界
               tail=0;
           }
           System.out.println("插入元素");
       }
   }
   private Object get(){
       Object item=null;
       if(count==0) {
           System.out.println("队列已空");
       }else {
           item = items[head];
           head++;
           count--;
           if(head>=items.length){//达到上街
               head=0;
           }
           System.out.println("取出元素");
       }
       return item;
   }
}
