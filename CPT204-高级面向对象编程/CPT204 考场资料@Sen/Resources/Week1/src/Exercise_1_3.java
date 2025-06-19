public class Exercise_1_3 {
    public static class StopWatch{
        private long startTime;
        private long endTime;

        public StopWatch(){
            startTime = System.currentTimeMillis();
            endTime = startTime;
        }

        public void start(){
            startTime = System.currentTimeMillis();
        }
        public void stop(){
            endTime = System.currentTimeMillis();
        }
        public double getElapsedTime(){
            return (endTime - startTime) / 1000.0;
        }
    }


    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            // Find the minimum in the list[i..list.length-1]
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random() * 100000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        selectionSort(numbers);
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime());
    }
}
