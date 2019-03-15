package reusingClass.finalData;

public class Exercise20 {
}
class WithFinal{
    private void print(){
        System.out.println("withFinal");
    }
    final void print2(){
        System.out.println("withFinal");
    }
}
class OverridFinal extends WithFinal{
    //因为WithFinal中print方法为private，子类是无法取用的，所以Override无效，
    // 此时是重新创建了一个print方法，并没有覆盖父类的方法,是一个新的方法
    //@Override
    private void print(){
        System.out.println("OverridFinal");
    }
    //因为WithFinal中print2为final，所以无法覆盖prin2方法
    /*@Override
     void print2(){
         System.out.println("OverridFinal");
    }*/
}