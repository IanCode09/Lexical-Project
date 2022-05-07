package com.woyo.lexycal.DTO.instructor;

public class InstructorDTO {
    private int instructorId;
    private String instructorName;
    private String instructorHeadline;
    private String photoProfile;
    private String about;

    public InstructorDTO() {
    }

    public InstructorDTO(int instructorId, String instructorName, String instructorHeadline, String photoProfile, String about) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorHeadline = instructorHeadline;
        this.photoProfile = photoProfile;
        this.about = about;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorHeadline() {
        return instructorHeadline;
    }

    public void setInstructorHeadline(String instructorHeadline) {
        this.instructorHeadline = instructorHeadline;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
