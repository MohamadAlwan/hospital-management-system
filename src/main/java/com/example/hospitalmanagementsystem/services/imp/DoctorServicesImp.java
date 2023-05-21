package com.example.hospitalmanagementsystem.services.imp;

import com.example.hospitalmanagementsystem.dto.DoctorDto;
import com.example.hospitalmanagementsystem.entity.Doctor;
import com.example.hospitalmanagementsystem.entity.reprositry.DoctorRepository;
import com.example.hospitalmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.services.DoctorServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // to let the api know that this page is responsible for services
public class DoctorServicesImp implements DoctorServices {

    private DoctorRepository doctorRepository;

    public DoctorServicesImp(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor newDoctor = doctorRepository.save(doctor);

        DoctorDto doctorResponse = mapToDTO(newDoctor);
        return doctorResponse;
    }

    // convert the data from an entity to DTO
    private DoctorDto mapToDTO(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setPhoneNumber(doctor.getPhoneNumber());
        return doctorDto;
    }

    // convert the data from DTO to entity
    private Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        return doctor;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> mapToDTO(doctor))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", id));
        return mapToDTO(doctor);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("doctor", "id", id));
        doctor.setName(doctorDto.getName());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setPhoneNumber(doctorDto.getPhoneNumber());
        Doctor newdoctor = doctorRepository.save(doctor);
        return mapToDTO(newdoctor);
    }

    @Override
    public void deleteDoctorById(int id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("doctor", "id", id));
        doctorRepository.delete(doctor);
    }
}
