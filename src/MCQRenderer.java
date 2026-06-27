public class MCQRenderer implements QuestionRenderer {

    @Override
    public void render(Question question) {
        if (!(question instanceof MCQQuestion)) {
            throw new IllegalArgumentException(
                    "MCQRenderer requires an MCQQuestion"
            );
        }

        MCQQuestion mcq = (MCQQuestion) question;

        System.out.println("Type: " + mcq.getType());
        System.out.println("Difficulty: " + mcq.getDifficulty());
        System.out.println("Points: " + mcq.getPoints());
        System.out.println(mcq.getText());

        String[] options = mcq.getOptions();

        for (int i = 0; i < options.length; i++) {
            char optionLabel = (char) ('A' + i);
            System.out.println(optionLabel + ". " + options[i]);
        }
    }
}