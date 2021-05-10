package com.rainng.coursesystem.manager.student;

import com.rainng.coursesystem.dao.StudentDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.StudentEntity;
import com.rainng.coursesystem.model.vo.response.StudentInfoVO;
import org.springframework.stereotype.Component;
//学生信息管理
@Component
public class InfoManager extends BaseManager {
    private final StudentDAO studentDAO;

    public InfoManager(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentInfoVO getStudentInfoByStudentId(Integer studentId) {
        return studentDAO.getStudentInfoById(studentId);
    }

    public StudentEntity getStudentById(Integer studentId) {
        return studentDAO.get(studentId);
    }
    //调用studentDao对象，查询数据库，返回一个StudentInfoVo对象
    public int updateStudent(StudentEntity entity) {
        return studentDAO.update(entity);
    }
}
