package com.example.faol.mapper;

import com.example.faol.dto.DegreeDTO;
import com.example.faol.entity.Degree;

public class DegreeMapper {

    public static DegreeDTO toDTO(Degree degree) {
        if (degree == null) {
            return null;
        }
        DegreeDTO degreeDTO = new DegreeDTO();
        degreeDTO.setId(degree.getId());
        degreeDTO.setName(degree.getName());
        degreeDTO.setDuration(degree.getDuration());
        degreeDTO.setTotal_cost(degree.getTotal_cost());
        return degreeDTO;
    }

    public static Degree toEntity(DegreeDTO degreeDTO) {
        if (degreeDTO == null) {
            return null;
        }
        Degree degree = new Degree();
        degree.setId(degreeDTO.getId());
        degree.setName(degreeDTO.getName());
        degree.setDuration(degreeDTO.getDuration());
        degree.setTotal_cost(degreeDTO.getTotal_cost());
        return degree;
    }
}
