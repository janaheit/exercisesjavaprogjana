public class Average {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};

        int total = 0;
        int len = a.length;
        for (int x:a){
            total += x;
        }

        int average = total/len;

        System.out.println(average);
    }

}
