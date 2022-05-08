package com.woyo.lexycal.service.course.impl;

import com.woyo.lexycal.DTO.course.CourseCategoryDTO;
import com.woyo.lexycal.entity.course.CourseCategoryEntity;
import com.woyo.lexycal.repository.course.CourseCategoryRepository;
import com.woyo.lexycal.service.course.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private CourseCategoryRepository courseCategoryRepository;

    @Override
    public List<CourseCategoryDTO> getAllCourseCategory() {
        return courseCategoryRepository.findAll().stream().map(this::convertCourseCategoryDTO).collect(Collectors.toList());
    }

    public CourseCategoryDTO convertCourseCategoryDTO(CourseCategoryEntity item) {
        return new CourseCategoryDTO(item.getCategoryId(), item.getCategoryName());
    }
}
