package zaycev.test.datasource;

import java.util.Iterator;
import java.util.List;

public interface DataReader {
    Iterator<List<Integer>> iterator();
}
