package learning.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    // == fields ==
    private int id;
    private String name;
    private String username;
    private String email;

    // == constructor ==
    public Person(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    // == public methods ==
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
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Person)) return false;

        Person person = (Person) obj;

        return id == person.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", username=" + username +
                ", email=" + username +
                '}' + "\n";

    }
}
