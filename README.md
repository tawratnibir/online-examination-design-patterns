# Creational Assignment

A Java console project that models an exam-generation system using multiple design patterns without adding external frameworks or dependencies.

## Patterns Used

- Factory Method: creates concrete exam types through `exam.factory.ExamFactory` and its subclasses.
- Abstract Factory: creates question families through `question.QuestionFactory` implementations such as `MCQFactory`, `EssayFactory`, `ProgrammingFactory`, and `TrueFalseFactory`.
- Builder: constructs immutable exam settings through `configuration.ExamBuilder` and `configuration.ExamConfiguration`.
- Dependency Injection / IoC: injects a `source.QuestionSource` into each question factory so question creation is decoupled from question origin.

## Current Demo Flow

`app.Main` demonstrates the final integrated workflow by:

1. Creating a `MidtermExam` through `MidtermExamFactory`.
2. Using Question Bank mode through `BankQuestionSource`.
3. Creating these question families:
   - MCQ
   - MCQ
   - Essay
   - Programming
   - True/False
4. Building the exam configuration with:
   - Title: `OOP Midterm Exam`
   - Duration: `60 minutes`
   - Passing Score: `50 Marks`
   - Negative Marking: enabled
   - Question Shuffle: enabled
   - Calculator Allowed: disabled
   - Auto Submit: enabled
5. Printing a clean dashboard generated from the actual `Question` objects.

## Project Structure

```text
src/
  app/
    Main.java
  configuration/
    ExamBuilder.java
    ExamConfiguration.java
  exam/
    Exam.java
    PracticeQuiz.java
    MidtermExam.java
    FinalExam.java
  exam/factory/
    ExamFactory.java
    PracticeQuizFactory.java
    MidtermExamFactory.java
    FinalExamFactory.java
  question/
    Question.java
    QuestionFactory.java
    QuestionRenderer.java
    QuestionEvaluator.java
    QuestionType.java
  question/mcq/
  question/essay/
  question/programming/
  question/truefalse/
  source/
    QuestionSource.java
    BankQuestionSource.java
    FakerQuestionSource.java
    ManualQuestionSource.java
    QuestionBank.java
    QuestionFaker.java
```

## Responsibilities

- `exam` package: exam behavior and exam-type metadata.
- `exam.factory` package: exam creation.
- `question` package: shared question abstractions.
- `question.<type>` packages: concrete question data, renderers, evaluators, and factories.
- `source` package: question origin strategies.
- `configuration` package: immutable exam configuration and fluent builder.
- `app.Main`: orchestration only.

## Question Sources

The project keeps three question-source modes:

- `BankQuestionSource`: selects questions from the built-in question bank.
- `FakerQuestionSource`: generates synthetic questions dynamically.
- `ManualQuestionSource`: wraps a manually supplied `Question` object.

## Compile and Run

From the project root in PowerShell:

```powershell
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out app.Main
```

If compilation succeeds, the program prints an exam dashboard similar to:

```text
=====================================================================
                     EXAM CREATED SUCCESSFULLY
=====================================================================
Type: Midterm Exam
Title: OOP Midterm Exam
Duration: 60 minutes
Passing Score: 50 Marks
...
```

## Notes

- No external libraries, frameworks, databases, or build tools are required.
- Package names are lowercase and follow the current folder structure.
- `ExamConfiguration` is immutable and must be created through `ExamBuilder`.
- Question factories validate that the injected source returns the correct question family.
