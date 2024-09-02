
class thidlargestinarray {
    static void thirdLargest(int arr[],
            int arr_size) {

        if (arr_size < 3) {
            System.out.printf(" Invalid Input ");
            return;
        }

      

        int first = Integer.MIN_VALUE,second = Integer.MIN_VALUE,third=Integer.MIN_VALUE;
        for (int i = 0; i < arr_size; i++)
           {
            if(first < arr[i])
            {
                   third = second ;
                   second = first;
                   first = arr[i];

                 
            }

            else if(second < arr[i] && second < first)
            {
                  third = second;
                   second = arr[i];
            }
            else if(third < arr[i] && third < second)
            {
                       third = arr[i];
            }

        }
        System.out.printf("The third Largest " +
                "element is %d\n", third);
    }

    public static void main(String[] args) {
        int arr[] = { 12, 13, 1,
                10, 34, 16 };
        int n = arr.length;
        thirdLargest(arr, n);
    }
}
