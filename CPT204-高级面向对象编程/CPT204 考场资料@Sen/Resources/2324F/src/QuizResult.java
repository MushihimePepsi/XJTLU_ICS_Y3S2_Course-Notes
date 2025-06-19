import java.io.Serializable;

public class QuizResult implements Scorable {

    private int correctAnswers;
    private int totalQuestions;

    public QuizResult(int correctAnswers, int totalQuestions) {
        this.correctAnswers = correctAnswers;
        this.totalQuestions = totalQuestions;
    }

    @Override
    public int getScore() {
        if (totalQuestions == 0){
            return 0;
        }
        else {
            double correctAnswersDouble = correctAnswers;
            double totalAnswersDouble = totalQuestions;
            return (int)Math.round(correctAnswersDouble/totalAnswersDouble * 100);
        }
    }

    public static void main(String[] args) {
        QuizResult q1 = new QuizResult(5, 2);
        System.out.println(q1.getScore());
        QuizResult q2 = new QuizResult(555, 1000);
        System.out.println(q2.getScore());
        QuizResult q3 = new QuizResult(4, 0);
        System.out.println(q3.getScore());
    }
}
