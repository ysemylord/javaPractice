package string;

public class EX2_addreddInToString {
    public static void main(String[] args) {
        InfiniteRecursion infiniteRecursion=new InfiniteRecursion();
        infiniteRecursion.toString();
    }
}
class InfiniteRecursion {
    @Override
    public String toString() {
        return "InfiniteRecursion{}"+super.toString();
    }
}