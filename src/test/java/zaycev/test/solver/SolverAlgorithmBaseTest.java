package zaycev.test.solver;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public abstract class SolverAlgorithmBaseTest {

    @Parameter
    public Integer expectedLoopLength;

    @Parameter(1)
    public Integer expectedIterationCount;

    @Parameter(2)
    public List<Integer> inputSequence;

    public Solver solver;

    @NotNull
    @Parameters(name = "Dataset {index}")
    public static Collection<@NotNull Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1695, 7864, Arrays.asList(0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11) },
                {    4,    5, Arrays.asList(0, 2, 7, 0) },
        });
    }

    protected abstract Solver createInstance();

    @Before
    public void setup() {
        solver = createInstance();
    }

    @Test
    public void runTest() {
        solver.run(inputSequence);

        assertThat(solver.getLoopLength(), is(expectedLoopLength));
        assertThat(solver.getIterationCount(), is(expectedIterationCount));
    }

}
