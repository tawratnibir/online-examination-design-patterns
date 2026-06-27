package source;

import question.Question;

public class ManualQuestionSource implements QuestionSource {
    private final Question question;

    public ManualQuestionSource(Question question) {
        if (question == null) {
            throw new IllegalArgumentException(
                    "Question cannot be null."
            );
        }

        this.question = question;
    }

    @Override
    public Question getQuestion() {
        return question;
    }
}
