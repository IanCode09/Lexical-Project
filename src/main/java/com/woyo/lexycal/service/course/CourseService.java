package com.woyo.lexycal.service.course;

import com.woyo.lexycal.DTO.course.CourseCategoryDTO;
import com.woyo.lexycal.DTO.course.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO getCourseById(Integer courseId);
    List<CourseDTO> getAllCourse(int page, int limit);
}
