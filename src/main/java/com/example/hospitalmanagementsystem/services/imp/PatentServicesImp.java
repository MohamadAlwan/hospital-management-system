package com.example.hospitalmanagementsystem.services.imp;

import com.example.hospitalmanagementsystem.dto.PatentDto;
import com.example.hospitalmanagementsystem.entity.Patent;
import com.example.hospitalmanagementsystem.entity.reprositry.PatentRepository;
import com.example.hospitalmanagementsystem.exceptions.ResourceNotFoundException;
import com.example.hospitalmanagementsystem.services.PatentServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // to let the api know that this page is responsible for services
public class PatentServicesImp implements PatentServices {

    private PatentRepository patentRepository;

    public PatentServicesImp(PatentRepository patentRepository) {
        this.patentRepository = patentRepository;
    }
    @Override
    public PatentDto createPatent(PatentDto patentDto) {
        Patent patent = mapToEntity(patentDto);
        Patent newpatent = patentRepository.save(patent);

        PatentDto patentResponse = mapToDTO(newpatent);
        return patentResponse;
    }

    // convert the data from an entity to DTO
    private PatentDto mapToDTO(Patent patent) {
        PatentDto patentDto = new PatentDto();
        patentDto.setId(patent.getId());
        patentDto.setName(patent.getName());
        patentDto.setAddress(patent.getAddress());
        patentDto.setAge(patent.getAge());
        patentDto.setPhoneNumber(patent.getPhoneNumber());
        return patentDto;
    }

    // convert the data from DTO to entity
    private Patent mapToEntity(PatentDto patentDto) {
        Patent patent = new Patent();
        patent.setName(patentDto.getName());
        patent.setAddress(patentDto.getAddress());
        patent.setAge(patentDto.getAge());
        patent.setPhoneNumber(patentDto.getPhoneNumber());
        return patent;
    }

    @Override
    public List<PatentDto> getAllPatents() {
        List<Patent> patents = patentRepository.findAll();
        return patents.stream().map(patent -> mapToDTO(patent))
                .collect(Collectors.toList());
    }

    @Override
    public PatentDto getPatentById(int id) {
        Patent patent = patentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("patent", "id", id));
        return mapToDTO(patent);
    }

    @Override
    public PatentDto updatePatent(PatentDto patentDto, int id) {
        Patent patent = patentRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("patent", "id", id));
        patent.setName(patentDto.getName());
        patent.setAddress(patentDto.getAddress());
        patent.setAge(patentDto.getAge());
        patent.setPhoneNumber(patentDto.getPhoneNumber());
        Patent newpatent = patentRepository.save(patent);
        return mapToDTO(newpatent);
    }

    @Override
    public void deletePatentById(int id) {
        Patent patent = patentRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("patent", "id", id));
        patentRepository.delete(patent);
    }
}
