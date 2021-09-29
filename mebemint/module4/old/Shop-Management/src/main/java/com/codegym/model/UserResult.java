package com.codegym.model;

import com.codegym.repository.model.user.UserRole;
import com.codegym.repository.model.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResult {
    @Column(nullable = false,length = 200)
    private String fullName;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @Column(nullable = false, unique = true,length = 255)
    private String email;

    @Column(nullable = false,length = 128)
    private String passwordHash;

    private String address;

    @Column(nullable = false)
    private UserStatus status;

    @Column(nullable = false)
    private UserRole role;

    @Column(nullable = false)
    private Date createdAt;
}
