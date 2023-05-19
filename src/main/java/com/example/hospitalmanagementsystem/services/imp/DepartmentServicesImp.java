package com.example.hospitalmanagementsystem.services.imp;

import com.example.hospitalmanagementsystem.dto.DepartmentDto;
import com.example.hospitalmanagementsystem.entity.Department;
import com.example.hospitalmanagementsystem.entity.reprositry.DepartmentRepository;
import com.example.hospitalmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.services.DepartmentServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // to let the api know that this page is responsible for services
public class DepartmentServicesImp implements DepartmentServices {

    private DepartmentRepository departmentRepository;

    public DepartmentServicesImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = mapToEntity(departmentDto);
        Department newDepartment = departmentRepository.save(department);

        DepartmentDto departmentResponse = mapToDTO(newDepartment);
        return departmentResponse;
    }

    private DepartmentDto mapToDTO(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setDepName(department.getDepName());
        return departmentDto;
    }

    private Department mapToEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepName(departmentDto.getDepName());
        return department;
    }

    @Override
    public List<DepartmentDto> getAllDepartments()
    {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(department -> mapToDTO(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto getDepartmentById(int id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        return mapToDTO(department);
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, int id) {
        Department department = departmentRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Department", "id", id));
        department.setDepName(departmentDto.getDepName());
        Department newDepartment = departmentRepository.save(department);
        return mapToDTO(newDepartment);


    }

    @Override
    public void deleteDepartmentById(int id) {
        Department department = departmentRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Department", "id", id));
        departmentRepository.delete(department);
    }
}
