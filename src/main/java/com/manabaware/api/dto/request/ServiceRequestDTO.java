package com.manabaware.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceRequestDTO {

    // Uso de anotaciones de validación para garantizar que los datos recibidos
    // cumplan con ciertos criterios, como por ejem @NotBlank para asegurar que el
    // campo no esté vacío y @Size para limitar la longitud del texto.

    // Hago esto para no definir mas logica de validacion el los métodos de Getter y
    // Setter de la clase Service, ya que eso no es su responsabilidad.

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "El nombre no puede superar 150 caracteres")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    private String icon;
}