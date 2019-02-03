package zaycev.test.datasource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleDataReader implements DataReader {
    @Override
    public Iterator<List<Integer>> iterator() {
        return new Iterator<List<Integer>>() {
            private List<Integer> data;
            private boolean isExit;
            private Scanner scanner = new Scanner(System.in);

            private void readData() {
                do {
                    System.out.println("Input natural number sequence or type \"exit\"");
                } while (!tryReadData());
            }

            private boolean tryReadData() {
                try {
                    String line = scanner.nextLine().trim();
                    if (line.startsWith("exit")) {
                        isExit = true;
                        data = null;
                        return true;
                    }
                    data = Arrays.stream(line.split("\\s+"))
                            .map(Integer::valueOf)
                            .collect(Collectors.toList());
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong number format");
                    return false;
                }
            }

            @Override
            public boolean hasNext() {
                if (data != null) {
                    return true;
                }
                readData();
                return data != null;
            }

            @Override
            public List<Integer> next() {
                if (data == null && !isExit) {
                    readData();
                }
                List<Integer> retval = data;
                data = null;
                return retval;
            }
        };
    }
}
