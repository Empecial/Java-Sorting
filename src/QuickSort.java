import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    static List<Integer> unsortedList = new ArrayList<>();
    
    Random rand = new Random();
    public static void main(String[] args) {

        QuickSort qSort = new QuickSort();

        qSort.fillUnsortedListRandomly(10, 11);

        System.out.println(unsortedList);
    }

    private void fillUnsortedListRandomly(int listSize, int maxValue){
        for(int i = 0; i < listSize; i++){
            unsortedList.add(rand.nextInt(maxValue));
        }
    }

    private void quickSort(List<Integer> unsortedList, int lowIndex, int highIndex){


    }
}
