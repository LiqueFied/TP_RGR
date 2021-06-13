package hobbyclass.dao.impl;

import hobbyclass.dao.HobbyDao;
import hobbyclass.hiber.SessionUtil;
import hobbyclass.model.Hobby;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class HobbyDaoImpl extends SessionUtil implements HobbyDao {

    @Override
    public Hobby add(Hobby hobby) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(hobby);
        closeTransactionSesstion();
        return hobby;
    }

    @Override
    public List<Hobby> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Hobby> hobbies = session.createQuery("FROM Hobby").list();
        closeTransactionSesstion();
        return hobbies;
    }

    @Override
    public Hobby findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Hobby hobby = session.get(Hobby.class, id);
        closeTransactionSesstion();
        return hobby;
    }

    @Override
    public Hobby update(Hobby data) throws SQLException {
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
        Hobby hobby = session.get(Hobby.class, id);
        session.remove(hobby);
        closeTransactionSesstion();
    }

    @Override
    public Hobby findHobbyByName(String name) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Hobby> hobbies = session.createQuery("FROM Hobby").list();
        Hobby searchingHobby = new Hobby();
        for (Hobby hobby : hobbies) {
            if (hobby.getName().equals(name)) {
                return searchingHobby = hobby;
            }
        }
        closeTransactionSesstion();
        return searchingHobby;
    }
}
