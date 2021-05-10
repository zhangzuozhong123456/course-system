package com.rainng.coursesystem.model.vo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
//学生学籍信息封装，数据库查询后，返回该类对象
@Data
public class StudentInfoVO {
    private String number;
    private String name;
    private String departmentName;
    private String majorName;
    private String className;
    private String reward;
    private String publish;
    private String address;
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
}
