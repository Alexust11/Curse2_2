package pro.sky.curse2_2.Service;

import pro.sky.curse2_2.Model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
