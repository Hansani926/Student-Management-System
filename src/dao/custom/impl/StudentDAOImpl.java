package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDAO;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO Student VALUES(?,?,?,?,?,?)",student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String Id) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE Id=?",Id);
    }

    @Override
    public Student get(String Id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student WHERE Id=?",Id);
        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6));
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM student");
        ArrayList<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            studentList.add(

                          new Student(
                            resultSet.getString(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6))
            );
        }
        return studentList;
    }
    }

