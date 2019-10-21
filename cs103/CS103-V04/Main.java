import java.util.Arrays;

public class Main {
    public static char[] myArray;

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        System.out.println(areAnagram(s1, s2));

        int[] arr = {14, 10, 4, 5, 6, 1, 3, 7, 14};

        System.out.println(pairSumX(arr, 11));
        System.out.println(pairSumX(arr, 128));

        System.out.println(mostFrequentInt(arr));
    }
//zadatak1
    public static String sort(String myStr) {

        if (myStr == null || myStr.length() == 0 || myStr.length() == 1) {
            return null;
        }
        int length = myStr.length();
        int low = 0, high = length - 1;
        myArray = myStr.toCharArray();

        quickSort(low, high);
        return new String(myArray);

    }

    public static void quickSort(int low, int high) {

        int i = low;
        int j = high;
        char tmp;

        int pivot = (low + high) / 2;

        while (i <= j) {
            while (myArray[i] < myArray[pivot]) {
                i++;
            }
            while (myArray[j] > myArray[pivot]) {
                j--;
            }

            if (i <= j) {
                tmp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = tmp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }
    }

    public static boolean areAnagram(String s1, String s2) {
        String s1New = sort(s1);
        String s2New = sort(s2);


        if (s1New.equalsIgnoreCase(s2New)) {
            return true;
        } else {
            return false;
        }
    }
//zadatak6
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void sortArr(int arr[], int low, int high){
        if(low < high){
            int partitionIndex = partition(arr, low, high);
            sortArr(arr, low, partitionIndex - 1);
            sortArr(arr, partitionIndex + 1, high);
        }
    }
    public static boolean pairSumX(int[] arr, int x){
        int m, n;
        int len = arr.length;
        sortArr(arr, 0, arr.length - 1);
        m = 0;
        n = len - 1;

        while(m < n){
            if(arr[m] + arr[n] == x){
                return true;
            } else if(arr[m] + arr[n] < x){
                m++;
            } else {
                n--;
            }
        }
        return false;
    }
//zadatak5
    public static int mostFrequentInt(int[] arr){
        int len = arr.length;
        sortArr(arr, 0, len - 1);
        int max = 1;
        int res = arr[0];
        int curr = 1;

        for(int i = 1; i < len; i++){
            if(arr[i] == arr[i - 1]){
                curr++;
            } else{
                if(curr > max){
                    max = curr;
                    res = arr[i - 1];
                }
                curr = 1;
            }
        }
        if(curr > max){
            max = curr;
            res = arr[len - 1];
        }
        return res;
    }
}