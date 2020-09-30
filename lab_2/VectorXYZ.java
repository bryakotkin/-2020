package com.company;

public class VectorXYZ {
    private final double x;
    private final double y;
    private final double z;

    public VectorXYZ(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double getScalarProduct(VectorXYZ vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    public void getVectorProduct(VectorXYZ vector) {
        System.out.print("\nВекторное произведение:\n(" + (this.y * vector.z - this.z) + ", " + (this.z * vector.x - this.x * vector.z) + ", " + (this.x * vector.y - this.y * vector.x) + ")");
    }

    public double getAgle(VectorXYZ vector) {
        return this.getScalarProduct(vector) / (this.getLength() * vector.getLength());
    }

    public void getSum(VectorXYZ vector) {
        System.out.print("\nСумма:\n(" + (this.x + vector.x) + ", " + (this.y + vector.y) + ", " + (this.z + vector.z) + ")");
    }

    public void getDifference(VectorXYZ vector) {
        System.out.print("\nРазность:\n(" + (this.x - vector.x) + ", " + (this.y - vector.y) + ", " + (this.z - vector.z) + ")");
    }

    @Override
    public String toString() {
        return "VectorXYZ{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static VectorXYZ[] getArr(int n) {
        if (n > 0) {
            VectorXYZ[] arr = new VectorXYZ[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new VectorXYZ(Math.random(), Math.random(), Math.random());
            }
            return arr;
        }
        else {
            System.out.println("Введенное значение меньше 1");
            return null;
        }
    }
}

