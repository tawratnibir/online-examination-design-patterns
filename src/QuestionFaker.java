import java.util.Random;

public class QuestionFaker {
    private final Random random = new Random();

    private final String[] topics = {
            "encapsulation",
            "inheritance",
            "polymorphism",
            "abstraction"
    };

    public Question generateQuestion(
            QuestionType questionType
    ) {
        if (questionType == null) {
            throw new IllegalArgumentException(
                    "Question type cannot be null."
            );
        }

        switch (questionType) {
            case MCQ:
                return generateMCQ();

            case TRUE_FALSE:
                return generateTrueFalse();

            case ESSAY:
                return generateEssay();

            case PROGRAMMING:
                return generateProgramming();

            default:
                throw new IllegalArgumentException(
                        "Unsupported question type."
                );
        }
    }

    private Question generateMCQ() {
        String topic = randomTopic();

        return new MCQQuestion(
                "Which option is an important OOP concept related to "
                        + topic + "?",
                new String[]{
                        topic,
                        "Compilation error",
                        "Database table",
                        "Operating system"
                },
                "A",
                2,
                "Medium"
        );
    }

    private Question generateTrueFalse() {
        String topic = randomTopic();

        return new TrueFalseQuestion(
                topic + " is an object-oriented programming concept.",
                true,
                1,
                "Easy"
        );
    }

    private Question generateEssay() {
        String topic = randomTopic();

        return new EssayQuestion(
                "Explain " + topic
                        + " and its importance in object-oriented programming.",
                new String[]{
                        topic,
                        "object",
                        "maintainability"
                },
                10,
                "Hard"
        );
    }

    private Question generateProgramming() {
        int firstNumber = random.nextInt(10) + 1;
        int secondNumber = random.nextInt(10) + 1;
        int expectedResult = firstNumber + secondNumber;

        return new ProgrammingQuestion(
                "What is the output of: System.out.println("
                        + firstNumber
                        + " + "
                        + secondNumber
                        + ");",
                String.valueOf(expectedResult),
                20,
                "Medium"
        );
    }

    private String randomTopic() {
        int index = random.nextInt(topics.length);
        return topics[index];
    }
}