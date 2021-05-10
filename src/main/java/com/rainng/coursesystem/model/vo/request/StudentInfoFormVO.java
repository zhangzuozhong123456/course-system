package com.rainng.coursesystem.model.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.util.Date;
//学生学籍信息表单格式类
@Data
public class StudentInfoFormVO {
    private String password;

    @Email(message = "邮箱格式不正确")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Range(min = 0, max = 1)
    private Integer sex;

    private String address;

    private String reward;

    private String publish;
}
