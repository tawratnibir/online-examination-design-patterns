package question.programming;

import question.Question;

public class ProgrammingQuestion implements Question {
    private final String text;
    private final String expectedOutput;
    private final int points;
    private final String difficulty;

    public ProgrammingQuestion(
            String text,
            String expectedOutput,
            int points,
            String difficulty
    ) {
        this.text = text;
        this.expectedOutput = expectedOutput;
        this.points = points;
        this.difficulty = difficulty;
    }

    @Override
    public String getType() {
        return "Programming";
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }
}