package hobbyclass.service;

import hobbyclass.dao.HobbyDao;
import hobbyclass.dao.impl.HobbyDaoImpl;
import hobbyclass.model.Hobby;

import java.sql.SQLException;
import java.util.List;

public class HobbyService {

    private HobbyDao hobbyDao = new HobbyDaoImpl();

    public List<Hobby> printAllHobbys() throws SQLException {
        return hobbyDao.findAll();
    }

    public void saveHobby(Hobby hobby) throws SQLException {
        hobbyDao.add(hobby);
    }

    public void deleteHobby(Long id) throws SQLException {
        hobbyDao.deleteById(id);
    }

    public void updateHobby(Hobby newHobby) throws SQLException {
        hobbyDao.update(newHobby);
    }

    public Hobby getHobbyById(Long id) throws SQLException {
        return hobbyDao.findById(id);
    }

    public Hobby getHobbyByName(String name) throws SQLException {
        return hobbyDao.findHobbyByName(name);
    }
}
