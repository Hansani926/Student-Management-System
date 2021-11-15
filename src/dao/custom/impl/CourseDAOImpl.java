package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CourseDAO;
import entity.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO course VALUES(?,?,?,?)",course.getCode(),course.getCourseName(),course.getCourseType(),course.getDuration());
    }

    @Override
    public boolean update(Course course) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE code=?",code);

    }

    @Override
    public Course get(String code) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student WHERE code=?",code);
        if (resultSet.next()) {
            return new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
        } else {
            return null;
        }
    }

    @Override
    public List<Course> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Course");
        ArrayList<Course> coursesList = new ArrayList<>();
        while (resultSet.next()) {
            coursesList.add(
                    new Course(
                            resultSet.getString(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4))
            );
        }
        return coursesList;
    }
}
