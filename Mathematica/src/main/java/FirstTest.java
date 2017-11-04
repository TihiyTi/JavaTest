import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.MathLinkFactory;

public class FirstTest {
    static KernelLink ml;
    public static void main(String[] args) {
        String path = "-linkmode launch -linkname 'C:/Program Files/Wolfram Research/Mathematica/10.0/MathKernel'";
        try {
            ml = MathLinkFactory.createKernelLink(path);// подключаем ядро
            ml.discardAnswer();// дожидаемся загрузки ядра
            ml.evaluate("2+2");
            ml.waitForAnswer();
            int result = ml.getInteger();// считываем результат
            System.out.println("2 + 2 = " + result);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
