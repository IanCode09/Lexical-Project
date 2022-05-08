package com.woyo.lexycal.service.course.impl;

import com.woyo.lexycal.DTO.course.CourseCategoryDTO;
import com.woyo.lexycal.DTO.course.CourseDTO;
import com.woyo.lexycal.DTO.instructor.InstructorDTO;
import com.woyo.lexycal.entity.course.CourseCategoryEntity;
import com.woyo.lexycal.entity.course.CourseCategoryListEntity;
import com.woyo.lexycal.entity.course.CourseEntity;
import com.woyo.lexycal.entity.instructor.InstructorEntity;
import com.woyo.lexycal.repository.course.CourseCategoryListRepository;
import com.woyo.lexycal.repository.course.CourseCategoryRepository;
import com.woyo.lexycal.repository.course.CourseRepository;
import com.woyo.lexycal.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseCategoryListRepository courseCategoryListRepository;
    @Autowired
    private CourseCategoryRepository courseCategoryRepository;

    @Override
    public CourseDTO getCourseById(Integer courseId) {
        Optional<CourseEntity> course = courseRepository.findById(courseId);

        if (course.isPresent()) {
            return convertCourseDTO(course.get());
        } else {
            return null;
        }
    }

    @Override
    public List<CourseDTO> getAllCourse(int page, int limit) {
        if (page > 0) page = page - 1;

        Pageable pageable = PageRequest.of(page, limit);
        Page<CourseEntity> courses = courseRepository.findAll(pageable);

        return courses.stream().map(this::convertCourseDTO).collect(Collectors.toList());
    }

    public CourseDTO convertCourseDTO(CourseEntity item) {
       CourseDTO courseDTO = new CourseDTO();
       courseDTO.setCourseId(item.getCourseId());
       courseDTO.setCourseName(item.getCourseName());
       courseDTO.setCourseHeadline(item.getCourseHeadline());
       courseDTO.setPrice(item.getPrice());
       courseDTO.setDescription(item.getDescription());
       courseDTO.setInstructor(convertInstructorDTO(item.getInstructorEntity()));
       courseDTO.setCategories(courseCategoryListRepository.getCourseCategoriesByCourseId(item.getCourseId())
               .stream().map(this::convertCourseCategoryDTO).collect(Collectors.toList()));

       return courseDTO;
    }

    public CourseCategoryDTO convertCourseCategoryDTO(CourseCategoryListEntity item) {
        return new CourseCategoryDTO(item.getCourseCategory().getCategoryId(), item.getCourseCategory().getCategoryName());
    }

    public CourseCategoryDTO convertCourseCategoryDTO(CourseCategoryEntity item) {
        return new CourseCategoryDTO(item.getCategoryId(), item.getCategoryName());
    }

    public InstructorDTO convertInstructorDTO(InstructorEntity item) {
        return new InstructorDTO(
                item.getInstructorId(), item.getInstructorName(),
                item.getInstructorHeadline(), item.getPhotoProfile(), item.getAbout()
        );
    }
}
