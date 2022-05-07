package com.woyo.lexycal.repository.course;

import com.woyo.lexycal.entity.course.CourseCategoryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseCategoryListRepository extends JpaRepository<CourseCategoryListEntity, Integer> {

    @Query("SELECT cc FROM CourseCategoryListEntity cc " +
            "WHERE cc.courseEntity.courseId = :courseId")
    List<CourseCategoryListEntity> getCourseCategoriesByCourseId(int courseId);
}
