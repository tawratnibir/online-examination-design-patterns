public class MCQFactory implements QuestionFactory {

    @Override
    public Question createQuestion() {
        return new MCQQuestion(
                "Which SOLID principle says a class should have one reason to change?",
                new String[]{
                        "Open/Closed Principle",
                        "Single Responsibility Principle",
                        "Liskov Substitution Principle",
                        "Dependency Inversion Principle"
                },
                "B",
                2,
                "Medium"
        );
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new MCQRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new MCQEvaluator();
    }
}