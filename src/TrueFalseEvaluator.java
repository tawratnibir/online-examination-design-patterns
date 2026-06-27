public class TrueFalseEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question question, String answer) {
        if (!(question instanceof TrueFalseQuestion)) {
            throw new IllegalArgumentException(
                    "TrueFalseEvaluator requires a TrueFalseQuestion"
            );
        }

        TrueFalseQuestion trueFalseQuestion =
                (TrueFalseQuestion) question;

        String normalizedAnswer = answer.trim();

        if (!normalizedAnswer.equalsIgnoreCase("true")
                && !normalizedAnswer.equalsIgnoreCase("false")) {
            return 0;
        }

        boolean submittedAnswer =
                Boolean.parseBoolean(normalizedAnswer);

        if (submittedAnswer == trueFalseQuestion.getCorrectAnswer()) {
            return trueFalseQuestion.getPoints();
        }

        return 0;
    }
}