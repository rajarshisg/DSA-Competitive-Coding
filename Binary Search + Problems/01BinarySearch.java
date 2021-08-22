public class Main {
    
    private static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        
        while(low<=high) {
            int mid = low + (high - low) / 2; //this formula prevents integer overflows
            if(arr[mid] == key) return mid; //element found
            if(arr[mid] > key) high = mid - 1; //moving to lower half
            if(arr[mid] < key) low = mid + 1; //moving to upper half
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 11, 13, 17, 19};    
        System.out.println(binarySearch(arr, 11));
    }
}
