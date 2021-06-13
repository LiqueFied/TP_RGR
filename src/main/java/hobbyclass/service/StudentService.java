package hobbyclass.service;

import hobbyclass.dao.Dao;
import hobbyclass.dao.impl.StudentDaoImpl;
import hobbyclass.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private Dao<Student> studentDao = new StudentDaoImpl();

    public List<Student> printAllStudents() throws SQLException {
        return studentDao.findAll();
    }

    public void saveStudent(Student student) throws SQLException {
        studentDao.add(student);
    }

    public void deleteStudent(Long id) throws SQLException {
        studentDao.deleteById(id);
    }

    public void updateStudent(Student newStudent) throws SQLException {
        studentDao.update(newStudent);
    }

    public Student getStudentById(Long id) throws SQLException {
        return studentDao.findById(id);
    }
}