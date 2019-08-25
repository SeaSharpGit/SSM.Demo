package com.ssm.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name;
    private Date date;
}
