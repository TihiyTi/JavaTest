import org.ejml.simple.SimpleMatrix;

public class MatrixTest {
    public MatrixTest() {

    }

    public static void main(String[] args) {
        SimpleMatrix dz = new SimpleMatrix(5,5);
        dz.setColumn(0, 0, 8, 30, 43, 65, 74);
        dz.setColumn(1, 0, 7, 44, 60, 97, 105);
        dz.setColumn(2, 0, 15, 38, 54, 100, 116);
        dz.setColumn(3, 0, 1, 15, 23, 15, -15);
        dz.setColumn(4, 0, 9, 29, 43, 68, 73);

        SimpleMatrix dx = new SimpleMatrix(5,5);
        dx.setColumn(0, 0, 1,1,3.6,5.4,7.2);
        dx.setColumn(1, 0, 3.54,3.54,5.31,10.62,15.93);
        dx.setColumn(2, 0, 1.75,3.5,7,10.5,14.2);
        dx.setColumn(3, 0, -1.75,1.775,3.5,8.75,12.25);
        dx.setColumn(4, 0, 3.42,6.84,8.55,11.97,13.68);

        DxMatrixFinder finder = new DxMatrixFinder(dx, dz);
        finder.getDx(dz).print(2,2);

    }
}
