package com.rainng.coursesystem.service.student;

import com.rainng.coursesystem.manager.student.InfoManager;
import com.rainng.coursesystem.model.entity.StudentEntity;
import com.rainng.coursesystem.model.vo.request.StudentInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InfoService extends BaseService {
    private final UserService userService;

    private final InfoManager manager;

    public InfoService(UserService userService, InfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }
    //根据id获取学生学籍信息
    public ResultVO get() {
        return result(manager.getStudentInfoByStudentId(getUserId()));
    }
    //获取表单信息，更新学生学籍信息
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO studentInfoForm) {
        StudentEntity student = manager.getStudentById(getUserId());
    //获取表单信息
        String password = studentInfoForm.getPassword();
        String address=studentInfoForm.getAddress();
        if (password == null || password.equals("")) {
            password = student.getPassword();
        } else {
            password = userService.computePasswordHash(password);
        }
        //对象属性赋值
        BeanUtils.copyProperties(studentInfoForm, student);
        //可更新表单项 密码 地址
        student.setPassword(password);
        student.setAddress(address);
        manager.updateStudent(student);

        return result("更新成功");
    }
}
