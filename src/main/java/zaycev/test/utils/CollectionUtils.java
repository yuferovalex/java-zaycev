package zaycev.test.utils;

import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <T extends Comparable<? super T>> Optional<Pair<Integer, T>> maxElement(@NotNull List<T> collection) {
        if (collection.isEmpty()) {
            return Optional.empty();
        }
        Iterator<T> iterator = collection.iterator();
        int maxIndex = 0;
        T maxValue = iterator.next();
        for (int index = 1; iterator.hasNext(); ++index) {
            T currentValue = iterator.next();
            if (maxValue.compareTo(currentValue) < 0) {
                maxIndex = index;
                maxValue = currentValue;
            }
        }
        return Optional.of(new Pair<>(maxIndex, maxValue));
    }

}
