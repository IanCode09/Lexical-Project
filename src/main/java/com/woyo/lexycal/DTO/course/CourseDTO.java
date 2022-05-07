package com.woyo.lexycal.DTO.course;

import com.woyo.lexycal.DTO.instructor.InstructorDTO;

import java.util.List;

public class CourseDTO {
    private int courseId;
    private String courseName;
    private String courseHeadline;
    private List<CourseCategoryDTO> categories;
    private int price;
    private String description;
    private InstructorDTO instructor;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, String courseName, String courseHeadline, List<CourseCategoryDTO> categories, int price, String description, InstructorDTO instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseHeadline = courseHeadline;
        this.categories = categories;
        this.price = price;
        this.description = description;
        this.instructor = instructor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseHeadline() {
        return courseHeadline;
    }

    public void setCourseHeadline(String courseHeadline) {
        this.courseHeadline = courseHeadline;
    }

    public List<CourseCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CourseCategoryDTO> categories) {
        this.categories = categories;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InstructorDTO getInstructor() {
        return instructor;
    }

    public void setInstructor(InstructorDTO instructor) {
        this.instructor = instructor;
    }
}
