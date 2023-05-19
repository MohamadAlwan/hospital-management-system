package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.dto.DoctorDto;

import java.util.List;

public interface DoctorServices {
    DoctorDto createDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctorById(int id);

    DoctorDto updateDoctor(DoctorDto doctorDto,int id);

    void deleteDoctorById(int id);
}
