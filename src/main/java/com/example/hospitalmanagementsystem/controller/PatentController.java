package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.PatentDto;
import com.example.hospitalmanagementsystem.exceptions.BadRequestException;
import com.example.hospitalmanagementsystem.services.PatentServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to identify this class as a controller for this api
@RequestMapping("/hms/patent") // the path for calling the api
public class PatentController {
    private PatentServices patentServices;

    public PatentController(PatentServices patentServices) {
        this.patentServices = patentServices;
    }

    @GetMapping // get the information from the database
    public ResponseEntity<List<PatentDto>> getAllPatents() {
        return ResponseEntity.ok().body(patentServices.getAllPatents());
    }

    @GetMapping("{id}") // to specify that there will be an id after the path
    public ResponseEntity<PatentDto> getPatentById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(patentServices.getPatentById(id));
    }

    @PostMapping
    public ResponseEntity<PatentDto> createPatent
            (@Valid @RequestBody PatentDto patentDto) {
        try {
            return new ResponseEntity(patentServices.createPatent(patentDto), HttpStatus.CREATED);
        } catch (BadRequestException ex) {
            throw new BadRequestException(PatentController.class.getSimpleName(),
                    "Id");
        }
    }

    @PutMapping("{id}") // updating data
    public ResponseEntity<PatentDto> updatePatent(@Valid @RequestBody PatentDto patentDto, @PathVariable(name = "id") int id) {
        return new ResponseEntity(patentServices.updatePatent(patentDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deletePatent(@PathVariable(name = "id") int id) {
        patentServices.deletePatentById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);

    }
}
