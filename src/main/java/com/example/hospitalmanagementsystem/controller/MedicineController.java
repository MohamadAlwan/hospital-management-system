package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.dto.MedicineDto;
import com.example.hospitalmanagementsystem.exceptions.BadRequestException;
import com.example.hospitalmanagementsystem.services.DepartmentServices;
import com.example.hospitalmanagementsystem.services.MedicineServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // to identify this class as a controller for this api
@RequestMapping("/hms/medicine") // the path for calling the api
public class MedicineController {

    private MedicineServices medicineServices;

    public MedicineController(MedicineServices medicineServices) {
        this.medicineServices = medicineServices;
    }

    @GetMapping // get the information from the database
    public ResponseEntity<List<MedicineDto>> getAllMedicines() {
        return ResponseEntity.ok().body(medicineServices.getAllMedicines());
    }

    @GetMapping("{id}") // to specify that there will be an id after the path
    public ResponseEntity<MedicineDto> getMedicineById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok().body(medicineServices.getMedicineById(id));
    }

    @PostMapping
    public ResponseEntity<MedicineDto> createmedicine
            (@Valid @RequestBody MedicineDto medicineDto) {
        try {
            return new ResponseEntity(medicineServices.createMedicine(medicineDto), HttpStatus.CREATED);
        } catch (BadRequestException ex) {
            throw new BadRequestException(MedicineController.class.getSimpleName(),
                    "Id");
        }
    }

    @PutMapping("{id}") // updating data
    public ResponseEntity<MedicineDto> updateMedicine(@Valid @RequestBody MedicineDto medicineDto, @PathVariable(name = "id") int id) {
        return new ResponseEntity(medicineServices.updateMedicine(medicineDto, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}") // deleting data
    public ResponseEntity<String> deleteMedicine(@PathVariable(name = "id") int id) {
        medicineServices.deleteMedicineById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);

    }
}
