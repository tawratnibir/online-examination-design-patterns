public class EssayQuestion implements Question {
    private final String text;
    private final String[] requiredKeywords;
    private final int points;
    private final String difficulty;

    public EssayQuestion(
            String text,
            String[] requiredKeywords,
            int points,
            String difficulty
    ) {
        this.text = text;
        this.requiredKeywords = requiredKeywords;
        this.points = points;
        this.difficulty = difficulty;
    }

    @Override
    public String getType() {
        return "Essay";
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

    public String[] getRequiredKeywords() {
        return requiredKeywords;
    }
}