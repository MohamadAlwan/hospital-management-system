package com.example.hospitalmanagementsystem.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // replace the setters and getters for the variables
public class DepartmentDto {
    int id;

    @NotNull // this variable can't be null
    @Size(min=3) //specify what is the minimum length of the variable will be
    String depName;
}
