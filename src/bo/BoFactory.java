package bo;

import bo.custom.impl.CourseBoImpl;
import bo.custom.impl.StudentBoImpl;


public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BoFactory()) : (boFactory);

    }

    public enum BOType {
        STUDENT, REGISTRATION, COURSE
    }

    public <T> T getBo(BOType type) {
        switch (type) {
            case STUDENT:

                return (T) new StudentBoImpl();

            case COURSE:
                return (T) new CourseBoImpl();
            default:
                return null;


        }
    }
}


