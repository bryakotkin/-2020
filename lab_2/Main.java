package com.company;

public class Main {

    public static void main(String[] args) {
	    VectorXYZ v1 = new VectorXYZ(2, 4, 2);
        VectorXYZ v2 = new VectorXYZ(3, 1, 1);

        System.out.print("Длина:\n" + v1.getLength() + "\nСкалярное произведение\n" + v1.getScalarProduct(v2));
        v1.getVectorProduct(v2);
        System.out.print("\nУгол:\n" + v1.getAgle(v2));
        v1.getSum(v2);
        v1.getDifference(v2);
        System.out.println("\n");
        VectorXYZ[] arr = VectorXYZ.getArr(5);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
    }
}
