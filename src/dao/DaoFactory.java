package dao;

import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.QueryDaoImpl;
import dao.custom.impl.StudentDAOImpl;
import entity.Student;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DaoFactory()) : (daoFactory);
    }


    public enum DAOType {
      STUDEND,REGISTRATION,COURSE,QUERY
    }



    public <T> T getDao(DAOType type) {
        switch (type) {
            case STUDEND:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case QUERY:
                return (T) new QueryDaoImpl();
            default:
                return null;
        }
    }

}
