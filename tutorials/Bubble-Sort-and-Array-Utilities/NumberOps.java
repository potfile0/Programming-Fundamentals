public class NumberOps {
    //print array
    public static void printArray(int[] arr) {
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //swap elements in an array
    //nums: {2,6,8,12}
    //positions 1 and 3
    //should update nums to be {2,12,8,6}
    public static void swap(int[] nums, int pos1, int pos2) {
        //{2,6,8,12}
        int temp = nums[pos1]; //temp would be 6
        nums[pos1] = nums[pos2]; //nums is now {2,12,8,12}
        nums[pos2] = temp; //nums is now {2,12,8,6}
    }

    //use bubble sort to sort an array
    public static void bubbleSort(int[] nums) {
        //loop through all of the passes, Each pass "bubbles up" the next big element to the end
        for (int i = 0; i < nums.length-1; i++) {
            //loop to do a pass, comparing adjacent element
            for (int j = 0; j < nums.length-1-i; j++) {
                //compare nums[j], nums[j+1]
                if(nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    //round double to the nearest int
    public static int round(double val) {
        //val is 3.2, return 3
        //val is 3.7, returns 3
        //val is -3.2, returns -2
        //val is -3.7, returns -3

        if( val >= 0 ) {
            return (int) (val+0.5);
        }
        else{
            return (int) (val-0.5);
        }

        
    }

    //find the median (middle) element in an array
    //half the elements are smaller than the median and half are bigger
    //first sort the array, and then find the middle element
    public static double median(int[] nums) {
        //nums is {8,1,6,3,5}. Sorted: {1,3,5,6,8}. Median:5
        //nums is {8,1,6,3}. Sorted: {1,3,6,8}. Median: (3+6)/2 = 4.5

        bubbleSort(nums);
        if(nums.length % 2 == 1) {
            //nums has an odd length
            return nums[nums.length/2];
        }
        else {
            //nums has an even length
            int right = nums[nums.length/2];
            int left = nums[nums.length/2 - 1];

            return(right+left)/2;
        }
    }
}
