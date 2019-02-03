package zaycev.test.datasource;

public interface DataWriter {
    void writeResult(int loopLength, int iterationCount);
    void writeError(String message);
}
