package zaycev.test.datasource;

public class ConsoleDataWriter implements DataWriter {
    @Override
    public void writeResult(int loopLength, int iterationCount) {
        System.out.println("-------------- RESULT ---------------");
        System.out.println("Loop length:      " + loopLength);
        System.out.println("Iterations count: " + iterationCount);
        System.out.println("-------------------------------------");
        System.out.println();
    }

    @Override
    public void writeError(String message) {
        System.out.println("-------------- ERROR ----------------");
        System.out.println(message);
        System.out.println("-------------------------------------");
        System.out.println();
    }
}
