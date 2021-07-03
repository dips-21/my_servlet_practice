package dips;

public class Person {
int id;
    String name;
    int age;
    String gender;
    String password;
    int contact;
    String address;
    String hobby;

    public Person(int id,String name, int age, String gender, String password,int contact, String address, String hobby) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.password=password;
        this.contact = contact;
        this.address = address;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password =password ;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }



}