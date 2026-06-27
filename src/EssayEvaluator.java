public class EssayEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question question, String answer) {
        if (!(question instanceof EssayQuestion)) {
            throw new IllegalArgumentException(
                    "EssayEvaluator requires an EssayQuestion"
            );
        }

        EssayQuestion essay = (EssayQuestion) question;

        if (answer == null || answer.trim().isEmpty()) {
            return 0;
        }

        String normalizedAnswer = answer.toLowerCase();
        String[] keywords = essay.getRequiredKeywords();

        int matchedKeywords = 0;

        for (String keyword : keywords) {
            if (normalizedAnswer.contains(keyword.toLowerCase())) {
                matchedKeywords++;
            }
        }

        return essay.getPoints() * matchedKeywords / keywords.length;
    }
}