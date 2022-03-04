package org.nirr.examinationrestservice.service;

import org.dippy.entities.ExamTblm;
import org.dippy.entities.OptionTblm;
import org.dippy.entities.QuestionTblm;
import org.dippy.models.Exam;
import org.dippy.models.Option;
import org.dippy.models.Question;
import org.dippy.models.User;
import org.nirr.examinationrestservice.dao.ExamDao;
import org.nirr.examinationrestservice.dao.FacultyDao;
import org.nirr.examinationrestservice.dao.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    FacultyDao facultyDao;
    @Autowired
    OptionDao optionDao;
    @Autowired
    ExamDao examDao;

    public FacultyServiceImpl(FacultyDao facultyDao, OptionDao optionDao, ExamDao examDao) {
        this.facultyDao = facultyDao;
        this.optionDao = optionDao;
        this.examDao = examDao;
    }

    @Override
    public void saveQuestion(Question question) {
        QuestionTblm questionTblm = new QuestionTblm();
        questionTblm.setQuestion(question.getQuestionContent());
        questionTblm.setQuestionSub(question.getQuestionSub());
        questionTblm.setWeightage(question.getWeightage());

        List<Option> listOption =   question.getOptionList();
        List<OptionTblm> listOptionTblm = new ArrayList<>();
        int i =0;
        for(Option option: listOption){
            OptionTblm optionTblm = new OptionTblm(listOption.get(i).getOptionContent(),listOption.get(i).isFlag());
            listOptionTblm.add(optionTblm);
            optionTblm.setQuestionTblm(questionTblm);
            i++;
        }
        Set<OptionTblm> setOptionTblm = new HashSet<>(listOptionTblm);
        questionTblm.setListOfoptionTblm(setOptionTblm);

        facultyDao.save(questionTblm);

    }

    @Override
    public List<Question> retriveQuestionBank(Exam examSubject) {
        List<QuestionTblm> questionTblmList =   facultyDao.findAllByQuestionSub(examSubject.getSubject());

        List<Question> questionList = new ArrayList<>();
        for(QuestionTblm questionTblm:questionTblmList){

            List<Option> optionList = new ArrayList<>();
            for(OptionTblm optionTblm:questionTblm.getListOfoptionTblm()){
                Option option = new Option(optionTblm.getOptionId(),optionTblm.getOptionContent(),optionTblm.isFlag());
                optionList.add(option);
            }
            Question question = new Question(questionTblm.getQuestionId(),questionTblm.getQuestion(),optionList,questionTblm.getWeightage(),questionTblm.getQuestionSub());
            questionList.add(question);
        }
        return questionList;
    }

    @Override
    public List<Exam> retrieveStudentDataOfExam() {
        List<ExamTblm> examTblmList = examDao.findAll();
        List<Exam> examList = new ArrayList<>();
        for(ExamTblm examTblm:examTblmList){
            User user = new User(examTblm.getUserTblm().getName());
            Exam exam = new Exam(examTblm.getExamId(),examTblm.getExamSubject(),examTblm.getExamDate(),examTblm.getResult(),user);
            examList.add(exam);
        }
        return examList;
    }
}
