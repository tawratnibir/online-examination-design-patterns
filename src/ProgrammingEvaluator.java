public class ProgrammingEvaluator implements QuestionEvaluator {

    @Override
    public int evaluate(Question question, String answer) {
        if (!(question instanceof ProgrammingQuestion)) {
            throw new IllegalArgumentException(
                    "ProgrammingEvaluator requires a ProgrammingQuestion"
            );
        }

        ProgrammingQuestion programmingQuestion =
                (ProgrammingQuestion) question;

        if (programmingQuestion.getExpectedOutput()
                .equals(answer.trim())) {
            return programmingQuestion.getPoints();
        }

        return 0;
    }
}