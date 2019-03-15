import algorithm_m.threeAdapter.MyList;
import net.mindview.atunit.Test;

public class ListTest {

    @org.junit.Test
    public void testRemove() throws Exception {
        MyList myList = new MyList();
        myList.insertAsFisrt(1);
        myList.insertAsFisrt(2);
        myList.insertAsFisrt(3);
        myList.insertAsFisrt(4);
        MyList.ListNode p=myList.first();
        int count=0;
        while(p.succ!=null){

            if(count++%2==0){
                myList.remove(p);
            }
            p=p.succ;
        }
        System.out.println(myList.toString());
    }

    @org.junit.Test
    public void testFind() throws Exception {
        MyList myList = new MyList();
        myList.insertAsFisrt(1);
        myList.insertAsFisrt(2);
        myList.insertAsFisrt(3);
        myList.insertAsFisrt(4);

         MyList.ListNode listNode=myList.find(2,3,myList.last());
        System.out.println(listNode.data);
    }

    @org.junit.Test
    public void testInsert() {
        MyList myList = new MyList();
        myList.insertAsFisrt(1);
        myList.insertAsFisrt(2);
        myList.insertAsFisrt(3);
        myList.insertAsFisrt(4);
        System.out.println(myList.toString());

        System.out.println(myList.get(3).data);
    }


    @org.junit.Test
    public   void testInsertAsLast() {
        MyList myList = new MyList();
        myList.insertAsLast(1);
        myList.insertAsLast(2);
        myList.insertAsLast(3);
        myList.insertAsLast(4);
        System.out.println(myList.toString());
    }
}
