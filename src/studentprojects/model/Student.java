/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprojects.model;

import java.io.Serializable;

/**
 *
 * @author 503
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 6529685098267757691L;
    private int id;
    private String name;
    private int yearOfBirth;
    private String placeOfBirth;
    private String classroom;

    public Student(int id, String name, int yearOfBirth, String placeOfBirth, String classroom) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.classroom = classroom;
    }

    public Student(String name, int yearOfBirth, String placeOfBirth, String classroom) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
    public Object[] toObjects(){
        return new Object[]{id,name,yearOfBirth,placeOfBirth,classroom};
    }
}