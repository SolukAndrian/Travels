package ua.lviv.travels.dto;

/**
 * Created by Apple on 17.04.2017.
 */
public class CustomerDto {
    private String surname;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private String login;
    private String password;

    public CustomerDto() {
    }

    public CustomerDto(String surname, String name, Integer age, String phone, String email, String login, String password) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
