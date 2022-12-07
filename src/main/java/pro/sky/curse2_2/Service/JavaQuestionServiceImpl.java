package pro.sky.curse2_2.Service;

import pro.sky.curse2_2.Model.Question;
import pro.sky.curse2_2.exception.QuestionAlreadyExistsException;
import pro.sky.curse2_2.exception.QuestionNotFoundException;

import java.util.*;

public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionServiceImpl(Set<Question> questions, Random random) {
        this.questions = questions;
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
         if (!questions.add(question)) {
            throw new QuestionAlreadyExistsException();
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;

          }

    @Override
    public Collection<Question> getAll() {
        return  Collections.unmodifiableCollection(new HashSet<>(questions));}

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));}
}
