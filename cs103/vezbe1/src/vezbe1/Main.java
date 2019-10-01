package vezbe1;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 1, 1}
        };

    }
    // return index of the start && num
    //zadatak3
    public static int[] findLargestBlock(int[][] matrix, int cols){
        int[] previous = new int [cols];
        int[] current = new int [cols];
        int index = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){

            }
        }

        return previous;
    }

    //zadatak4
    public static boolean isDivisor(int n, int x){
        return (n / x) == n / (double) x;
    }

    public static int sumOfDivisors(int n){
        int sum = 0;

        for(int i = 1; i < n; i++){
            if(isDivisor(n, i)){
                sum += i;
            }
        }
        return sum;
    }

    //zadatak5
    public static String prefix(String s1, String s2){
        String pref = "";
        int n = 0;

        while(s1.charAt(n) == s2.charAt(n)){
            pref += s1.charAt(n);
            if(n == s1.length() - 1 || n == s2.length() - 1){
                break;
            }
            n++;
        }
        return pref;
    }
}
