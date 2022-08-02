public class TwoPointers_RemoveElement {

    public static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }

    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(remove(arr));

        arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
        System.out.println(remove(arr, 3));

        arr = new int[] { 2, 11, 2, 2, 1 };
        System.out.println(remove(arr, 2));
    }

}
