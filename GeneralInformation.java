public class GeneralInformation {
    
    // This is user's general information
        private String gender;
        private String firstName;
        private String lastName;
        private String studentIdentifierNumber;

        public GeneralInformation(String firstName, String lastName, String gender, String studentIdentifierNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentIdentifierNumber = studentIdentifierNumber;
        }
        
        //Setter
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setStudentIdentifierNumber(String studentIdentifierNumber) {
            this.studentIdentifierNumber = studentIdentifierNumber;
        }
        // getter methods

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getGender() {
            return gender;
        }

        public String getStudentIdentifierNumber() {
            return studentIdentifierNumber;
        }
    }

