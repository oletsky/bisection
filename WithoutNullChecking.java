package mathcomp.oletsky.halfdivision;


/**
 * Bisection method without checking zeroes
 */

public class WithoutNullChecking {
    public static void main(String[] args) {
        double a = 1.;
        double b = 2.;
        final double EPS = 1.E-10;

           //Main loop
            while (b - a > EPS) {
                double c = (a + b) / 2.;

                //Changing bounds
                if (f(a) * f(c) > 0) a = c;
                else b = c;

            }
        double x = (a + b) / 2.;
        System.out.println("The root is " + x);
    }

    static double f(double x) {
        return x * x - x;
    }

}
