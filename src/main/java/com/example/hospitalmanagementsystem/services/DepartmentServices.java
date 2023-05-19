package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.dto.DepartmentDto;

import java.util.List;

public interface DepartmentServices {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(int id);

    DepartmentDto updateDepartment(DepartmentDto departmentDto,int id);

    void deleteDepartmentById(int id);
}
