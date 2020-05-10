//package com.tanya.militarybase.model.persons;
//
//import lombok.*;
//
////@Getter
////@Setter
////@Builder
//@NoArgsConstructor
////@AllArgsConstructor
//public class Person {
//    private String firstName;
//    private String lastName;
//    private String thirdName;
//
//    public Person(String firstName, String lastName, String thirdName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.thirdName = thirdName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//    public String getLastName() {
//        return lastName;
//    }
//    public String getThirdName() {
//        return thirdName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    public void setThirdName(String thirdName) {
//        this.thirdName = thirdName;
//    }
//}

package com.tanya.militarybase.model.persons;

import com.tanya.militarybase.model.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private User user;

    private String firstName = "";
    private String lastName = "";
    private String thirdName = "";
    private boolean active = false;

    public Person(String firstName, String lastName, String thirdName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
    }

    public String getFirstName() {
        return null != firstName ? firstName : "";
    }
    public String getLastName() {
        return null != lastName ? lastName : "";
    }
    public String getThirdName() { return null != thirdName ? thirdName : ""; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        if (null != firstName && !firstName.isEmpty()) {
            active = true;
        }
    }

    public String getPosition() {
        return "";
    }
}
