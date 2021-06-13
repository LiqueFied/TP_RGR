package hobbyclass.dao.impl;

import hobbyclass.dao.Dao;
import hobbyclass.hiber.SessionUtil;
import hobbyclass.model.Student;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl extends SessionUtil implements Dao<Student> {

    @Override
    public Student add(Student student) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(student);
        closeTransactionSesstion();
        return student;
    }

    @Override
    public List<Student> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Student> students = session.createQuery("FROM Student").list();
        closeTransactionSesstion();
        return students;
    }

    @Override
    public Student findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Student student = session.get(Student.class, id);
        closeTransactionSesstion();
        return student;
    }

    @Override
    public Student update(Student data) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(data);
        closeTransactionSesstion();
        return data;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Student student = session.get(Student.class, id);
        session.remove(student);
        closeTransactionSesstion();
    }
}
