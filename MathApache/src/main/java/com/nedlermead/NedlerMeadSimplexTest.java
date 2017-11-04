package com.nedlermead;

import com.nedlermead.points.ArtemPoints;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NedlerMeadSimplexTest {
    public static void main(String[] args) {
        SimplexOptimizer optimizer = new SimplexOptimizer(-1, 1.0e-3);
        PointValuePair optimum = optimizer.optimize(new MaxEval(1000),new ObjectiveFunction(new TestFunction()),
                GoalType.MINIMIZE, new NelderMeadSimplex(4, 50),
                new InitialGuess(new double[]{0., 0., 0., 0.}));
        optimizer.getEvaluations();
        List<Double> result = Arrays.asList(ArrayUtils.toObject(optimum.getPoint()));
        result.stream().map(Math::round).forEach(System.out::println);
        System.out.println(""+ Arrays.toString(optimum.getPoint()));
        System.out.println("Пгрешность " + optimum.getValue());
    }

    private static class TestFunction implements MultivariateFunction{
//        private static double[][] points = new double[][]{{1,1},{1,5},{5,5}};

        private static List<Double[]> listPoints =  new ArrayList<>();

        public TestFunction() {
            listPoints.addAll(ArtemPoints.s3points1ShortE);
            listPoints.addAll(ArtemPoints.s3points2ShortE);
            listPoints.addAll(ArtemPoints.s3points3ShortE);
            listPoints.addAll(ArtemPoints.s3points4ShortE);
            listPoints.addAll(ArtemPoints.s3points5ShortE);
        }

        @Override
        public double value(double[] centerAndR) {
            return listPoints.stream().mapToDouble(i-> epsilon(i, centerAndR)).sum();
        }

        private double epsilon(Double[] point, double[] centerAndR){
            double[] center = Arrays.copyOf(centerAndR,3);
            double r = centerAndR[3];
//            System.arraycopy(centerAndR, 0, center, 0, 2);
            double val = Math.sqrt((point[0]-center[0])*(point[0]-center[0])+
                    (point[1]-center[1])*(point[1]-center[1])+(point[2]-center[2])*(point[2]-center[2]));
            return (val - r)*(val - r);
        }
    }
}
