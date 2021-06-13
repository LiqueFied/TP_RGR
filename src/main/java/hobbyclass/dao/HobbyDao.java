package hobbyclass.dao;

import hobbyclass.model.Hobby;

import java.sql.SQLException;

public interface HobbyDao extends Dao<Hobby>{
    Hobby findHobbyByName(String name) throws SQLException;
}
