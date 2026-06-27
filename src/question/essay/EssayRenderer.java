package question.essay;

import question.Question;
import question.QuestionRenderer;

public class EssayRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        if (!(question instanceof EssayQuestion)) {
            throw new IllegalArgumentException(
                    "EssayRenderer requires an EssayQuestion."
            );
        }

        EssayQuestion essay = (EssayQuestion) question;

        System.out.println("Type: " + essay.getType());
        System.out.println("Difficulty: " + essay.getDifficulty());
        System.out.println("Points: " + essay.getPoints());
        System.out.println(essay.getText());
        System.out.println("Write a detailed answer.");
    }
}
