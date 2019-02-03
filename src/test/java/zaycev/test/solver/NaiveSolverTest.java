package zaycev.test.solver;

public class NaiveSolverTest extends SolverBaseTest {
    @Override
    protected Solver createInstance() {
        return new NaiveSolver();
    }
}
