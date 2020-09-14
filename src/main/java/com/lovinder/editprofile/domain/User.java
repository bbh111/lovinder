package com.lovinder.editprofile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Data
@Component
public class User implements Serializable {
    private String id;
    private String email;
    private String phone_number;
    private String nick_name;
    private LocalDate dob;
    private String promotion_code;
    private String introduction;
    private List<Hobbies> hobbies;
    private String cookies;
    private Address address;
    private List<Image> images;
    private Gender gender;

    public User(String id, String nick_name, String introduction, String phone_number, String promotion_code, String email, LocalDate date, List<Hobbies> hobbies) {
        this.id = id;
        this.email = email;
        this.phone_number = phone_number;
        this.nick_name = nick_name;
        this.promotion_code = promotion_code;
        this.introduction = introduction;
        this.dob = date;
        this.hobbies = hobbies;
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob);
    }

    public User() {
    }
}
