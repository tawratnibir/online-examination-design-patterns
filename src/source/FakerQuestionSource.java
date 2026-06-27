package source;

import question.Question;
import question.QuestionType;

public class FakerQuestionSource implements QuestionSource {
    private final QuestionType questionType;
    private final QuestionFaker questionFaker;

    public FakerQuestionSource(QuestionType questionType) {
        if (questionType == null) {
            throw new IllegalArgumentException(
                    "Question type cannot be null."
            );
        }

        this.questionType = questionType;
        this.questionFaker = new QuestionFaker();
    }

    @Override
    public Question getQuestion() {
        return questionFaker.generateQuestion(questionType);
    }
}
