package com.example.krishnatejaare.schools;

/**
 * Created by Krishna Teja Are on 4/12/2018.
 */

public class ResultsReadTask {
    private String school_name;
    private String id;
    private String total_students;
    private String reading;
    private String math;
    private String writing;

    @Override
    public String toString() {
        return "ResultsReadTask{" +
                "school_name='" + school_name + '\'' +
                ", id='" + id + '\'' +
                ", total_students='" + total_students + '\'' +
                ", reading='" + reading + '\'' +
                ", math='" + math + '\'' +
                ", writing='" + writing + '\'' +
                '}';
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotal_students() {
        return total_students;
    }

    public void setTotal_students(String total_students) {
        this.total_students = total_students;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }
}
