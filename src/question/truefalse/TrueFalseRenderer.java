package question.truefalse;

import question.Question;
import question.QuestionRenderer;

public class TrueFalseRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        if (!(question instanceof TrueFalseQuestion)) {
            throw new IllegalArgumentException(
                    "TrueFalseRenderer requires a TrueFalseQuestion."
            );
        }

        TrueFalseQuestion trueFalseQuestion =
                (TrueFalseQuestion) question;

        System.out.println("Type: " + trueFalseQuestion.getType());
        System.out.println(
                "Difficulty: " + trueFalseQuestion.getDifficulty()
        );
        System.out.println("Points: " + trueFalseQuestion.getPoints());
        System.out.println(trueFalseQuestion.getText());
        System.out.println("A. True");
        System.out.println("B. False");
    }
}
