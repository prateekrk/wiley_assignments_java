package studentsLog.service;

import studentsLog.pojos.Student;

import java.util.Collection;

public interface StudentSerivce {
    Collection<Student> getAllStudents();
    boolean insertStudent(Student student);
}
