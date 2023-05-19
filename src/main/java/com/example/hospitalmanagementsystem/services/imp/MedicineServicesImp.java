package com.example.hospitalmanagementsystem.services.imp;

import com.example.hospitalmanagementsystem.dto.MedicineDto;
import com.example.hospitalmanagementsystem.entity.Medicine;
import com.example.hospitalmanagementsystem.entity.reprositry.MedicineRepository;
import com.example.hospitalmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.services.MedicineServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // to let the api know that this page is responsible for services
public class MedicineServicesImp implements MedicineServices {

    private MedicineRepository medicineRepository;

    public MedicineServicesImp(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }
    
    @Override
    public MedicineDto createMedicine(MedicineDto medicineDto) {
        Medicine medicine = mapToEntity(medicineDto);
        Medicine newmedicine = medicineRepository.save(medicine);

        MedicineDto medicineResponse = mapToDTO(newmedicine);
        return medicineResponse;
    }

    private MedicineDto mapToDTO(Medicine medicine) {
        MedicineDto medicineDto = new MedicineDto();
        medicineDto.setId(medicine.getId());
        medicineDto.setName(medicine.getName());
        medicineDto.setDescription(medicine.getDescription());
        medicineDto.setPrice(medicine.getPrice());
        medicineDto.setQuantity(medicine.getQuantity());
        return medicineDto;
    }

    private Medicine mapToEntity(MedicineDto medicineDto) {
        Medicine medicine = new Medicine();
        medicine.setName(medicineDto.getName());
        medicine.setDescription(medicineDto.getDescription());
        medicine.setPrice(medicineDto.getPrice());
        medicine.setQuantity(medicineDto.getQuantity());
        return medicine;
    }

    @Override
    public List<MedicineDto> getAllMedicines() {
        List<Medicine> medicines = medicineRepository.findAll();
        return medicines.stream().map(medicine -> mapToDTO(medicine))
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDto getMedicineById(int id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("medicine", "id", id));
        return mapToDTO(medicine);
    }

    @Override
    public MedicineDto updateMedicine(MedicineDto medicineDto, int id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("medicine", "id", id));
        medicine.setName(medicineDto.getName());
        medicine.setDescription(medicineDto.getDescription());
        medicine.setPrice(medicineDto.getPrice());
        medicine.setQuantity(medicineDto.getQuantity());
        Medicine newmedicine = medicineRepository.save(medicine);
        return mapToDTO(newmedicine);

    }

    @Override
    public void deleteMedicineById(int id) {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("medicine", "id", id));
        medicineRepository.delete(medicine);
    }
}
