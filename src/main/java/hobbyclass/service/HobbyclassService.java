package hobbyclass.service;

import hobbyclass.dao.Dao;
import hobbyclass.dao.impl.HobbyclassDaoImpl;
import hobbyclass.model.Hobbyclass;

import java.sql.SQLException;
import java.util.List;

public class HobbyclassService {

    private Dao<Hobbyclass> hobbyclassDao = new HobbyclassDaoImpl();

    public List<Hobbyclass> printAllHobbyclasses() throws SQLException {
        return hobbyclassDao.findAll();
    }

    public void saveHobbyclass(Hobbyclass hobbyclass) throws SQLException {
        hobbyclassDao.add(hobbyclass);
    }

    public void deleteHobbyclass(Long id) throws SQLException {
        hobbyclassDao.deleteById(id);
    }

    public void updateHobbyclass(Hobbyclass newHobbyclass) throws SQLException {
        hobbyclassDao.update(newHobbyclass);
    }

    public Hobbyclass getHobbyclassById(Long id) throws SQLException {
        return hobbyclassDao.findById(id);
    }
}
