import org.ejml.simple.SimpleMatrix;

// dz = dx * a
// b = a^-1
// returnDx = dzNew*b
public class DxMatrixFinder {
    SimpleMatrix dx;
    SimpleMatrix dz;
    SimpleMatrix a;
    SimpleMatrix b;

    public DxMatrixFinder(SimpleMatrix dx, SimpleMatrix dz){
        this.dz = dz;
        this.dx = dx;
        a = dx.solve(dz);
        b = a.invert();
    }
    public DxMatrixFinder(){
        dx = new SimpleMatrix(5,5);
        dz = new SimpleMatrix(5,5);

        dz.setColumn(0, 0, 8, 30, 43, 65, 74);
        dz.setColumn(1, 0, 7, 44, 60, 97, 105);
        dz.setColumn(2, 0, 15, 38, 54, 100, 116);
        dz.setColumn(3, 0, 1, 15, 23, 15, -15);
        dz.setColumn(4, 0, 9, 29, 43, 68, 73);

        dx.setColumn(0, 0, 1,1,3.6,5.4,7.2);
        dx.setColumn(1, 0, 3.54,3.54,5.31,10.62,15.93);
        dx.setColumn(2, 0, 1.75,3.5,7,10.5,14.2);
        dx.setColumn(3, 0, -1.75,1.775,3.5,8.75,12.25);
        dx.setColumn(4, 0, 3.42,6.84,8.55,11.97,13.68);

        a = dx.solve(dz);
        b = a.invert();
    }

    public void setDz(SimpleMatrix dz){
        this.dz = dz;
        a = dx.solve(dz);
        b = a.invert();
    }

    public SimpleMatrix getDx(SimpleMatrix dzNew){
        return dzNew.mult(b);
    }
}
