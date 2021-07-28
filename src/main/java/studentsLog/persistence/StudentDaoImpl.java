package studentsLog.persistence;

import studentsLog.db.StudentDB;
import studentsLog.pojos.Student;

import java.util.Collection;

public class StudentDaoImpl implements StudentDao{

    @Override
    public Collection<Student> getAllRecods() {
        return StudentDB.getStudentMap().values();
    }

    @Override
    public boolean insertRecord(Student student) {
        StudentDB.getStudentMap().put(StudentDB.studentMap.size(),student);
        return true;
    }
}
