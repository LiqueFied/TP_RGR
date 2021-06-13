package hobbyclass.service;

import hobbyclass.dao.Dao;
import hobbyclass.dao.impl.TeacherDaoImpl;
import hobbyclass.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public class TeacherService {

    private Dao<Teacher> teacherDao = new TeacherDaoImpl();

    public List<Teacher> printAllTeachers() throws SQLException {
        return teacherDao.findAll();
    }

    public void saveTeacher(Teacher teacher) throws SQLException {
        teacherDao.add(teacher);
    }

    public void deleteTeacher(Long id) throws SQLException {
        teacherDao.deleteById(id);
    }

    public void updateTeacher(Teacher newTeacher) throws SQLException {
        teacherDao.update(newTeacher);
    }

    public Teacher getTeacherById(Long id) throws SQLException {
        return teacherDao.findById(id);
    }
}
