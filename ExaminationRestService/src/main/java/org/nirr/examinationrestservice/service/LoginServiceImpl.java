package org.nirr.examinationrestservice.service;

import org.dippy.entities.ExamTblm;
import org.dippy.entities.QuestionTblm;
import org.dippy.entities.UserTblm;
import org.dippy.models.*;
import org.nirr.examinationrestservice.dao.LoginDao;
import org.nirr.examinationrestservice.dao.RegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    LoginDao loginDao;
    @Autowired
    RegistrationDao registrationDao;

    public LoginServiceImpl(LoginDao loginDao, RegistrationDao registrationDao) {
        this.loginDao = loginDao;
        this.registrationDao = registrationDao;
    }

    public User validateUser(Login login) {
        User user = null;
        String userId = loginDao.existsLoginTblmByUserIdAndPassword(login.getUserName(),login.getPassword());

        if (userId != null) {

            UserTblm userTblm = registrationDao.getById(userId);
            user = new User(userTblm.getUserCategory(), userTblm.getName(), userTblm.getBirthDate(),
                    userTblm.getEmailId(), userTblm.getUserId());
        }
        return user;
    }

    /*private List<Exam> examTblmSetToexamList(Set<ExamTblm> examTblmList) {
        List<Exam> examList = new ArrayList<>();
        List<ExamTblm> examTblmList1 = new ArrayList<>(examTblmList);
        for(ExamTblm examTblm:examTblmList1){
            Exam exam = new Exam();
            exam.setExamDate(examTblm.getExamDate());
            exam.setSubject(examTblm.getExamSubject());
            List<Question> list = questionTblmSetToQuestionList(examTblm.getQuestionTblms());
            examTblm.getQuestionTblms();
            examList.add(examTblm);
        }
    }

    private List<Question> questionTblmSetToQuestionList(Set<QuestionTblm> questionTblms) {
        List<QuestionTblm> questionTblmList = new ArrayList<>(questionTblms);
        List<Question> list = new ArrayList<>();
        for(QuestionTblm questionTblm:questionTblmList){
            Question question = new Question();
            question.se
        }
    }*/

    public User validateEmail(String emailId) {
        UserTblm userTblm = registrationDao.validateEmail(emailId);
        User user = new User(userTblm.getUserCategory(), userTblm.getName(), userTblm.getBirthDate(), userTblm.getEmailId(),userTblm.getUserId());
        return user;
    }
}
