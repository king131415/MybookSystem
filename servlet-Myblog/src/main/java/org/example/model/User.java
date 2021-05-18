package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class User {  //编写实体类
 private Integer id;
 private String username;
 private String password;
 private String nickname;
 private Boolean sex;
 private Date birthday;
 private String head;

}
