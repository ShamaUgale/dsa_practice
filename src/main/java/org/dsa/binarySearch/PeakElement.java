package org.dsa.binarySearch;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {5,10,20,30,45,32};
        System.out.println("Peak element is : " + peakElement(arr));

    }

    private static int peakElement(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if(mid > 0 && mid < arr.length-1){
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                    return arr[mid];
                }else if(arr[mid-1] > arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid +1;
                }
            }

            if(mid == 0){
                if(arr[0] > arr[1]){
                    return arr[1];
                }else{
                    return arr[0];
                }
            }

            if(mid == arr.length-1){
                if(arr[arr.length-1] > arr[arr.length-2]){
                    return arr[arr.length-1];
                }else{
                    return arr[arr.length-2];
                }
            }
        }
        return -1;
    }
}