/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.pkgfinal.project;

import java.util.Scanner;

/**
 *
 * @author myoss
 */
public class DSFinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    
 Scanner input = new Scanner(System.in);
        //get Number of services
        System.out.println("Enter Number of Services ");
        int num_of_services = input.nextInt();
        //array to store Frequency of serviecs
        int[] Frequency_of_services = new int[num_of_services];
        for (int i = 0; i < Frequency_of_services.length; i++) {
            //get random number for frequency
            Frequency_of_services[i] = (int) (Math.random() * 100000);
        }
        //Genrate Ranodom numbers
        int[] Services_Call_Number = new int[num_of_services];
        //Genrate Random Numbers for Services
        //{911,1911}
        for (int i = 0; i < num_of_services; i++) {
            int num1 = Services_Call_Number[i];
            int num2 = (int) (Math.random() * 1000000000);
            if (Check(num1, num2) == false) {
                Services_Call_Number[i] = num2;
            } else {
                i--;
            }
        }
        mergeSort(Frequency_of_services, 0, Frequency_of_services.length - 1, "desc");
        mergeSort(Services_Call_Number, 0, Services_Call_Number.length - 1, "asc");
        System.out.println("                                 Services Numbers is");
        for (int i = 0; i < Frequency_of_services.length; i++) {
            String Frequency = String.format("% 10d", Frequency_of_services[i]);
            String Service_Number = String.format("% 10d", Services_Call_Number[i]);
            String S_name = String.format("% 6d", (i + 1));
            System.out.println(" Services Number" + S_name + ":" + "           Frequency :  " + Frequency + "          Call Number : " + Service_Number);
        }
    }

    public static boolean Check(int num1, int num2) {
        String S1 = num1 + "";//911
        String S2 = num2 + "";//9113
        String s3;
        String s4;
        if (S1.length() < S2.length()) {//3,4
            s3 = S2.substring(0, S1.length());//911
            s4 = S1;//911
        }//
        else {
            s3 = S2;//911
            s4 = S1.substring(0, S2.length());//
        }
        boolean flage = false;
        if (s4.equals(s3)) {//911=391
            flage = true;
        } else {
            flage = false;
        }
        return flage;
    }

    // sorting functions
    private static void mergeSort(int[] array, int low, int high, String type) {
        if (high <= low) {
            return;
        }
        // if lennght > 2 
        int mid = (low + high) / 2;
        // divide array to left and right
        mergeSort(array, low, mid, type);
        mergeSort(array, mid + 1, high, type);
        // merge two array
        merge(array, low, mid, high, type);
    }

    private static void merge(int[] array, int low, int mid, int high, String type) {

        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];
        //declare left array

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[low + i];
        }
        //declare right array
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[mid + i + 1];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = low; i < high + 1; i++) {
            //sort array ascending
            if (type.equals("asc")) {
                if (leftIndex < leftArray.length && rightIndex < rightArray.length) {

                    if (leftArray[leftIndex] < rightArray[rightIndex]) {
                        array[i] = leftArray[leftIndex];
                        leftIndex++;
                    } else {
                        array[i] = rightArray[rightIndex];
                        rightIndex++;
                    }
                } else if (leftIndex < leftArray.length) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else if (rightIndex < rightArray.length) {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
                //sort array descending
            } else if (type.equals("desc")) {
                if (leftIndex < leftArray.length && rightIndex < rightArray.length) {

                    if (leftArray[leftIndex] >= rightArray[rightIndex]) {
                        array[i] = leftArray[leftIndex];
                        leftIndex++;
                    } else {
                        array[i] = rightArray[rightIndex];
                        rightIndex++;
                    }
                } else if (leftIndex < leftArray.length) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else if (rightIndex < rightArray.length) {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
        }
    }
}

