package org.dippy.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TBLM_USER")
public class UserTblm {

    private String userId;
    private String userCategory;
    private String name;
    private String birthDate;
    private String emailId;
    private LoginTblm loginTblm;
    private Set<ExamTblm> examTblmList;

    public UserTblm() {
    }

    public UserTblm(String userId, String userCategory, String name, String birthDate, String emailId) {
        this.userId = userId;
        this.userCategory = userCategory;
        this.name = name;
        this.birthDate = birthDate;
        this.emailId = emailId;
    }


    @Id
    @Column(name = "USER_ID")
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "USER_CATEGORY")
    public String getUserCategory() {
        return userCategory;
    }
    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "USER_BIRTHDATE")
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "USER_EMAILID")
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @OneToOne
    @MapsId
    @JoinColumn(name = "USERID")
    public LoginTblm getLoginTblm() {return loginTblm;}
    public void setLoginTblm(LoginTblm loginTblm) {this.loginTblm = loginTblm;}

    @OneToMany(mappedBy = "userTblm")
    public Set<ExamTblm> getExamTblmList() {return examTblmList;}
    public void setExamTblmList(Set<ExamTblm> examTblmList) {this.examTblmList = examTblmList;}
}
