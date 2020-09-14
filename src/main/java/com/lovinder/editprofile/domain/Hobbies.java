package com.lovinder.editprofile.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Hobbies implements Serializable {
    private String id;
    private String name;
}
