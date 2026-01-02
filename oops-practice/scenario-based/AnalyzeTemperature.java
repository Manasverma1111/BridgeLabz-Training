public class AnalyzeTemperature {
//    method to calculate average temperature for each day
    public static float[] calculateDailyAverages(float[][] temperatures) {

        float[] dailyAverages = new float[7];

        for (int day = 0; day < 7; day++) {
            float sum = 0;
            for (int hour = 0; hour < 24; hour++) {
                sum += temperatures[day][hour];
            }
            dailyAverages[day] = sum / 24;
        }

        return dailyAverages;
    }
//    method to find hottest and coldest day
    public static void findHottestAndColdestDay(float[][] temperatures) {

        float[] averages = calculateDailyAverages(temperatures);

        int hottestDay = 0;
        int coldestDay = 0;

        for (int i = 1; i < averages.length; i++) {
            if (averages[i] > averages[hottestDay]) {
                hottestDay = i;
            }
            if (averages[i] < averages[coldestDay]) {
                coldestDay = i;
            }
        }

        System.out.println("Hottest Day: Day " + (hottestDay + 1) + " with Avg Temp = " + averages[hottestDay]);
        System.out.println("Coldest Day: Day " + (coldestDay + 1) + " with Avg Temp = " + averages[coldestDay]);
    }

    // Driver code
    public static void main(String[] args) {

        float[][] temperatures = {
                {30.5f, 31.0f, 29.8f, 28.6f, 27.5f, 26.8f, 26.0f, 27.3f, 29.0f, 31.2f, 33.0f, 34.5f,
                        35.1f, 36.0f, 35.8f, 34.2f, 33.0f, 32.5f, 31.8f, 31.0f, 30.2f, 29.5f, 29.0f, 28.5f},
                {28.0f, 27.5f, 26.8f, 26.0f, 25.5f, 25.0f, 24.8f, 25.5f, 27.0f, 29.0f, 30.5f, 32.0f,
                        33.0f, 34.2f, 34.0f, 33.0f, 32.5f, 31.8f, 30.5f, 29.5f, 28.8f, 28.0f, 27.5f, 27.0f},
                {32.0f, 31.5f, 30.8f, 29.5f, 28.0f, 27.0f, 26.5f, 28.0f, 30.0f, 32.5f, 34.0f, 35.8f,
                        36.5f, 37.2f, 37.0f, 36.0f, 35.5f, 34.8f, 33.5f, 32.8f, 32.0f, 31.5f, 31.0f, 30.5f},
                {26.0f, 25.8f, 25.5f, 25.0f, 24.5f, 24.0f, 23.8f, 24.5f, 26.0f, 28.0f, 29.5f, 31.0f,
                        32.0f, 33.0f, 32.5f, 31.5f, 30.8f, 29.8f, 28.5f, 27.8f, 27.0f, 26.5f, 26.2f, 26.0f},
                {34.0f, 33.5f, 32.8f, 31.5f, 30.0f, 29.0f, 28.5f, 30.0f, 32.5f, 35.0f, 37.0f, 38.5f,
                        39.2f, 40.0f, 39.8f, 38.5f, 37.5f, 36.5f, 35.0f, 34.2f, 33.5f, 33.0f, 32.8f, 32.5f},
                {29.0f, 28.5f, 28.0f, 27.0f, 26.5f, 26.0f, 25.8f, 26.5f, 28.0f, 30.0f, 31.5f, 33.0f,
                        34.0f, 35.0f, 34.5f, 33.5f, 32.8f, 31.8f, 30.5f, 29.8f, 29.0f, 28.5f, 28.2f, 28.0f},
                {27.0f, 26.5f, 26.0f, 25.5f, 25.0f, 24.8f, 24.5f, 25.0f, 26.5f, 28.5f, 30.0f, 31.5f,
                        32.5f, 33.5f, 33.0f, 32.0f, 31.2f, 30.2f, 29.0f, 28.5f, 28.0f, 27.5f, 27.2f, 27.0f}
        };

        findHottestAndColdestDay(temperatures);
    }
}
