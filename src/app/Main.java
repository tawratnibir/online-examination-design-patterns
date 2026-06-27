package app;

import configuration.ExamBuilder;
import configuration.ExamConfiguration;
import exam.Exam;
import exam.factory.ExamFactory;
import exam.factory.MidtermExamFactory;
import question.Question;
import question.QuestionFactory;
import question.QuestionType;
import question.essay.EssayFactory;
import question.mcq.MCQFactory;
import question.programming.ProgrammingFactory;
import question.truefalse.TrueFalseFactory;
import source.BankQuestionSource;
import source.QuestionSource;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String SEPARATOR =
            "=====================================================================";

    public static void main(String[] args) {
        ExamFactory examFactory = new MidtermExamFactory();
        Exam exam = examFactory.createExam();

        ExamConfiguration configuration = new ExamBuilder()
                .setTitle("OOP Midterm Exam")
                .setDuration(60)
                .setPassingScore(50)
                .enableNegativeMarking()
                .enableQuestionShuffle()
                .disableCalculator()
                .enableAutoSubmit()
                .build();

        List<Question> questions = createQuestions();

        printDashboard(exam, configuration, questions);
    }

    private static List<Question> createQuestions() {
        QuestionSource firstMcqSource =
                new BankQuestionSource(QuestionType.MCQ);
        QuestionSource secondMcqSource =
                new BankQuestionSource(QuestionType.MCQ);
        QuestionSource essaySource =
                new BankQuestionSource(QuestionType.ESSAY);
        QuestionSource programmingSource =
                new BankQuestionSource(QuestionType.PROGRAMMING);
        QuestionSource trueFalseSource =
                new BankQuestionSource(QuestionType.TRUE_FALSE);

        QuestionFactory[] factories = {
                new MCQFactory(firstMcqSource),
                new MCQFactory(secondMcqSource),
                new EssayFactory(essaySource),
                new ProgrammingFactory(programmingSource),
                new TrueFalseFactory(trueFalseSource)
        };

        List<Question> questions = new ArrayList<>();

        for (QuestionFactory factory : factories) {
            questions.add(factory.createQuestion());
        }

        return questions;
    }

    private static void printDashboard(
            Exam exam,
            ExamConfiguration configuration,
            List<Question> questions
    ) {
        System.out.println(SEPARATOR);
        System.out.println("                     EXAM CREATED SUCCESSFULLY");
        System.out.println(SEPARATOR);
        System.out.println("Type: " + exam.getType());
        System.out.println("Title: " + configuration.getTitle());
        System.out.println(
                "Duration: " + configuration.getDuration() + " minutes"
        );
        System.out.println(
                "Passing Score: "
                        + configuration.getPassingScore()
                        + " Marks"
        );
        System.out.println();
        System.out.println("Configuration Profiles:");
        printProfile(
                "Negative Marking Enabled",
                configuration.isNegativeMarking()
        );
        printProfile(
                "Question Shuffle Activated",
                configuration.isQuestionShuffle()
        );
        printProfile(
                "Embedded Calculator Allowed",
                configuration.isCalculatorAllowed()
        );
        printProfile(
                "Auto-Submit On Timeout",
                configuration.isAutoSubmit()
        );
        System.out.println();
        System.out.println("Question Sourcing Strategy: Question Bank Mode");
        System.out.println();
        System.out.println("Compiled Structural Components:");

        for (Question question : questions) {
            System.out.println(
                    "- [Type: "
                            + question.getType()
                            + "] Points: "
                            + question.getPoints()
                            + " Difficulty: "
                            + question.getDifficulty()
            );
        }

        System.out.println(SEPARATOR);
    }

    private static void printProfile(String label, boolean enabled) {
        String status = enabled ? "[ON] " : "[OFF] ";
        System.out.println(status + label);
    }
}
