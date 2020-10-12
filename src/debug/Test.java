package debug;

public class Test {
    public static void main(String[] args) {
        int a = 2, b = 3;
        swap(a, b);
        System.out.println(a);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
