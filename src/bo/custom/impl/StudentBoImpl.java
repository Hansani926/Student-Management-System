package bo.custom.impl;

import bo.custom.StudentBo;
import dao.DaoFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo  {
    StudentDAO studentDAO= DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDEND);
    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return studentDAO.save(new Student(dto.getId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return studentDAO.update(new Student(dto.getId(),dto.getStudentName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));

    }

    @Override
    public boolean deleteStudent(String Id) throws Exception {
        return false;
    }

    @Override
    public StudentDTO getStudent(String Id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<StudentDTO> arrayList = new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            arrayList.add(new StudentDTO(student.getId(),student.getStudentName(),student.getAddress(),student.getContact(),student.getDob(),student.getGender()));
        }
        return arrayList;
    }

    @Override
    public String getId() throws Exception {
        return null;
    }
}
