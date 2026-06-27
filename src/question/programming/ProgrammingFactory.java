package question.programming;

import question.Question;
import question.QuestionEvaluator;
import question.QuestionFactory;
import question.QuestionRenderer;
import source.QuestionSource;

public class ProgrammingFactory implements QuestionFactory {
    private final QuestionSource questionSource;

    public ProgrammingFactory(QuestionSource questionSource) {
        if (questionSource == null) {
            throw new IllegalArgumentException(
                    "Question source cannot be null."
            );
        }

        this.questionSource = questionSource;
    }

    @Override
    public Question createQuestion() {
        Question question = questionSource.getQuestion();

        if (!(question instanceof ProgrammingQuestion)) {
            throw new IllegalStateException(
                    "ProgrammingFactory requires a ProgrammingQuestion source."
            );
        }

        return question;
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new ProgrammingRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new ProgrammingEvaluator();
    }
}
