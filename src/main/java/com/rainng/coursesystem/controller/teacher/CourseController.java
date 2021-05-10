package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Admin;
import com.rainng.coursesystem.config.themis.annotation.Teacher;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.entity.CourseEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.CourseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Teacher
@Admin(Admin.COURSE_MANAGE)
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
public class CourseController extends BaseController {
    private final CourseService service;
    private final com.rainng.coursesystem.service.admin.CourseService serviceAdmin;
    public CourseController(CourseService service,com.rainng.coursesystem.service.admin.CourseService serviceAdmin) {
        this.service = service;
        this.serviceAdmin=serviceAdmin;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
//  新添加的创建和提交功能
    @PostMapping
    public ResultVO create(@RequestBody @Validated CourseEntity entity) {
        return serviceAdmin.create(entity);
    }
    @PutMapping
    public ResultVO update(@RequestBody @Validated CourseEntity entity) {
        return serviceAdmin.update(entity);
    }
}
