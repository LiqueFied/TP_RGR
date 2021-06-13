package hobbyclass.dao.impl;

import hobbyclass.dao.Dao;
import hobbyclass.hiber.SessionUtil;
import hobbyclass.model.Teacher;
import org.hibernate.Session;


import java.sql.SQLException;
import java.util.List;

public class TeacherDaoImpl extends SessionUtil implements Dao<Teacher> {

    @Override
    public Teacher add(Teacher teacher) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(teacher);
        closeTransactionSesstion();
        return teacher;
    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Teacher> teachers = session.createQuery("FROM Teacher").list();
        closeTransactionSesstion();
        return teachers;
    }

    @Override
    public Teacher findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Teacher teacher = session.get(Teacher.class, id);
        closeTransactionSesstion();
        return teacher;
    }

    @Override
    public Teacher update(Teacher data) throws SQLException {
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
        Teacher teacher = session.get(Teacher.class, id);
        session.remove(teacher);
        closeTransactionSesstion();
    }
}
