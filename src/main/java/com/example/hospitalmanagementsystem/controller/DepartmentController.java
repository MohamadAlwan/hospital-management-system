package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.DepartmentDto;
import com.example.hospitalmanagementsystem.exceptions.BadRequestException;
import com.example.hospitalmanagementsystem.services.DepartmentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to identify this class as a controller for this api
@RequestMapping("/hms/department") // the path for calling the api
public class DepartmentController {
    private DepartmentServices departmentServices;

    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping // get the information from the database
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok().body(departmentServices.getAllDepartments());
    }

    @GetMapping("{id}") // to specify that there will be an id after the path
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(departmentServices.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment
            (@Valid @RequestBody DepartmentDto departmentDto) {
        try {
            return new ResponseEntity(departmentServices.createDepartment(departmentDto), HttpStatus.CREATED);
        } catch (BadRequestException ex) {
            throw new BadRequestException(DepartmentController.class.getSimpleName(),
                    "Id");
        }
    }

    @PutMapping("{id}") // updating data
    public ResponseEntity<DepartmentDto> updateDepartment(@Valid @RequestBody DepartmentDto departmentDto, @PathVariable(name = "id") int id) {
        return new ResponseEntity(departmentServices.updateDepartment(departmentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deleteDepartment(@PathVariable(name = "id") int id) {
        departmentServices.deleteDepartmentById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);

    }
}
