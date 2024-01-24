package com.platzi.sasf.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@IdClass(RhemContratoEmpleadoId.class)
@Entity
@Table(name = "RhemContratoEmpleado")
@NoArgsConstructor
@Getter
@Setter
public class RhemContratoEmpleadoEntity {

    //@Id
    @Column(name="age_licenc_codigo", nullable = false)
    private Integer ageLicencCodigo;
    @Id
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fecha_estado", nullable = false)
    private LocalDateTime fechaEstado;
    @Column(name ="fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "observacion_estado")
    private String observacionEstado;

    @Column(name = "ubicacion_ingreso", nullable = false)
    private String ubicacionIngreso;

    @Column(name ="ubicacion_modificacion")
    private String ubicacionModificacion;

    @Column(name ="usuario_ingreso",nullable = false)
    private Integer usuarioIngreso;

    @Column(name = "usuario_modificacion")
    private Integer usuario_modificacion;

    @Column(name = "fecha_contrato", nullable = false)
    private LocalDateTime fecha_contrato;

    @Column(name = "plazo_contrato", nullable = false)
    private Integer plazoContrato;

    @Column(name ="ruta_archivo")
    private String rutaArchivo;

    @Column(name="unidad_tiempo_contrato")
    private String unidadTiempoContrato;

    //foreign key

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "rhem_empleado_codigo", referencedColumnName = "codigo"),
            @JoinColumn(name = "rhem_empleado_age_licenc_codigo", referencedColumnName = "age_licenc_codigo")
    })
    private RhemEmpleadoEntity rhemEmpleado;
}
