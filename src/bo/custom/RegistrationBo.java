package bo.custom;

import dto.RegistrationDTO;
import dto.StudentDTO;

public interface RegistrationBo {
    public boolean saveStudent(RegistrationDTO dto)throws Exception;
}
