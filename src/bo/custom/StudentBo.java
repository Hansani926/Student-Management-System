package bo.custom;


import dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBo {
    public boolean saveStudent(StudentDTO dto)throws Exception;
    public boolean updateStudent(StudentDTO dto)throws Exception;
    public boolean deleteStudent(String Id)throws Exception;
    public StudentDTO getStudent(String Id)throws Exception;
    public ArrayList<StudentDTO> getAllStudents()throws Exception;
    public String getId()throws Exception;
}
