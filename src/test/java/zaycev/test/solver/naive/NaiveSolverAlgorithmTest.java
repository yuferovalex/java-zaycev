package zaycev.test.solver.naive;

import zaycev.test.solver.NaiveSolver;
import zaycev.test.solver.Solver;
import zaycev.test.solver.SolverAlgorithmBaseTest;

public class NaiveSolverAlgorithmTest extends SolverAlgorithmBaseTest {
    @Override
    protected Solver createInstance() {
        return new NaiveSolver();
    }
}
