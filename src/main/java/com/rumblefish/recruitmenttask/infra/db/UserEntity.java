package com.rumblefish.recruitmenttask.infra.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue()
    private Long id;

    private String name;

    public static UserEntity from(String userName) {
        return new UserEntity(null, userName);
    }
}
