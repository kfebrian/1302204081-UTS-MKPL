package org.telkom.university.code.smell;

import org.apache.commons.lang3.StringUtils;

import java.time.Year;
import java.util.UUID;
import java.util.regex.Pattern;

// Signature: DHF
public class User {
    // This is user's ID index
    private final String userID;
    private SchoolIdentifier schoolIdentifier;
    private SchoolAccount schoolAccount;
    private GeneralInformation generalInformation;

    // This is class's constructor
    public User() {
        // This is initiate the unique ID
        this.userID = UUID.randomUUID().toString();
    }
    private void validateProgramStudy(String programStudy) throws Exception {
    if (programStudy == null || programStudy.trim().isEmpty()) {
        throw new Exception("Program study should not be null, empty, or blank.");
    }
    }

    private void validateFaculty(String faculty) throws Exception {
        if (faculty == null || faculty.trim().isEmpty()) {
            throw new Exception("Faculty should not be null, empty, or blank.");
        }
    }

    private void validateEnrollmentYear(int enrollmentYear) throws Exception {
        if (enrollmentYear <= 0 || enrollmentYear >= Integer.MAX_VALUE) {
            throw new Exception("Enrollment year should be a positive integer.");
        }
    }
    // This method is setting up the user's school identifier
    public void setSchoolIdentifier(SchoolIdentifier schoolIdentifier) throws Exception {
        String programStudy = schoolIdentifier.getProgramStudy();
        String faculty = schoolIdentifier.getFaculty();
        int enrollmentYear = schoolIdentifier.getEnrollmentYear();

        // Check if the inputs are empty or blank
        validateProgramStudy(programStudy);
        validateFaculty(faculty);
        validateEnrollmentYear(enrollmentYear);

    }

    private void validateEmail(String email) throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new Exception("Email should not be null, empty, or blank.");
        }
    }

    private void validatePassword(String password) throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Password should not be null, empty, or blank.");
        }
    }

    private void validateUserName(String userName) throws Exception {
        if (userName == null || userName.trim().isEmpty()) {
            throw new Exception("User name should not be null, empty, or blank.");
        }
    }

    // This method is setting up the user's school account
    public void setSchoolAccount(SchoolAccount schoolAccount) throws Exception {
        String email = schoolAccount.getEmail();
        String password = schoolAccount.getPassword();
        String userName = schoolAccount.getUserName();

        // Check if the inputs are empty or blank
        validateEmail(email);
        validatePassword(password);
        validateUserName(userName);
    }

    private void validateFirstName(String firstName) throws Exception {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new Exception("First name should not be null, empty, or blank.");
        }
    }

    private void validateLastName(String lastName) throws Exception {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new Exception("Last name should not be null, empty, or blank.");
        }
    }

    private void validateGender(String gender) throws Exception {
        if (gender == null || gender.trim().isEmpty()) {
            throw new Exception("Gender should not be null, empty, or blank.");
        }
    }

    private void validateStudentIdentifierNumber(String studentIdentifierNumber) throws Exception {
        if (studentIdentifierNumber == null || studentIdentifierNumber.trim().isEmpty()) {
            throw new Exception("Student identifier number should not be null, empty, or blank.");
        }
    }

    // This method is setting up the user's general information
    public void setGeneralInformation(GeneralInformation generalInformation ) throws Exception {
       String firstName = generalInformation.getFirstName();
        String lastName = generalInformation.getLastName();
        String gender = generalInformation.getGender();
        String studentIdentifierNumber = generalInformation.getStudentIdentifierNumber();

        validateFirstName(firstName);
        validateLastName(lastName);
        validateGender(gender);
        validateStudentIdentifierNumber(studentIdentifierNumber);

    }

    // This method is used to calculate the year of the user based on the enrollment year
    public int calculateEnrollmentYear() {
        // This is the user's age calculation
        int currentYears = Year.now().getValue();
        return currentYears - schoolIdentifier.getEnrollmentYear();
    }

    // This method is used to validate user's email address
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    // This method is used to check if the user's password is strong enough
    public boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        Pattern pat = Pattern.compile(passwordRegex);
        if (password == null)
            return false;
        return pat.matcher(password).matches();
    }

    // This method is used to update user's profile
    public void updateProfile(String firstName, String lastName, String gender, String studentIdentifierNumber,
                              String programStudy, String faculty, int enrollmentYear, String email,
                              String password, String userName) throws Exception {

        if(studentIdentifierNumber.length() != 10 || !StringUtils.isNumeric(studentIdentifierNumber)){
            throw new Exception("Input is not valid.");
        }

        boolean isValidEmail = isValidEmail(email);
        boolean isStrongPassword = isStrongPassword(password);

        this.setSchoolIdentifier(programStudy, faculty, enrollmentYear);
        this.setSchoolAccount(email, password, userName);
        this.setGeneralInformation(firstName, lastName, gender, studentIdentifierNumber);
        int calculateYear = this.calculateEnrollmentYear();

        String emailStatus = "", passwordStatus = "";

        if(isValidEmail){
            emailStatus = "VALID";
        }else{
            emailStatus = "INVALID";
        }
        if(isStrongPassword){
            passwordStatus = "STRONG";
        }else{
            passwordStatus = "WEAK";
        }

        if(emailStatus.equals("VALID") && passwordStatus.equals("STRONG")){
            System.out.println("UPDATE COMPLETE!");
        }else if(emailStatus.equals("VALID") && passwordStatus.equals("WEAK")){
            System.out.println("PLEASE USE BETTER PASSWORD");
        }else if(emailStatus.equals("INVALID") && passwordStatus.equals("STRONG")){
            System.out.println("PLEASE CHECK YOUR EMAIL");
        }else if(emailStatus.equals("INVALID") && passwordStatus.equals("WEAK")){
            System.out.println("THIS IS JOKE RIGHT? PLEASE USE VALID EMAIL AND STRONG PASSWORD");
        }
    }
}