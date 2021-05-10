package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.StudentEntity;
import com.rainng.coursesystem.model.vo.response.StudentInfoVO;
import com.rainng.coursesystem.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends BaseMapper<StudentEntity> {
    //根据id查找学生
    Integer getDepartmentIdById(Integer studentId);
    //根据id查找年级
    Integer getGradeById(Integer studentId);
    //学生个数计算
    Integer count(String majorName, String className, String name);
    //学生的模糊查找
    IPage<StudentItemVO> getPage(IPage<StudentItemVO> page, String majorName, String className, String name);
    //根据id查找学生信息
    StudentInfoVO getStudentInfoById(Integer studentId);
}
