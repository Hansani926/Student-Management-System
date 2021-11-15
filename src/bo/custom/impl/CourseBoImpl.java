package bo.custom.impl;

import bo.custom.CourseBo;
import dao.DaoFactory;
import dao.custom.CourseDAO;
import dao.custom.StudentDAO;
import dto.CourseDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseBoImpl implements CourseBo {
    CourseDAO courseDAO=DaoFactory.getInstance().getDao(DaoFactory.DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return courseDAO.save(new Course(dto.getCode(),dto.getCourseName(), dto.getCourseType(), dto.getDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO dto) throws Exception {
        return courseDAO.update(new Course(dto.getCode(),dto.getCourseName(),dto.getCourseType(),dto.getDuration()));
    }

    @Override
    public boolean deleteCourse(String code) throws Exception {
        return false;
    }

    @Override
    public CourseDTO getCourse(String code) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        ArrayList<CourseDTO> arrayList = new ArrayList<>();
        List<Course> all = courseDAO.getAll();
        for (Course course : all) {
            arrayList.add(new CourseDTO(course.getCode(),course.getCourseName(),course.getCourseType(),course.getDuration()));
        }
        return arrayList;
    }

    @Override
    public String getcode() throws Exception {
        return null;
    }
}
