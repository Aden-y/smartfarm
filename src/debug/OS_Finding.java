package  debug;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class OS_Finding{
    /*
     * This is an implementation of a algorithm to find
     * the i'th statistic in a given array
     */
    public static void main(String [] args){

//        String arg1;
//        int arg2;
//
//        try{
//            arg1 = args[0];
//            arg2 = Integer.parseInt(args[1]);
//            List<Integer> list = new ArrayList<>();
//
//            File fin = new File(arg1);
//            Scanner scanner = new Scanner(fin);
//
//            while (scanner.hasNext()) {
//                list.add(Integer.parseInt(scanner.nextLine()));
//            }
//            int[] array = new int[list.size()];
//            for (int i=0; i<list.size(); i++) {
//                array[i] = list.get(i);
//            }
//            if (arg2 > array.length){
//                System.out.println("null");
//            }else {
        int arg2 = 5;
        int array [] = {4,8,4,3,6,9,2};
               int result = ithOrdered(array,0, array.length-1, arg2);
                System.out.println(result);
//            }
//            scanner.close();
//
//        }catch(FileNotFoundException e){
//            System.out.println(e);
//        }
    }//end main method

    public static int ithOrdered(int array[], int left, int right, int i){

        if(left == right){
            return array[left];
        }

        int q = randomPartition(array, left, right);
        int k = q - left +1;

        if(i==k){
            return array[q];
        }else if(i < k){
            return ithOrdered(array, left, q-1,i);
        } else{
            return ithOrdered(array, q+1, right, i-k);
        }

    }//end ithOrdered method

    public static int randomPartition(int array[], int left, int right){
        int i = random(left, right);
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        //swap(array[i],array[right]);

        return partition(array, left, right);
    }//end randomPartition method

    public static int partition(int array[], int left, int right){
        int pivot = array[right], index = left;
        for(int i = left; i <= right-1; i++){
            if(array[i] <= pivot){
                int temp = array[index];
                array[index] = array[right];
                array[right] = temp;
               // swap(array[index], array[right]);
                index++;
            }
        }
        //swap(array[index], array[right]);
        int temp = array[index];
        array[index] = array[right];
        array[right] = temp;
        Arrays.sort(array);
        return index;
    }//end partition method

    public static int random(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }//end swap method
}//end class
