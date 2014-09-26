public class MyNativeTest {
    static{
        System.loadLibrary("mynativetest");
    }
    private native void sayHello();
    private native int summa(int a, int b);

    public static void main(String[] args) {
        MyNativeTest test = new MyNativeTest();
        test.sayHello();
        System.out.println(test.summa(1,3));
    }
}
