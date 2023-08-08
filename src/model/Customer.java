package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String username;
    private long bookId;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

    public Customer(long id, String name, String surname, LocalDate birthday, String username, long bookId, LocalDateTime registerDate, LocalDateTime updateDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.username = username;
        this.bookId = bookId;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", username='" + username + '\'' +
                ", bookId=" + bookId +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public String getInfo() {
        return ", name ='" + name + '\'' +
                ", surname ='" + surname + '\'' +
                ", username ='" + username;
    }
}
