package com.company;
import java.util.Scanner;

public class Main {
    public static void firstTask(Scanner in) {
        System.out.println("Задача №1\nВведите кол. элементов в массиве:");
        int count = in.nextInt();
        if(count > 0) {
            double[] arr = new double[count];
            for(int i = 0; i < count; i++)
                arr[i] = Math.random();
            System.out.println("Исходный массив:");
            double max = arr[0], min = arr[0], avg = 0;
            for(int i = 0; i < count; i++) {
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
                avg += arr[i];
                System.out.printf("%.3f ", arr[i]);
            }
            avg = avg/count;
            System.out.printf("\nМаксимальное: %.3f\nМинимальное: %.3f\nСреднее значение: %.3f\n", max, min, avg);
        }
        else
            System.out.println("Введенное значение меньше 1");
    }

    public static void secondTask(Scanner in) {
        System.out.println("Задача №2\nВведите N, k:");
        int n = in.nextInt();
        if(n > 0) {
            int k = in.nextInt();
            int[] arr = new int[n];
            int sum = 0, counter = 1;
            System.out.println("Исходный массив:");
            for(int i = 0; i < n; i++) {
                arr[i] = (int) Math.pow(counter, k);
                counter++;
                sum += arr[i];
                System.out.print(arr[i] + " ");
            }
            System.out.print("\nСумма: " + sum);
        }
        else
            System.out.print("Введенное значение меньше 1");
    }

    public static void thirdTask(Scanner in) {
        System.out.print("\nЗадача №3\nВведите кол. элементов в массиве:\n");
        int count = in.nextInt();
        if(count > 0) {
            int[] arr = new int[count];
            System.out.println("Исходный массив:");
            for(int i = 0; i < count; i++) {
                arr[i] = (int) (Math.random()*(200+1)) - 100;
                System.out.print(arr[i] + " ");
            }
            boolean isSorted = false;
            int buf;
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length-1; i++) {
                    if(arr[i] > arr[i+1]){
                        isSorted = false;
                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
            System.out.print("\nОтсортированный массив:\n");
            for(int i = 0; i < count; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        else
            System.out.print("Введенное значение меньше 1");
    }


    public static void fourthTask() {
        System.out.print("\nЗадача №4\n");
        int count;
        for(int i = 2; i < 100; i++) {
            count = 0;
            for(int j = 2; j <= i; j++) {
                if (i % j == 0)
                    count++;
            }
            if(count < 2)
                System.out.print(i + " ");
        }
    }

    public static int findFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return findFibonacci(n - 1) + findFibonacci(n - 2);
        }
    }
    
    public static void fifthTask(Scanner in) {
        System.out.print("\nЗадача №5\nВведите номер:\n");
        int n = in.nextInt();
        if(n > 0) {
            int a = findFibonacci(n);
            System.out.print("Число под номером " + n + ": " + a);
        }
        else
            System.out.print("Введенное значение меньше 1");
    }

    public static void sixthTask() {
        int[] arr = {5, 7, 7, 10, 4, 2, 7, 9};
        int n = 7;
        System.out.print("\nЗадача №6\nЧисло: " + n + "\nИсходный массив:\n");
        for(int i = 0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int[] s_arr = deleteNumber(arr, n);
        System.out.print("\nНовый массив:\n");
        for(int i = 0; i < s_arr.length; i++) {
            System.out.print(s_arr[i] + " ");
        }
    }

    public static int[] deleteNumber(int[] arr, int n) {
        int offset = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                offset++;
            } else{
                arr[i - offset] = arr[i];
            }
        }
        int[] s_arr = new int[arr.length - offset];
        for(int i = 0; i < s_arr.length; i++) {
            s_arr[i] = arr[i];
        }
        return s_arr;
    }

    public static void seventhTask() {
        int[] arr = {5, 10, 10, 4, 4, 5, 2, 3, 2, 7, 20, 9};
        System.out.print("\nЗадача №7\nИсходный массив:\n");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        for(int i = 0; i < arr.length; i++) {
            boolean isU = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == arr[i] && i != j) {
                    isU = false;
                    break;
                }
            }
            if(isU){
                System.out.print("\nУникальное число: " + arr[i]);
                break;
            }
        }
    }

    public static int uniqueCount(int[] array) {
        int result = 0;
        int countUnique = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            countUnique++;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
        }
        return result = countUnique - count;
    }

    public static void eighthTask(Scanner in) {
        int[] arr = {5, 10, 10, 4, 4, 5, 2, 3, 2, 7, 20, 4, 9};
        System.out.print("\nЗадача №8\nИсходный массив:\n");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.print("\nВведите количество:\n");
        int number = in.nextInt();
        int uniqueCount = uniqueCount(arr);
        if(number > uniqueCount) {
            number = uniqueCount;
        }
        for(int k = 0; k < number; k++) {
            int max_index = 0, count, max_count = 0;
            for(int i = 0; i < arr.length; i++) {
                count = 0;
                for(int j = 0; j < arr.length; j++) {
                    if(arr[j] == arr[i])
                        count++;
                }
                if(count > max_count) {
                    max_count = count;
                    max_index = i;
                }
            }
            System.out.print(arr[max_index] + " ");
            arr = deleteNumber(arr, arr[max_index]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        firstTask(in);
        secondTask(in);
        thirdTask(in);
        fourthTask();
        fifthTask(in);
        sixthTask();
        seventhTask();
        eighthTask(in);
    }
}
