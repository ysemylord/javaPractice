package reusingClass.finalData;

/**
 * final域要在定义处或者构造函数中赋值
 */
public class Exercise19 {
    public static void main(String[] args) {
        Data data1=new Data();
        Data data2=new Data("data2");
        System.out.println(data1.str);
        System.out.println(data2.str);
        //因为str为final,所以下面这句话会报错
        //data1.str="122";

    }
}
class Data{
    final String str;

    public Data(String str) {
        this.str = str;
    }

    public Data() {
        this.str="defalut";
    }
}
