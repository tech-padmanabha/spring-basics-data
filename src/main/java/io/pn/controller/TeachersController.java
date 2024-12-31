package io.pn.controller;

import io.pn.dto.TeachersDto;
import io.pn.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/teacher")
public class TeachersController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<TeachersDto> allTeachers(){
        return teacherService.allTeachers();
    }
    @PutMapping
    public TeachersDto updateTeacher(TeachersDto dto){
        return  teacherService.updateTeacher(dto);
    }
    @GetMapping
    public TeachersDto getTeacher(@RequestParam Long id){
        return  teacherService.findTeacherById(id);
    }
    @DeleteMapping
    public boolean removeTeacher(@RequestParam  Long id){
        return teacherService.deleteTeacher(id);
    }
    @PostMapping
    public TeachersDto addNewTeacher(TeachersDto dto){
        return teacherService.addNewTeacher(dto);
    }
}
