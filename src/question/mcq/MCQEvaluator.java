package question.mcq;

import question.Question;
import question.QuestionEvaluator;

public class MCQEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question question, String answer) {
        if (!(question instanceof MCQQuestion)) {
            throw new IllegalArgumentException(
                    "MCQEvaluator requires an MCQQuestion."
            );
        }

        MCQQuestion mcq = (MCQQuestion) question;

        if (answer == null) {
            return 0;
        }

        if (mcq.getCorrectAnswer().equalsIgnoreCase(answer.trim())) {
            return mcq.getPoints();
        }

        return 0;
    }
}
