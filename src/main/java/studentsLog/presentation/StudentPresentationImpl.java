package studentsLog.presentation;

import com.prateek.Main;
import com.sun.corba.se.spi.orb.Operation;
import studentsLog.pojos.Student;
import studentsLog.service.StudentSerivce;
import studentsLog.service.StudentServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;
import static java.util.stream.Collectors.toList;

public class StudentPresentationImpl implements StudentPresentation {
    private StudentSerivce stdSerivce=new StudentServiceImpl();


    @Override
    public void showMenu() {
        System.out.println("1. List Students\n2.Highest Percentage");
        System.out.println("3.Highest Percentage\n4. Highest in Math");
        System.out.println("5. List Percentage");

    }

    @Override
    public void performMenu(int choice) {
        Collection<Student> student=stdSerivce.getAllStudents();
        List<Student> studentList= new ArrayList<>(student);
        Scanner scanner=new Scanner(System.in);
        switch(choice){
            case 1:

                for(Student s:student){
                    System.out.println(new Operations().ListStudents(s));
                }
                break;
            case 2:
                double maxMarks=-999999;
                String name="",roll="";
                for(Student s:student){
                    double sum=s.getMarksEng()+s.getMarksMath()+s.getMarksScience();
                    if(sum>maxMarks){
                        roll=s.getRollNum();
                        name=s.getsName();
                    }
                }
                System.out.println(name+"   "+roll);
                break;
            case 3:
                double mathMark=0;
                for(Student s:student){
                    mathMark= Math.max(s.getMarksMath(),mathMark);
                }
                for(Student s:student){
                    if(s.getMarksMath()==mathMark){
                        System.out.println(s.getRollNum()+"  "+s.getsName());
                    }
                }
                break;
            case 4:
                sort(studentList,new Sorting());
                studentList.forEach(s->System.out.println(new Operations().ListStudents(s)));
                break;
            case 5:
                sort(studentList,new SortingPercet());
                studentList.forEach(s->System.out.println(new Operations().ListStudents(s)));
        }
    }
}
class Operations{
    String ListStudents(Student s){
        return s.getRollNum()+"   "+s.getsName();
    }
}
class Sorting implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Student s1=(Student) o1;
        Student s2=(Student) o2;
        if(s1.getMarksMath()>s2.getMarksMath()){
            return -1;
        }
        if (s1.getMarksMath()<s2.getMarksMath()){
            return 1;
        }

        return 0;
    }
}
class SortingPercet implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1=(Student) o1;
        Student s2=(Student) o2;
        if((s1.getMarksMath()+s1.getMarksScience()+s1.getMarksEng())>((s2.getMarksMath()+s2.getMarksScience()+s2.getMarksEng()))){
            return -1;
        }
        if ((s1.getMarksMath()+s1.getMarksScience()+s1.getMarksEng())<(s2.getMarksMath()+s2.getMarksScience()+s2.getMarksEng())){
            return 1;
        }
        return 0;
    }
}

class SorintgMathSci implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Student s1=(Student) o1;
        Student s2=(Student) o2;
        if((s1.getMarksMath()+s1.getMarksScience())>(s2.getMarksMath()+s2.getMarksScience())){
            return -1;
        }
        if ((s1.getMarksMath()+s1.getMarksScience())<(s2.getMarksMath()+s2.getMarksScience())){
            return 1;
        }

        return 0;
    }
}