public class ProgrammingRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        if (!(question instanceof ProgrammingQuestion)) {
            throw new IllegalArgumentException(
                    "ProgrammingRenderer requires a ProgrammingQuestion"
            );
        }

        ProgrammingQuestion programmingQuestion =
                (ProgrammingQuestion) question;

        System.out.println(
                "Type: " + programmingQuestion.getType()
        );
        System.out.println(
                "Difficulty: "
                        + programmingQuestion.getDifficulty()
        );
        System.out.println(
                "Points: " + programmingQuestion.getPoints()
        );
        System.out.println(programmingQuestion.getText());
        System.out.println("Submit the program's final output.");
    }
}