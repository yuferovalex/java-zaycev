package zaycev.test.solver;

public class NegativeInitialSequenceException extends SolverException {
    public NegativeInitialSequenceException() {
        super("Negative numbers in initial sequence not allowed");
    }
}
