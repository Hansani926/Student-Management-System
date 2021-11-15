package entity;

public class Student implements SuperEntity {
   private String Id;
   private String StudentName;
  private   String Address;
   private int Contact;
   private String dob;
   private String Gender;

    public Student() {
    }

    public Student(String id, String studentName, String address, int contact, String dob, String gender) {
      this.Id = id;
       this.StudentName = studentName;
        this.Address = address;
        this.Contact = contact;
        this.dob = dob;
       this.Gender = gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "Id='" + Id + '\'' +
                ", StudentName='" + StudentName + '\'' +
                ",Address ='" + Address+ '\'' +
                ",Contact=" + Contact +'\''+
                ",dob="+dob+'\''+
                ",Gender="+Gender+
                '}';
    }
}
