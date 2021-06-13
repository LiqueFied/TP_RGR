package hobbyclass.dao.impl;

import hobbyclass.dao.Dao;
import hobbyclass.hiber.SessionUtil;
import hobbyclass.model.Hobbyclass;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class HobbyclassDaoImpl extends SessionUtil implements Dao<Hobbyclass> {

    @Override
    public Hobbyclass add(Hobbyclass hobbyclass) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(hobbyclass);
        closeTransactionSesstion();
        return hobbyclass;
    }

    @Override
    public List<Hobbyclass> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Hobbyclass> hobbyclasss = session.createQuery("FROM Hobbyclass").list();
        closeTransactionSesstion();
        return hobbyclasss;
    }

    @Override
    public Hobbyclass findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Hobbyclass hobbyclass = session.get(Hobbyclass.class, id);
        closeTransactionSesstion();
        return hobbyclass;
    }

    @Override
    public Hobbyclass update(Hobbyclass data) throws SQLException {
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
        Hobbyclass hobbyclass = session.get(Hobbyclass.class, id);
        session.remove(hobbyclass);
        closeTransactionSesstion();
    }
}
