package oop.app.blueprint;

public class Person {
    private String name;

    private int age;

    private double weight;

    private double height;

    private String contactNumber;

    private boolean isMale;

    private String birthDate;

    private String citizenship;

    private String address;

    private String relationshipStatus;

    private String eyeColor;

    private String religion;

    private String ethnicity;

    private String email;

    private String birthPlace;

    private String occupation;

    private boolean hasSiblings;


    // Custom functions
    public void introducePerson() {
        System.out.println("My name is " + this.name + " and I am " + this.age + " years old.");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getAddress() {
        return address;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getReligion() {
        return religion;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean hasSiblings() {
        return hasSiblings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setHasSiblings(boolean hasSiblings) {
        this.hasSiblings = hasSiblings;
    }
}
