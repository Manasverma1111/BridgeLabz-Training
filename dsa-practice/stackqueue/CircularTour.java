package stackqueue;

public class CircularTour {

    public static int findStart(int[] petrol, int[] distance) {

        int totalPetrol = 0;
        int currPetrol = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            int diff = petrol[i] - distance[i];

            totalPetrol += diff;
            currPetrol += diff;

            if (currPetrol < 0) {
                start = i + 1;
                currPetrol = 0;
            }
        }

        return (totalPetrol >= 0) ? start : -1;
    }

    public static void main(String[] args) {

        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        System.out.println(findStart(petrol, distance));
    }
}
