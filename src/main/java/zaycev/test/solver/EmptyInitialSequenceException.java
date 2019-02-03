package zaycev.test.solver;

public class EmptyInitialSequenceException extends SolverException {
    public EmptyInitialSequenceException() {
        super("Initial sequence can not be empty");
    }
}
