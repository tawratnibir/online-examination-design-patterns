public class Main {
    public static void main(String[] args) {
        demonstrateBankSource();
        demonstrateFakerSource();
        demonstrateManualSource();
    }

    private static void demonstrateBankSource() {
        QuestionSource source =
                new BankQuestionSource(QuestionType.MCQ);

        QuestionFactory factory = new MCQFactory(source);

        displayQuestion("Question Bank Mode", factory);
    }

    private static void demonstrateFakerSource() {
        QuestionSource source =
                new FakerQuestionSource(QuestionType.ESSAY);

        QuestionFactory factory = new EssayFactory(source);

        displayQuestion("Faker Mode", factory);
    }

    private static void demonstrateManualSource() {
        Question question = new TrueFalseQuestion(
                "Java supports multiple class inheritance.",
                false,
                1,
                "Easy"
        );

        QuestionSource source =
                new ManualQuestionSource(question);

        QuestionFactory factory =
                new TrueFalseFactory(source);

        displayQuestion("Manual Mode", factory);
    }

    private static void displayQuestion(
            String sourceName,
            QuestionFactory factory
    ) {
        Question question = factory.createQuestion();
        QuestionRenderer renderer = factory.createRenderer();
        QuestionEvaluator evaluator = factory.createEvaluator();

        System.out.println("====================================");
        System.out.println("Question Source: " + sourceName);

        renderer.render(question);

        System.out.println(
                "Evaluator: "
                        + evaluator.getClass().getSimpleName()
        );
    }
}