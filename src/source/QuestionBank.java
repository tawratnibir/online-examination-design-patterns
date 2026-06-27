package source;

import question.Question;
import question.QuestionType;
import question.essay.EssayQuestion;
import question.mcq.MCQQuestion;
import question.programming.ProgrammingQuestion;
import question.truefalse.TrueFalseQuestion;

import java.util.Random;

public class QuestionBank {
    private static final Random RANDOM = new Random();

    private static final Question[] MCQ_QUESTIONS = {
            new MCQQuestion(
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
            ),

            new MCQQuestion(
                    "Which keyword is used to inherit a class in Java?",
                    new String[]{
                            "implements",
                            "inherits",
                            "extends",
                            "super"
                    },
                    "C",
                    2,
                    "Easy"
            )
    };

    private static final Question[] TRUE_FALSE_QUESTIONS = {
            new TrueFalseQuestion(
                    "An interface can be instantiated directly in Java.",
                    false,
                    1,
                    "Easy"
            ),

            new TrueFalseQuestion(
                    "A final class cannot be extended.",
                    true,
                    1,
                    "Easy"
            )
    };

    private static final Question[] ESSAY_QUESTIONS = {
            new EssayQuestion(
                    "Explain the benefits of encapsulation.",
                    new String[]{
                            "data hiding",
                            "access control",
                            "maintainability"
                    },
                    10,
                    "Hard"
            ),

            new EssayQuestion(
                    "Explain the Open/Closed Principle.",
                    new String[]{
                            "extension",
                            "modification",
                            "abstraction"
                    },
                    10,
                    "Hard"
            )
    };

    private static final Question[] PROGRAMMING_QUESTIONS = {
            new ProgrammingQuestion(
                    "What is the output of: System.out.println(2 + 3);",
                    "5",
                    20,
                    "Medium"
            ),

            new ProgrammingQuestion(
                    "What is the output of: System.out.println(10 / 2);",
                    "5",
                    20,
                    "Medium"
            )
    };

    private QuestionBank() {
    }

    public static Question getRandomQuestion(
            QuestionType questionType
    ) {
        if (questionType == null) {
            throw new IllegalArgumentException(
                    "Question type cannot be null."
            );
        }

        switch (questionType) {
            case MCQ:
                return selectRandom(MCQ_QUESTIONS);

            case TRUE_FALSE:
                return selectRandom(TRUE_FALSE_QUESTIONS);

            case ESSAY:
                return selectRandom(ESSAY_QUESTIONS);

            case PROGRAMMING:
                return selectRandom(PROGRAMMING_QUESTIONS);

            default:
                throw new IllegalArgumentException(
                        "Unsupported question type."
                );
        }
    }

    private static Question selectRandom(Question[] questions) {
        int index = RANDOM.nextInt(questions.length);
        return questions[index];
    }
}
