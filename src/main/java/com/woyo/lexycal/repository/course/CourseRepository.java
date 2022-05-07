package com.woyo.lexycal.repository.course;

import com.woyo.lexycal.entity.course.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
