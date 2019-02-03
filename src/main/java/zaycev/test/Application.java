package zaycev.test;

import zaycev.test.datasource.ConsoleDataReader;
import zaycev.test.datasource.ConsoleDataWriter;
import zaycev.test.datasource.DataReader;
import zaycev.test.datasource.DataWriter;
import zaycev.test.solver.NaiveSolver;
import zaycev.test.solver.Solver;
import zaycev.test.solver.SolverException;

import java.util.Iterator;
import java.util.List;

public class Application {
    private Solver solver;
    private DataReader reader;
    private DataWriter writer;

    public Application(Solver solver, DataReader reader, DataWriter writer) {
        this.solver = solver;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        Iterator<List<Integer>> iterator = reader.iterator();
        while (iterator.hasNext()) {
            List<Integer> inputSequence = iterator.next();
            try {
                solver.run(inputSequence);
                writer.writeResult(solver.getLoopLength(), solver.getIterationCount());
            } catch (SolverException e) {
                writer.writeError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Application(
                new NaiveSolver(),
                new ConsoleDataReader(),
                new ConsoleDataWriter()
        ).run();
    }
}
