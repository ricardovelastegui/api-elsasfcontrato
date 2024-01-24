package com.platzi.sasf.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RhemEmpleadoId implements Serializable {

    private Integer ageLicencCodigo;
    private Integer codigo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RhemEmpleadoId that = (RhemEmpleadoId) o;
        return Objects.equals(ageLicencCodigo, that.ageLicencCodigo) && Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageLicencCodigo, codigo);
    }
}
