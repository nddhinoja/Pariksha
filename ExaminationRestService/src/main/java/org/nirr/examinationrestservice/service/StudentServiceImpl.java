package org.nirr.examinationrestservice.service;

import org.dippy.entities.ExamTblm;
import org.dippy.entities.OptionTblm;
import org.dippy.entities.QuestionTblm;
import org.dippy.entities.UserTblm;
import org.dippy.models.*;
import org.nirr.examinationrestservice.dao.ExamDao;
import org.nirr.examinationrestservice.dao.RegistrationDao;
import org.nirr.examinationrestservice.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.sort;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;
    @Autowired
    ExamDao examDao;
    @Autowired
    RegistrationDao registrationDao;

    public StudentServiceImpl(StudentDao studentDao, ExamDao examDao, RegistrationDao registrationDao) {
        this.studentDao = studentDao;
        this.examDao = examDao;
        this.registrationDao = registrationDao;
    }

    @Override
    public List<QuestionTblm> retriveQuestionPaper(String subject) {
        List<Question> listModel = new ArrayList<>();
        List<QuestionTblm> copyListEntity = studentDao.retriveQuestionPaper(subject);
        List<QuestionTblm> listEntity;
        List<QuestionTblm> randomList = new ArrayList<>();
        Random random = new Random();

        int randomIndex = 0;
        double marks = 0.0;
        double totalPaper = 15.0;
        double weightage = 0.0;

        while(copyListEntity.size()>8) {
            if(randomList.size()==8 && marks==15){
                break;
            }
            randomList = new ArrayList<>();
            listEntity = new ArrayList<>(copyListEntity);
            marks = 0.0;randomIndex = 0;
            int countHalf=0; int countOne = 0; int countOneAndHalf = 0; int countTwo = 0; int countTwoAndHalf = 0;
            int countThree = 0; int countThreeAndHalf = 0;

            while (!listEntity.isEmpty() && randomList.size()<8){
                randomIndex = random.nextInt(listEntity.size());
                QuestionTblm questionTblm = listEntity.get(randomIndex);
                if ((questionTblm.getWeightage() == 3.5) && (countThreeAndHalf <= 2)) {
                    if (marks + 3.5 <= totalPaper) {
                        marks = marks + 3.5;
                        countThreeAndHalf++;
                        randomList.add(questionTblm);
                    }
                }
                else if ((questionTblm.getWeightage() == 3.0) && (countThree <= 1)) {
                    if (marks + 3.0 <= totalPaper) {
                        marks = marks + 3.0;
                        countThree++;
                        randomList.add(questionTblm);
                    }
                }
                else if ((questionTblm.getWeightage() == 2.5) && (countTwoAndHalf <= 2)) {
                    if (marks + 2.5 <= totalPaper) {
                        marks = marks + 2.5;
                        countTwoAndHalf++;
                        randomList.add(questionTblm);
                    }
                }
                else if ((questionTblm.getWeightage() == 2.0) && (countTwo <= 1)) {
                    if (marks + 2.0 <= totalPaper) {
                        marks = marks + 2.0;
                        countTwo++;
                        randomList.add(questionTblm);
                    }
                }
                else if ((questionTblm.getWeightage() == 1.5) && (countOneAndHalf <= 2)) {
                    if (marks + 1.5 <= totalPaper) {
                        marks = marks + 1.5;
                        countOneAndHalf++;
                        randomList.add(questionTblm);
                    }
                }
                else if ((questionTblm.getWeightage() == 1.0) && (countOne <= 1)) {
                    if (marks + 1.0 <= totalPaper) {
                        marks = marks + 1.0;
                        countOne++;
                        randomList.add(questionTblm);
                    }
                }
                else if ((questionTblm.getWeightage() == 0.5)) {
                    if (marks + 0.5 <= totalPaper) {
                        marks = marks + 0.5;
                        countHalf++;
                        randomList.add(questionTblm);
                    }
                }
                if(randomList.size()==8 && marks==15){
                    break;
                }
            /*Question question = new Question();
            question.setQuestionId(Long.valueOf(listEntity.get(randomIndex).getQuestionId()));
            question.setQuestionContent(listEntity.get(randomIndex).getQuestion());
            List<OptionTblm> listOptionTblm = new ArrayList<>(listEntity.get(randomIndex).getListOfoptionTblm());
            List<Option> listOption = new ArrayList<>(4);
            for (int j = 0; j < listOptionTblm.size(); j++) {
                Option option = new Option(listOptionTblm.get(j).getOptionId(), listOptionTblm.get(j).getOptionContent(),
                        listOptionTblm.get(j).isFlag());
                //option.setQuestion(question);
                listOption.add(option);
            }
            question.setOptionList(listOption);
        listModel.add(question);*/
                listEntity.remove(randomIndex);
            }
        }
        return randomList;
    }

    @Override
    public Double calculation(Result resultObject) {
        Double result = 0D;
        List<Long> questionIds = new ArrayList<>();
        for(StudentPaper studentPaper:resultObject.getList()){
            questionIds.add(studentPaper.getQuestionId());
        }
        List<QuestionTblm> questionTblmList = studentDao.findAllById(questionIds);

        Collections.sort(resultObject.getList());

        int i = 0;
        for(QuestionTblm questionTblm:questionTblmList){
            if(questionTblm.getQuestionId()==resultObject.getList().get(i).getQuestionId()) {
                for (OptionTblm optionTblm : questionTblm.getListOfoptionTblm()) {
                    if (optionTblm.isFlag()) {
                        if(optionTblm.getOptionId()==resultObject.getList().get(i).getSelectedAnswer()){
                            result = result + questionTblm.getWeightage();
                        }
                    }
                }
            }
            i++;
        }
        examDao.saveResult(result,resultObject.getExamId());

        return result;
    }

    @Override
    public Exam createExam(Exam exam) {

        UserTblm userTblm = new UserTblm(exam.getUser().getUserName(),exam.getUser().getUserCategory(),
                exam.getUser().getName(),exam.getUser().getBirthDate(),exam.getUser().getEmailId());

        Set<QuestionTblm> questionTblmsSet = new HashSet<>(retriveQuestionPaper(exam.getSubject()));

        ExamTblm examTblm = new ExamTblm(exam.getExamDate(),exam.getSubject(),userTblm,questionTblmsSet);

        Set<ExamTblm> examTblmList = registrationDao.findExamTblmSet(exam.getUser().getUserName());
        examTblmList.add(examTblm);
        userTblm.setExamTblmList(examTblmList);
        examTblm.setUserTblm(userTblm);

        ExamTblm examTblm1 = examDao.save(examTblm);

        User user = new User(examTblm1.getUserTblm().getUserCategory(), examTblm1.getUserTblm().getName(),
                examTblm1.getUserTblm().getBirthDate(), examTblm1.getUserTblm().getEmailId());
        Set<QuestionTblm> questionTblmSet = examTblm1.getQuestionTblms();
        List<Question> questionList = converterQuestionTblmToQuestion(new ArrayList<>(questionTblmSet));
        Exam exam1 = new Exam(examTblm1.getExamId(),examTblm1.getExamSubject(),examTblm1.getExamDate(),questionList, user);
        return exam1;
    }

    private List<Question> converterQuestionTblmToQuestion(ArrayList<QuestionTblm> questionTblms) {
        List<Question> questionList = new ArrayList<>();
        for(QuestionTblm questionTblm:questionTblms){
            List<Option> optionList = new ArrayList<>();
            for(OptionTblm optionTblm:questionTblm.getListOfoptionTblm()){
                Option option = new Option(optionTblm.getOptionId(),optionTblm.getOptionContent(),optionTblm.isFlag());
                optionList.add(option);
            }
            Question question = new Question(questionTblm.getQuestionId(),questionTblm.getQuestion(),optionList);
            question.setWeightage(questionTblm.getWeightage());
            questionList.add(question);
        }
        return questionList;
    }

}
