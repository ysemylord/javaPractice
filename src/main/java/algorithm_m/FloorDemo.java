package algorithm_m;

public class FloorDemo {
    public static void main(String[] args) {
        System.out.println(floor(10, 3));
        System.out.println(up(10,3));
    }

    /**
     * @param c 被除数
     * @param d 除数
     * @return
     */
    private static int floor(int c, int d) {
        int x = 0;
        c = c + 1;

        do {
            c = c - d;
            x++;
        } while (c > d);
        return x;
    }

    private static int up(int c,int d){
        int x = 0;
        int d2=0;

        while (c >d2){
            x++;
            d2 = d2+d;
        }
        return x;
    }
}
