package studentsLog.persistence;

import studentsLog.pojos.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllRecods();
    boolean insertRecord(Student student);
}
