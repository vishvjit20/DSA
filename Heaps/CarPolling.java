package Heaps;

public class CarPolling {

    public static boolean carPooling(int[][] trips, int capacity) {
        int points[] = new int[1001];

        for (int trip[] : trips) {
            points[trip[1]] += trip[0];
            points[trip[2]] -= trip[0];
        }

        for (int i = 0; i < points.length; i++) {
            capacity -= points[i];
            if (capacity < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[][] = { { 2, 2, 6 }, { 2, 4, 7 }, { 8, 6, 7 } };
        int cap = 11;
        boolean res = carPooling(arr, cap);
        System.out.println(res);
    }
}
