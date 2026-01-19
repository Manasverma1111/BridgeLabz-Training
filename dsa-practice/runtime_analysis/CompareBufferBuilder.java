package runtime_analysis;
class CompareBufferBuilder {
    public static void main(String[] args) {
        int n = 1000000;

        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < n; i++) {
            stringBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();

        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            stringBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();

        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ns");
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ns");
    }
}
