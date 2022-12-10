import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickSortGPT {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numbersAmount;
        int maxValue;

        ArrayList<Integer> unsortedNumbers = new ArrayList<>();
        
        while(true){
            
            System.out.println("How many numbers do you want to generate?");

            if(input.hasNextInt()){

                numbersAmount = input.nextInt();
                
                System.out.println("What should max value for the generated numbers be?");

                if(input.hasNextInt()){

                    maxValue = input.nextInt();

                    System.out.printf("Generating %d random numbers with max value of %d\n", numbersAmount, maxValue);
                    
                    generateRandomNumbers(unsortedNumbers, numbersAmount, maxValue);

                    input.close();

                    break;
                }
            } else {

                System.out.println("Input wasnt an int. Try again");
                input.next();
            }
        }

        sort(unsortedNumbers);
    }

    public static void generateRandomNumbers(ArrayList<Integer> unsortedList, int amount, int maxValue) {

        //How do you generate random numbers and add them to an arraylist?
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            unsortedList.add(rand.nextInt(maxValue));
        }
    }

    private static void printArrList(ArrayList<Integer> arrList){
        for(Integer number : arrList){
            System.out.println(number);
        }
    }

    public static void sort(ArrayList<Integer> unsortedList) {

        System.out.println("Before");
        printArrList(unsortedList);
        
        quickSort(unsortedList, 0, unsortedList.size() - 1);
        
        System.out.println("\nAfter");
        printArrList(unsortedList);
    }
  
    private static void quickSort(ArrayList<Integer> unsortedList, int start, int end) {
      // base case: if the start and end indices are the same, the array
      // is already sorted, so we can return
      if (start >= end) {
        return;
      }
  
      // choose a pivot element
      int pivotIndex = start + (end - start) / 2;
      //int pivot = unsortedList[pivotIndex];
      int pivot = (int) unsortedList.get(pivotIndex);
  
      // partition the array around the pivot
      int left = start;
      int right = end;
      while (left <= right) {
        // find the first element on the left that should be on the right
        //while (unsortedList[left] < pivot) {
        while (unsortedList.get(left) < pivot) {
          left++;
        }
  
        // find the first element on the right that should be on the left
        //while (unsortedList[right] > pivot) {
        while (unsortedList.get(right) > pivot) {
          right--;
        }
  
        // if the left index is still less than or equal to the right index,
        // we have found two elements that are out of place, so we swap them
        if (left <= right) {
          swap(unsortedList, left, right);
          left++;
          right--;
        }
      }
  
      // sort the left and right partitions recursively
      quickSort(unsortedList, start, right);
      quickSort(unsortedList, left, end);
    }
  
    private static void swap(ArrayList<Integer> unsortedList, int i, int j) {
      int temp = unsortedList.get(i);
      unsortedList.set(i, unsortedList.get(j));
      unsortedList.set(j, temp);
    }
  }