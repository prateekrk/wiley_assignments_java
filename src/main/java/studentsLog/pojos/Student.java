package studentsLog.pojos;

public class Student {
    private String rollNum,sName;
    private double marksEng,marksMath,marksScience;
    private double percentage;

    public Student(String rollNum,String sName, double marksEng, double marksMath, double marksScience) {
        this.rollNum=rollNum;
        this.sName = sName;
        this.marksEng = marksEng;
        this.marksMath = marksMath;
        this.marksScience = marksScience;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public double getMarksEng() {
        return marksEng;
    }

    public void setMarksEng(double marksEng) {
        this.marksEng = marksEng;
    }

    public double getMarksMath() {
        return marksMath;
    }

    public void setMarksMath(double marksMath) {
        this.marksMath = marksMath;
    }

    public double getMarksScience() {
        return marksScience;
    }

    public void setMarksScience(double marksScience) {
        this.marksScience = marksScience;
    }

    public void setPercentage(double percentage) {
        this.percentage = (((this.marksEng+this.marksMath+this.marksScience)/300.0)*100);
    }

    public double getPercentage() {
        return percentage;
    }
}
