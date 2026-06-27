package question.mcq;

import question.Question;

public class MCQQuestion implements Question {
    private final String text;
    private final String[] options;
    private final String correctAnswer;
    private final int points;
    private final String difficulty;

    public MCQQuestion(
            String text,
            String[] options,
            String correctAnswer,
            int points,
            String difficulty
    ) {
        this.text = text;
        this.options = options.clone();
        this.correctAnswer = correctAnswer;
        this.points = points;
        this.difficulty = difficulty;
    }

    @Override
    public String getType() {
        return "MCQ";
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

    public String[] getOptions() {
        return options.clone();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
