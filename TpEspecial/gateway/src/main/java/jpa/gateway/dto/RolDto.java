package jpa.gateway.dto;

import lombok.Data;

@Data
public class RolDto {
    private String nombreRol;

    public RolDto(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
