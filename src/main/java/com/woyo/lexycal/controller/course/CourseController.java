package com.woyo.lexycal.controller.course;

import com.woyo.lexycal.DTO.course.CourseCategoryDTO;
import com.woyo.lexycal.DTO.course.CourseDTO;
import com.woyo.lexycal.response.DataResponse;
import com.woyo.lexycal.response.HandlerResponse;
import com.woyo.lexycal.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/course", produces = {"application/json"})
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public void getCourseById(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) throws IOException {
        CourseDTO courseDTO = courseService.getCourseById(id);

        if (courseDTO != null) {
            DataResponse<CourseDTO> data = new DataResponse<>();
            data.setData(courseDTO);
            HandlerResponse.responseSuccessWithData(response, data);
        } else {
            HandlerResponse.responseNotFound(response, "404", "Course not found");
        }
    }

    @GetMapping("")
    public void getAllCourse(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "limit", defaultValue = "25") int limit) throws IOException {

        List<CourseDTO> courseDTO = courseService.getAllCourse(page, limit);

        DataResponse<List<CourseDTO>> data = new DataResponse<>();
        data.setData(courseDTO);
        HandlerResponse.responseSuccessWithData(response, data);
    }
}
