package com.ssm.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private Date date;
}
