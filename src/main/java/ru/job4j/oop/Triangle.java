package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;
    private double ab;
    private double ac;
    private double bc;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
        this.ab = ap.distance(bp);
        this.ac = ap.distance(cp);
        this.bc = bp.distance(cp);
    }

    public double period(double a, double b, double c) {
        return (ab + ac + bc) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ab + ac > bc && ab + bc > ac && bc + ac > ab;
    }

    public double area() {
        double rsl = -1;
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
