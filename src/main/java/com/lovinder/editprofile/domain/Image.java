package com.lovinder.editprofile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String url;

    enum Level {
        AVATAR(0),
        BACKGROUND(1);
        private final int levelCode;
        private Level(int levelCode) {
            this.levelCode = levelCode;
        }
    }
}

