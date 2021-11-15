package bo.custom;

import dto.CourseDTO;


import java.util.ArrayList;

public interface CourseBo {
    public boolean saveCourse(CourseDTO dto)throws Exception;
    public boolean updateCourse(CourseDTO dto)throws Exception;
    public boolean deleteCourse(String code)throws Exception;
    public CourseDTO getCourse(String code)throws Exception;
    public ArrayList<CourseDTO> getAllCourses()throws Exception;
    public String getcode()throws Exception;


}
