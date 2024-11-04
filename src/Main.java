public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("in");
            int[] num = {1, 2, 3};
            System.out.println(num[3]);
            System.out.println("outttt");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("out");
    }

}

class A {
    public void display() {
        System.out.println("Class A");
    }
}


class B extends A{
    public void display() {
        System.out.println("Class B");
    }
}