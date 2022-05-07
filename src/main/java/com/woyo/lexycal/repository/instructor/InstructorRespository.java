package com.woyo.lexycal.repository.instructor;

import com.woyo.lexycal.entity.instructor.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRespository extends JpaRepository<InstructorEntity, Integer> {
}
