package mathDemo;

public class triangleDemo {
    public static void main(String[] args) {
        //sin 30°
        System.out.println("sin30°--" + Math.sin(Math.PI / 6));
        //sin 60°
        System.out.println("sin60°--" + Math.sin(Math.PI / 3));

        //sin 90°
        System.out.println("sin60°--" + Math.sin(Math.PI / 2));


        System.out.println("asin(1/2)--" + (Math.asin(0.5)));

        System.out.println("asin(1/2) toDegrees--" + Math.toDegrees(Math.asin(0.5)));


        /**
         * 参考三角函数的四象限
         */
        System.out.println("atan(1,1)) toDegrees：" + Math.toDegrees(Math.atan2(1, 1)));
        System.out.println("atan(-1,1) toDegrees：" + Math.toDegrees(Math.atan2(-1, 1)));
        System.out.println("atan(-1,1) toDegrees：" + Math.toDegrees(Math.atan2(-1, 1)));
        System.out.println("atan(-1,-1) toDegrees：" + Math.toDegrees(Math.atan2(-1, -1)));


    }
}
