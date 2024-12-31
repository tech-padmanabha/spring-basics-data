package io.pn.service.impls;

import io.pn.dto.TeachersDto;
import io.pn.entity.Courses;
import io.pn.entity.Teachers;
import io.pn.exception.ResourceNotFoundException;
import io.pn.mapper.TeachersMapper;
import io.pn.repository.CoursesRepository;
import io.pn.repository.TeacherRepository;
import io.pn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    public List<TeachersDto> allTeachers(){
        var result = teacherRepository.findAll();
        List<TeachersDto> teachersDtos = new ArrayList<>();
        result.stream().forEach(teacher -> teachersDtos.add(TeachersMapper.convertToDto(teacher)));
        return teachersDtos;
    }

    public TeachersDto findTeacherById(Long id){
        Teachers teacher = teacherRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not available"));
        return TeachersMapper.convertToDto(teacher);
    }

    @Transactional(rollbackFor = Exception.class)
    public TeachersDto addNewTeacher(TeachersDto dto){
        Courses courses = coursesRepository.findById(dto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("Course Not available"));
        var response = TeachersMapper.convertToEntity(dto);
        response.setCourses(Collections.singletonList(courses));
        var res = teacherRepository.save(response);
        return TeachersMapper.convertToDto(res);
    }

    @Transactional(rollbackFor = Exception.class)
    public TeachersDto updateTeacher(TeachersDto dto){
        Courses courses = coursesRepository.findById(dto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("Course Not available"));
        var teacher = TeachersMapper.convertToEntity(dto);
        teacher.setCourses(Collections.singletonList(courses));
        var savedTeacher = teacherRepository.save(teacher);
        return TeachersMapper.convertToDto(savedTeacher);
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteTeacher(Long id){
        var data = teacherRepository.findById(id);
        try{
            if(data.isPresent()) {
                teacherRepository.deleteById(id);
                return true;
            }
        } catch (RuntimeException e) {
            e.fillInStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }
}
