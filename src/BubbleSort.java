import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BubbleSort {

    private static List<Integer> unsortedList = new ArrayList<>();
    
    private static Random rand = new Random();

    public static void main(String[] args) throws Exception {

        fillUnsortedArray(10,100);

        System.out.println("Numbers before");
        System.out.println(unsortedList);

        System.out.println("Numbers after");
        bubbleSort();
        System.out.println(unsortedList);
    }   

    private static void fillUnsortedArray(int amount, int range){

        for (int i = 0; i < amount; i++) {

            unsortedList.add(rand.nextInt(range));
        }
    }

    private static void bubbleSort(){

        boolean stillSorting = true;

        while(stillSorting){

            stillSorting = false;

            for(int i = 0; i < unsortedList.size() - 1; i++ ){
                
                if(unsortedList.get(i) > unsortedList.get(i+1)){
                    
                    stillSorting = true;

                    int temp = unsortedList.get(i);
                    
                    unsortedList.set(i, unsortedList.get(i+1));
                    
                    unsortedList.set(i + 1, temp);
                }
            }
        }
    }
}