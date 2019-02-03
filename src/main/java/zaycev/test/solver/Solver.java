package zaycev.test.solver;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Solver {
    void run(@NotNull List<Integer> data);

    @Contract(pure = true)
    int getLoopLength();

    @Contract(pure = true)
    int getIterationCount();
}
