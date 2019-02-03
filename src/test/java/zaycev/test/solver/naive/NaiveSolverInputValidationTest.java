package zaycev.test.solver.naive;

import org.junit.Before;
import org.junit.Test;
import zaycev.test.solver.EmptyInitialSequenceException;
import zaycev.test.solver.NaiveSolver;
import zaycev.test.solver.NegativeInitialSequenceException;
import zaycev.test.solver.Solver;

import java.util.Arrays;

public class NaiveSolverInputValidationTest {
    private Solver solver;

    @Before
    public void setup() {
        solver = new NaiveSolver();
    }

    @Test(expected = NegativeInitialSequenceException.class)
    public void shouldThrowIfInitialSequenceHasNegativeNumbers() {
        solver.run(Arrays.asList(10, -1, 2, 3));
    }

    @Test(expected = EmptyInitialSequenceException.class)
    public void shouldThrowIfInitialSequenceIsEmpty() {
        solver.run(Arrays.asList());
    }

}
