package concurrence_m.pratical.blockAndQuenue;

import com.sun.istack.internal.NotNull;

import java.util.Comparator;

public class CompareDemo {
    public static void main(String[] args) {
        Student student1=new Student(11);
        Student student2=new Student(111);

        useComparable(student1,student2);

        useComaprator(new Comparator<String>() {
            @Override
            public int compare(@NotNull String string1,@NotNull String string2) {

                if(string1==null||string2==null){
                    throw new NullPointerException();
                }
                int res=string1.length()-string2.length();
                if(res==0){
                    return 0;
                }else if(res>0){
                    return 1;
                }else{
                    return -1;
                }
            }
        },"23323","32323");
    }

    private static void useComparable(Comparable comparable1, Comparable comparable2) {
        int res = (comparable1.compareTo(comparable2));
        if (res > 0) {
            System.out.println("两者相等");
        } else if (res > 0) {
            System.out.println("comparable1 大于 comparable2");
        } else if (res < 0) {
            System.out.println("comparable1 小于 comparable2");
        }
    }

    private static void useComaprator(Comparator comparator, Object object1, Object object2) {
        int res = comparator.compare(object1, object2);
        if (res > 0) {
            System.out.println("两者相等");
        } else if (res > 0) {
            System.out.println("comparable1 大于 comparable2");
        } else if (res < 0) {
            System.out.println("comparable1 小于 comparable2");
        }
    }

    static class Student implements  Comparable<Student>{
        private int number;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Student(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(Student student) {
            if(student==null){
                throw new NullPointerException();
            }
            int number = student.getNumber();
            if(this.number > number){
                return 1;
            }else if(this.number ==number){
                return 0;
            }else{
                return -1;
            }
        }
    }
}


