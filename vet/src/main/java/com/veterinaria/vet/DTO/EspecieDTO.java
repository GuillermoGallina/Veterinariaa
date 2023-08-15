package com.veterinaria.vet.DTO;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.Default;





public class EspecieDTO {
    @NotBlank(groups = { PutAndDelete.class })
    private Long ID;


    @NotBlank(message = "El campo descripción no puede estar vacío")
    private String descripcion;

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); 
        return objectMapper.writeValueAsString(this);
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descipcion) {
        this.descripcion = descipcion;
    }
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }

    public EspecieDTO(@NotBlank(groups = PutAndDelete.class) Long iD,
            @NotBlank(message = "El campo descripción no puede estar vacío") String descripcion) {
        ID = iD;
        this.descripcion = descripcion;
    }
    public EspecieDTO() {
    }

    public interface PutAndDelete extends Default {
    }
}
