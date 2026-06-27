public class Main {
    public static void main(String[] args) {
        demonstrateBankSource();
        demonstrateFakerSource();
        demonstrateManualSource();
    }

    private static void demonstrateBankSource() {
        QuestionSource bankSource =
                new BankQuestionSource(QuestionType.MCQ);

        QuestionFactory factory =
                new MCQFactory(bankSource);

        displayQuestionFamily(
                "QUESTION BANK MODE",
                factory
        );
    }

    private static void demonstrateFakerSource() {
        QuestionSource fakerSource =
                new FakerQuestionSource(QuestionType.ESSAY);

        QuestionFactory factory =
                new EssayFactory(fakerSource);

        displayQuestionFamily(
                "FAKER MODE",
                factory
        );
    }

    private static void demonstrateManualSource() {
        Question manualQuestion =
                new TrueFalseQuestion(
                        "Java supports multiple class inheritance.",
                        false,
                        1,
                        "Easy"
                );

        QuestionSource manualSource =
                new ManualQuestionSource(manualQuestion);

        QuestionFactory factory =
                new TrueFalseFactory(manualSource);

        displayQuestionFamily(
                "MANUAL MODE",
                factory
        );
    }

    private static void displayQuestionFamily(
            String sourceName,
            QuestionFactory factory
    ) {
        Question question =
                factory.createQuestion();

        QuestionRenderer renderer =
                factory.createRenderer();

        QuestionEvaluator evaluator =
                factory.createEvaluator();

        System.out.println(
                "========================================"
        );

        System.out.println(
                "Question Source: " + sourceName
        );

        renderer.render(question);

        System.out.println(
                "Evaluator Created: "
                        + evaluator.getClass().getSimpleName()
        );

        System.out.println();
    }
}