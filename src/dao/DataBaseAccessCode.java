package dao;

import dto.CourseDTO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataBaseAccessCode {
    public boolean saveStudent(StudentDTO dto) throws ClassNotFoundException, SQLException {
        return false;
    }

    public StudentDTO getStudent(String id) throws ClassNotFoundException, SQLException {
        return null;

    }

    public ArrayList<StudentDTO> getAllStudents() throws ClassNotFoundException, SQLException {
        return null;
    }
    public boolean saveCourse(CourseDTO dto) throws ClassNotFoundException, SQLException {
        return false;
    }

    public CourseDTO getCourse(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<CourseDTO> getAllCourses() throws ClassNotFoundException, SQLException {
        return null;
    }
}
