package io.pn.mapper;

import io.pn.dto.TeachersDto;
import io.pn.entity.Teachers;

public class TeachersMapper {

    public static TeachersDto convertToDto(Teachers t){
        TeachersDto td = new TeachersDto();
        td.setId(t.getId());
        td.setFee(t.getFee());
        td.setName(t.getName());
        td.setCourseId(t.getCourses().getFirst().getId());
        return td;
    }
    public static Teachers convertToEntity(TeachersDto t){
        Teachers td = new Teachers();
        td.setId(t.getId());
        td.setFee(t.getFee());
        td.setName(t.getName());
        return td;
    }
}
