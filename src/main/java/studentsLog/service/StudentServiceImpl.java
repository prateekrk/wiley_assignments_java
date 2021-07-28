package studentsLog.service;

import studentsLog.persistence.StudentDao;
import studentsLog.persistence.StudentDaoImpl;
import studentsLog.pojos.Student;

import java.util.Collection;

public class StudentServiceImpl implements StudentSerivce {

    private StudentDao stdDao=new StudentDaoImpl();

    @Override
    public Collection<Student> getAllStudents() {
        return stdDao.getAllRecods();
    }

    @Override
    public boolean insertStudent(Student student) {
        return stdDao.insertRecord(student);
    }
}
