public class SchoolIdentifier {
     // This is user's school identifier
    private String programStudy;
    private String faculty;
    private int enrollmentYear;
    
     public void setProgramStudy(String programStudy) {
            this.programStudy = programStudy;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public void setEnrollmentYear(int enrollmentYear) {
            this.enrollmentYear = enrollmentYear;
        }

        public int getEnrollmentYear() {
            return enrollmentYear;
        }
}
