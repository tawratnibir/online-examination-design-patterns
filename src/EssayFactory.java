public class EssayFactory implements QuestionFactory {

    @Override
    public Question createQuestion() {
        return new EssayQuestion(
                "Explain the benefits of encapsulation in object-oriented programming.",
                new String[]{
                        "data hiding",
                        "access control",
                        "maintainability"
                },
                10,
                "Hard"
        );
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new EssayRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new EssayEvaluator();
    }
}