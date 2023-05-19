package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.dto.MedicineDto;

import java.util.List;

public interface MedicineServices {
    MedicineDto createMedicine(MedicineDto medicineDto);

    List<MedicineDto> getAllMedicines();

    MedicineDto getMedicineById(int id);

    MedicineDto updateMedicine(MedicineDto medicineDto,int id);

    void deleteMedicineById(int id);
}
