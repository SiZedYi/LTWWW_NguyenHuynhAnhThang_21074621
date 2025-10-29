package fit.iuh.thang.bai01;

import java.util.Date;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private List<String> hobbies;
    private List<Qualification> qualifications;
    private String courseApplied;

    public Student() {
    }

    public Student(String firstName, String lastName, Date birthday, String email, String mobileNumber,
                   String gender, String address, String city, String pinCode, String state, String country,
                   List<String> hobbies, List<Qualification> qualifications, String courseApplied) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.qualifications = qualifications;
        this.courseApplied = courseApplied;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public String getCourseApplied() {
        return courseApplied;
    }

    public void setCourseApplied(String courseApplied) {
        this.courseApplied = courseApplied;
    }

    public static class Qualification {
        private String examination;
        private String board;
        private String percentage;
        private String yearOfPassing;

        public Qualification() {
        }

        public Qualification(String examination, String board, String percentage, String yearOfPassing) {
            this.examination = examination;
            this.board = board;
            this.percentage = percentage;
            this.yearOfPassing = yearOfPassing;
        }

        public String getExamination() {
            return examination;
        }

        public void setExamination(String examination) {
            this.examination = examination;
        }

        public String getBoard() {
            return board;
        }

        public void setBoard(String board) {
            this.board = board;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public String getYearOfPassing() {
            return yearOfPassing;
        }

        public void setYearOfPassing(String yearOfPassing) {
            this.yearOfPassing = yearOfPassing;
        }
    }
}

