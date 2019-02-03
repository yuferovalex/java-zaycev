package zaycev.test.solver;

import javafx.util.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import zaycev.test.utils.CollectionUtils;

import java.util.*;

import static java.lang.Math.min;

public class NaiveSolver implements Solver {
    private List<Integer> currentSequence = new ArrayList<>();
    private Set<List<Integer>> allSequences = new LinkedHashSet<>();
    private int loopLength;

    @Override
    public void run(@NotNull List<Integer> initialSequence) {
        checkInitialSequence(initialSequence);
        init(initialSequence);
        while (!isLoopFound()) {
            transformCurrentSequence();
        }
        evaluateLoopLength();
    }

    private void checkInitialSequence(@NotNull List<Integer> initialSequence) {
        if (initialSequence.isEmpty()) {
            throw new EmptyInitialSequenceException();
        }
        if (initialSequence.stream().anyMatch(value -> value < 0)) {
            throw new NegativeInitialSequenceException();
        }
    }

    private void init(List<Integer> initialSequence) {
        currentSequence.clear();
        currentSequence.addAll(initialSequence);
        allSequences.clear();
    }

    private void transformCurrentSequence() {
        allSequences.add(new ArrayList<>(currentSequence));
        Pair<Integer, Integer> maxElement = CollectionUtils.maxElement(currentSequence).get();
        int index = maxElement.getKey();
        int distributableValue = maxElement.getValue();
        int sequenceSize = currentSequence.size();
        int incrementValue = (int) Math.ceil(1.0 * distributableValue / sequenceSize);
        currentSequence.set(index, 0);
        while (distributableValue != 0) {
            index = (index + 1) % sequenceSize;
            currentSequence.set(index, currentSequence.get(index) + incrementValue);
            distributableValue -= incrementValue;
            incrementValue = min(distributableValue, incrementValue);
        }
    }

    private void evaluateLoopLength() {
        int indexOfLoopStart = 0;
        for (List<Integer> sequence : allSequences) {
            indexOfLoopStart += 1;
            if (sequence.equals(currentSequence)) {
                break;
            }
        }
        loopLength = getIterationCount() - indexOfLoopStart + 1;
    }

    @Contract(pure = true)
    private boolean isLoopFound() {
        return allSequences.contains(currentSequence);
    }

    @Override
    @Contract(pure = true)
    public int getLoopLength() {
        return loopLength;
    }

    @Override
    @Contract(pure = true)
    public int getIterationCount() {
        return allSequences.size();
    }
}
