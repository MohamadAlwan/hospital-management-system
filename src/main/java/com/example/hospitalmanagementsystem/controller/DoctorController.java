package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.dto.PatentDto;
import com.example.hospitalmanagementsystem.exceptions.BadRequestException;
import com.example.hospitalmanagementsystem.services.DoctorServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to identify this class as a controller for this api
@RequestMapping("/hms/doctor") // the path for calling the api
public class DoctorController {

    private DoctorServices doctorServices;

    public DoctorController(DoctorServices doctorServices) {
        this.doctorServices = doctorServices;
    }

    @GetMapping // get the information from the database
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok().body(doctorServices.getAllDoctors());
    }

    @GetMapping("{id}") // to specify that there will be an id after the path
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(doctorServices.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor
            (@Valid @RequestBody DoctorDto doctorDto) {
        try {
            return new ResponseEntity(doctorServices.createDoctor(doctorDto), HttpStatus.CREATED);
        } catch (BadRequestException ex) {
            throw new BadRequestException(PatentController.class.getSimpleName(),
                    "Id");
        }
    }


    @PutMapping("{id}") // updating data
    public ResponseEntity<DoctorDto> updateDoctor(@Valid @RequestBody DoctorDto doctorDto, @PathVariable(name = "id") int id) {
        return new ResponseEntity(doctorServices.updateDoctor(doctorDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deleteDoctor(@PathVariable(name = "id") int id) {
        doctorServices.deleteDoctorById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);

    }
}
