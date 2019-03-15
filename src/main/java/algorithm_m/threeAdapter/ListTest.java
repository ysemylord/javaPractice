package algorithm_m.threeAdapter;

import net.mindview.atunit.Test;

public class ListTest {
    public static void main(String[] args) {
       // testInsertAsLast();
        MyList myList=new MyList();
        myList.insertAsFisrt(1);
        myList.insertAsFisrt(2);
        myList.insertAsFisrt(3);
        myList.insertAsFisrt(4);
        System.out.println(myList.toString());

        System.out.println(myList.get(3).data);
    }


    private static void testInsertAsLast() {
        MyList myList=new MyList();
        myList.insertAsLast(1);
        myList.insertAsLast(2);
        myList.insertAsLast(3);
        myList.insertAsLast(4);
        System.out.println(myList.toString());
    }
}
