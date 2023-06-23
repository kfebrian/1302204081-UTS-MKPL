public class SchoolIdentifier {
     // This is user's school identifier
    private String programStudy;
    private String faculty;
    private int enrollmentYear;

    public SchoolIdentifier(String programStudy, String faculty, int enrollmentYear) {
        this.programStudy = programStudy;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
    }

        // Setter

     public void setProgramStudy(String programStudy) {
            this.programStudy = programStudy;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public void setEnrollmentYear(int enrollmentYear) {
            this.enrollmentYear = enrollmentYear;
        }

        // getter methods

    public String getProgramStudy() {
        return programStudy;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }
        
}
