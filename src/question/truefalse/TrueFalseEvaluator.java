package question.truefalse;

import question.Question;
import question.QuestionEvaluator;

public class TrueFalseEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question question, String answer) {
        if (!(question instanceof TrueFalseQuestion)) {
            throw new IllegalArgumentException(
                    "TrueFalseEvaluator requires a TrueFalseQuestion."
            );
        }

        TrueFalseQuestion trueFalseQuestion =
                (TrueFalseQuestion) question;

        if (answer == null) {
            return 0;
        }

        String normalizedAnswer = answer.trim();
        boolean submittedAnswer;

        if (normalizedAnswer.equalsIgnoreCase("A")
                || normalizedAnswer.equalsIgnoreCase("true")) {
            submittedAnswer = true;
        } else if (normalizedAnswer.equalsIgnoreCase("B")
                || normalizedAnswer.equalsIgnoreCase("false")) {
            submittedAnswer = false;
        } else {
            return 0;
        }

        if (submittedAnswer == trueFalseQuestion.getCorrectAnswer()) {
            return trueFalseQuestion.getPoints();
        }

        return 0;
    }
}
