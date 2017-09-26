package data.enums.ContactFormPage;

public enum UserData {

    USER_DATA1("Alexandr", "Efremov");

    private String firstName;
    private String lastName;

    UserData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
