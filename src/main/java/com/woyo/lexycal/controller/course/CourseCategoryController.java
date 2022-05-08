package com.woyo.lexycal.controller.course;

import com.woyo.lexycal.DTO.course.CourseCategoryDTO;
import com.woyo.lexycal.response.DataResponse;
import com.woyo.lexycal.response.HandlerResponse;
import com.woyo.lexycal.service.course.CourseCategoryService;
import com.woyo.lexycal.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/course", produces = {"application/json"})
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("/category")
    public void getAllCourseCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CourseCategoryDTO> courseCategories = courseCategoryService.getAllCourseCategory();

        DataResponse<List<CourseCategoryDTO>> data = new DataResponse<>();
        data.setData(courseCategories);
        HandlerResponse.responseSuccessWithData(response, data);
    }
}
