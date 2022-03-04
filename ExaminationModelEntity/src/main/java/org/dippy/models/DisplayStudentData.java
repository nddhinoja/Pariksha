package org.dippy.models;

import java.util.List;

public class DisplayStudentData {

    List<User> listOfUser;

    public DisplayStudentData(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }

    public List<User> getListOfUser() {
        return listOfUser;
    }

    public void setListOfUser(List<User> listOfUser) {
        this.listOfUser = listOfUser;
    }
}
