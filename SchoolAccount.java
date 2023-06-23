public class SchoolAccount {

       // This is user's account
        private String email;
        private String password;
        private String userName;

        public SchoolAccount(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    // Setter
        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
        
    // getter methods

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
