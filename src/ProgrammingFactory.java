public class ProgrammingFactory implements QuestionFactory {

    @Override
    public Question createQuestion() {
        return new ProgrammingQuestion(
                "What is the output of: System.out.println(2 + 2);",
                "4",
                20,
                "Hard"
        );
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