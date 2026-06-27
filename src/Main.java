public class Main {

    public static void main(String[] args) {
        testQuestionFamily(new MCQFactory(), "B");
        testQuestionFamily(new TrueFalseFactory(), "false");

        testQuestionFamily(
                new EssayFactory(),
                "Encapsulation provides data hiding, "
                        + "access control and better maintainability."
        );

        testQuestionFamily(new ProgrammingFactory(), "4");
    }

    private static void testQuestionFamily(
            QuestionFactory factory,
            String submittedAnswer
    ) {
        Question question = factory.createQuestion();

        QuestionRenderer renderer =
                factory.createRenderer();

        QuestionEvaluator evaluator =
                factory.createEvaluator();

        System.out.println("======================================");

        renderer.render(question);

        int score = evaluator.evaluate(
                question,
                submittedAnswer
        );

        System.out.println();
        System.out.println(
                "Submitted answer: " + submittedAnswer
        );
        System.out.println(
                "Obtained score: "
                        + score
                        + "/"
                        + question.getPoints()
        );

        System.out.println();
    }
}