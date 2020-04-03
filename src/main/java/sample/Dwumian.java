package sample;

public class Dwumian {
    private double a;
    private double b;
    private double c;
    private double delta;

    public Dwumian() {
        setA(a);
        setB(b);
        setC(c);
    }

    public double getDelta(double a, double b, double c){
        delta = b * b - 4.0 * a * c;
        return delta;
    }

    public String pierwiastek (){
        if (getDelta(this.a, this.b, this.c) > 0.0){
            double pomA = (-b + Math.sqrt(getDelta(this.a, this.b, this.c)))/(2.0 * a);
            double pomB = (-b - Math.sqrt(getDelta(this.a, this.b, this.c)))/(2.0 * a);
            return String.format("%3.3f oraz %3.3f ", pomA, pomB);
        }
        else if(getDelta(this.a, this.b, this.c) == 0.0){
            double pom =  -b/(a*2.0);
            return String.format("%3.3f ", pom);
        }
        else{
            return String.format("Nie istnieją pierwiastki rzeczywiste, tego równania. ");
        }

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
}
