package learning.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Person {

    // == fields ==
    @Id
    @GeneratedValue
    //cannot simply call "id" as this will map to part of JSON data - want this created by database
    private int idNumber;
    private String name;
    private String username;
    private String email;

    // == constructors ==
    // protected default constructor for benefit of JPA
    public Person() {
    }

    // == public methods ==
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Person)) return false;

        Person person = (Person) obj;

        return idNumber == person.idNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + idNumber +
                ", name=" + name +
                ", username=" + username +
                ", email=" + username +
                '}' + "\n";

    }


}