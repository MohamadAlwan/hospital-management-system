package com.example.hospitalmanagementsystem.services;
import com.example.hospitalmanagementsystem.dto.PatentDto;

import java.util.List;
public interface PatentServices {
    PatentDto createPatent(PatentDto patentDto);

    List<PatentDto> getAllPatents();

    PatentDto getPatentById(int id);

    PatentDto updatePatent(PatentDto patentDto,int id);

    void deletePatentById(int id);
}
