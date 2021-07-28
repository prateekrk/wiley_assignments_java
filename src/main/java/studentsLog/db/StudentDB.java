package studentsLog.db;

import studentsLog.pojos.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentDB {
    public static Map<Integer,Student>  studentMap=new HashMap<>();

    static{
        studentMap.put(studentMap.size(),new Student(String.valueOf(studentMap.size()+1),"Prateek",75,95,93));
        studentMap.put(studentMap.size(),new Student(String.valueOf(studentMap.size()+1),"Prathik",91,69,69));
        studentMap.put(studentMap.size(),new Student(String.valueOf(studentMap.size()+1),"Shreays",75,92,86));
        studentMap.put(studentMap.size(),new Student(String.valueOf(studentMap.size()+1),"Pravin",31,54,78));
        studentMap.put(studentMap.size(),new Student(String.valueOf(studentMap.size()+1),"Sachin",65,68,78));
        studentMap.put(studentMap.size(),new Student(String.valueOf(studentMap.size()+1),"Shamanth",71,95,65));



    }

    public static Map<Integer, Student> getStudentMap() {
        return studentMap;
    }

    public static void setStudentMap(Map<Integer, Student> studentMap) {
        StudentDB.studentMap = studentMap;
    }
}
