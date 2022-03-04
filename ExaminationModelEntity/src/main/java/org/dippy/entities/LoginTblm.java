package org.dippy.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBLM_LOGIN")
public class LoginTblm {

    String userId;
    String password;
    private UserTblm userTblm;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(mappedBy = "loginTblm")
    @PrimaryKeyJoinColumn
    public UserTblm getUserTblm() {
        return userTblm;
    }

    public void setUserTblm(UserTblm userTblm) {
        this.userTblm = userTblm;
    }
}
