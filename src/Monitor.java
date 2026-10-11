public class Monitor {
    private double diagonal;

    public Monitor(double diagonal) {
        this.diagonal = diagonal;
    }

    public double getDiagonal() {return diagonal;}

    @Override
    public String toString() {
        return diagonal + " дюймов";
    }
}
