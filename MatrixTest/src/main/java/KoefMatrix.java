import org.ejml.simple.SimpleMatrix;

public class KoefMatrix {
    SimpleMatrix x = new SimpleMatrix();
    SimpleMatrix x2 = new SimpleMatrix();
    SimpleMatrix z = new SimpleMatrix();
    SimpleMatrix a = new SimpleMatrix();
    SimpleMatrix a2 = new SimpleMatrix();

    public KoefMatrix(){
        x = new SimpleMatrix(5,5);
        x.setColumn(0, 0, 1,2,3,4,5);
        x.setColumn(1, 0, 1,1,2,3,4);
        x.setColumn(2, 0, 1,2,3,5,6);
        x.setColumn(3, 0, 2,3,4,5,6);
        x.setColumn(4, 0, 1,2,4,5,6);

        x2 = new SimpleMatrix(5,5);
        x2.setColumn(0, 0, 5*1,5*2,5*3,5*4, 5*5);
        x2.setColumn(1, 0, 1,1,2,3,4);
        x2.setColumn(2, 0, 1,2,3,5,6);
        x2.setColumn(3, 0, 2,3,4,5,6);
        x2.setColumn(4, 0, 1,2,4,5,6);

        z = new SimpleMatrix(5,1);
        z.setColumn(0, 0, 5*1, 5*1, 5*2, 5*3, 5*4);
    }

    public static void main(String[] args) {
        KoefMatrix koefMatrix = new KoefMatrix();
        SimpleMatrix a = koefMatrix.x.solve(koefMatrix.z);
        System.out.println("A");
        a.print(2,1);
        SimpleMatrix a2 = koefMatrix.x2.solve(koefMatrix.z);
        System.out.println("A2");
        a2.print(2,1);


//        SimpleMatrix a2 = koefMatrix.x2.solve(koefMatrix.z);
//        System.out.println("A2");
//        a2.print(2,1);

    }
}
