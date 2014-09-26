import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class CorrelationTest {
    public static void main(String[] args) {
        PearsonsCorrelation cor = new PearsonsCorrelation();
        double a[] =  new double[]{1,2,3,4,5,4,3,2,1};
        double b[] =  new double[]{2,2,4,4,6,4,4,2,2};
        System.out.println("PearsonCorrelation");
        System.out.println(cor.correlation(a, b));
        AifCorrelation myCor = new AifCorrelation();
        System.out.println("MyCorrelation");
        double[] result = myCor.correlation(a, b);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println(myCor.koeffCorrellation(a,b));
    }
}
