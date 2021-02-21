package mathcomp.oletsky.halfdivision;

/**
 * Bisection method with checking zeroes
 */

public class HalfDivisionTester {
    public static void main(String[] args) {
        double a = 1.;
        double b = 1.5;
        final double EPS = 1.E-10;
        double x = 0;
        boolean flag = false;

        //Checking zeroes
        //Don't use == because of limited precision of double
        if (approxEquals(a, 0.)) {
            x = a;
            flag = true;
        }

        if (approxEquals(b, 0.)) {
            x = b;
            flag = true;
        }
        if (!flag)
            //Main loop
            while (b - a > EPS) {
                double c = (a + b) / 2.;

                //Checking zero
                if (approxEquals(f(c), 0.)) {
                    x = c;
                    flag = true;
                    break;
                }

                //Changing bounds
                if (f(a) * f(c) > 0) a = c;
                else b = c;

            }
        if (!flag) x = (a + b) / 2.;
        System.out.println("The root is " + x);
    }

    static double f(double x) {
        return x * x - x;
    }

    static boolean approxEquals(double a,
                                double b) {
        final double EPS = 1.E-10;
        return ((a > b - EPS) && (a < b + EPS));
    }
}
