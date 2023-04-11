package com.example.unia.member.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


@Getter
@Setter
public class UserCustom extends User {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private Long userId;

    public UserCustom(String username, String password, Collection authorities, Long userId) {
        super(username, password, authorities);
        this.userId = userId;
    }
}