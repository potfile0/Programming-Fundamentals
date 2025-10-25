public class Polynomial {

    private int[] coeff;

    //constructor
    public Polynomial(int deg) {
        coeff = new int[deg + 1];
    }

    //putting number in specific term
    public void setTerm(int num, int deg) {
        if (deg >= 0 && deg < coeff.length) {
            coeff[deg] = num;
        }
    }

    //getting coefficient of term
    public int getTerm(int deg) {
        if (deg >= 0 && deg < coeff.length) return coeff[deg];
        return 0;
    }

    //finding biggest power that has non zero coefficent
    public int maxDeg() {
        for (int i = coeff.length - 1; i >= 0; i--) {
            if (coeff[i] != 0) return i;
        }
        return 0;
    }

    //putting x into polynomial
    public int eval(int x) {
        int res = 0;
        int power = 1; 

        for (int i = 0; i < coeff.length; i++) {
            res += coeff[i] * power;
            power *= x;
        }

        return res;
    }

    //adding two polynomials
    public Polynomial add(Polynomial other) {
        int maxd;
        if (this.coeff.length > other.coeff.length) {
            maxd = this.coeff.length;
        } else {
            maxd = other.coeff.length;
        }

        Polynomial res = new Polynomial(maxd - 1);

        for (int i = 0; i < maxd; i++) {
            int a = 0, b = 0;
            if (i < this.coeff.length) a = this.coeff[i];
            if (i < other.coeff.length) b = other.coeff[i];
            res.setTerm(a + b, i);
        }

        return res;
    }

    //multiplying two polys
    public Polynomial multiply(Polynomial other) {
        int newsize = this.maxDeg() + other.maxDeg() + 1;
        Polynomial res = new Polynomial(newsize);
        for (int i = 0; i <= this.maxDeg(); i++) {
            for (int j = 0; j <= other.maxDeg(); j++) {
                int sum = res.getTerm(i + j) + this.getTerm(i) * other.getTerm(j);
                res.setTerm(sum, i + j);
            }
        }
        return res;
    }

    //derivative
    public Polynomial deriv() {
        int d = this.maxDeg();
        if (d == 0) return new Polynomial(0);

        Polynomial res = new Polynomial(d - 1);
        for (int i = 1; i <= d; i++) {
            res.setTerm(i * this.getTerm(i), i - 1);
        }
        return res;
    }

    //printing
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (int i = maxDeg(); i >= 0; i--) {
            int c = coeff[i];
            if (c != 0) {
                if (!first) sb.append(c > 0 ? " + " : " - ");
                else if (c < 0) sb.append("-");

                int absC = Math.abs(c);
                if (i == 0) sb.append(absC);
                else if (i == 1) sb.append((absC == 1 ? "" : absC) + "x");
                else sb.append((absC == 1 ? "" : absC) + "x^" + i);

                first = false;
            }
        }

        if (first) return "0";
        return sb.toString();
    }
}
