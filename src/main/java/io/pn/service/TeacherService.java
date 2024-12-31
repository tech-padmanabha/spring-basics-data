package io.pn.service;

import io.pn.dto.TeachersDto;

import java.util.List;

public interface TeacherService {
    public List<TeachersDto> allTeachers();
    public TeachersDto findTeacherById(Long id);
    public TeachersDto addNewTeacher(TeachersDto dto);
    public TeachersDto updateTeacher(TeachersDto dto);
    public boolean deleteTeacher(Long id);
}
