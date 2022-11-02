import java.io.*;
import java.util.Scanner;
public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public MyPolynomial(String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename)); // open file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int degree = in.nextInt(); // read the degree
        coeffs = new double[degree + 1]; // allocate the array
        for (int i = 0; i < coeffs.length; ++i) {
            coeffs[i] = in.nextDouble();
        }
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < coeffs.length; i++) {
            if (i > 0) {
                if (i < coeffs.length -1 && coeffs[i+1] >= 0) {
                    s = " + " + s;
                }
                if (i == 1) {
                    s = "x" + s;
                } else {
                    s = "x^" + i + " " + s;
                }
            }
            s = coeffs[i] + s;
        }
        return s;
    }

    public double evaluate(double x) {
        double accum = 0;
        for (int i = 0; i < coeffs.length; i++) {
            accum += coeffs[i] * Math.pow(x, i);

        }
        return accum;

    }

    public MyPolynomial add(MyPolynomial poly) {
        MyPolynomial polyResult;
        double[] result;
        int degree = getDegree();
        if (poly.getDegree() > degree) {
            degree = poly.getDegree();
        }
        result = new double[degree + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < coeffs.length; i++) {
            result[i] = coeffs[i];
        }
        for (int i = 0; i < poly.coeffs.length; i++) {
            result[i] += poly.coeffs[i];
        }
        polyResult = new MyPolynomial(result);


        return polyResult;



    }
}




