package reusingClass.initBaseClass;

public class ExerciseMy {
    public static void main(String[] args) {
        Student student=new Student();
        student.name="eee";
        System.out.println(student.getName());
        student.setName("aaa");
        System.out.println(student.getName());
    }
}
class Person{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person{
    String name;

}