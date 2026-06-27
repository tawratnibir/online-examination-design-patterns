public class BankQuestionSource implements QuestionSource {
    private final QuestionType questionType;

    public BankQuestionSource(QuestionType questionType) {
        if (questionType == null) {
            throw new IllegalArgumentException(
                    "Question type cannot be null."
            );
        }

        this.questionType = questionType;
    }

    @Override
    public Question getQuestion() {
        return QuestionBank.getRandomQuestion(questionType);
    }
}