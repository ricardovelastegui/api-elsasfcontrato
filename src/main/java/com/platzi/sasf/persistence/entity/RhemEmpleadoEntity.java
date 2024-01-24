package com.platzi.sasf.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rhem_empleado")
@NoArgsConstructor
@Getter
@Setter
@IdClass(RhemEmpleadoEntity.class)
public class RhemEmpleadoEntity {

    //@Id
    @Column(name="age_licenc_codigo", nullable = false)
    private Integer ageLicencCodigo;

    @Id
    @Column(name="codigo", nullable = false)
    private Integer codigo;

    @Column(name= "numero_identificacion", nullable = false)
    private Integer numeroIdentificacion;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name ="correo_notificacion")
    private String correoNotificacion;
    @Column(name = "numero_convencional")
    private Integer numeroCoonvencional;
    @Column(name = "numero_celular")
    private Integer numeroCeelular;

    @Column(name = "fecha_entrada", nullable = false)
    private LocalDateTime fechaEntrada;

    @Column(name ="fecha_salida")
    private LocalDateTime fecha_salida;

    @Column(columnDefinition = "CHAR(1)")
    private String estado;

    @Column(name ="observacion_estado", length = 2000)
    private String observacionEstado;

    @Column(name ="fecha_estado", nullable = false)
    private LocalDateTime fechaEstado;

    @Column(name ="fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;

    @Column(name ="fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name ="usuario_ingreso ", nullable = false)
    private LocalDateTime usuarioIngreso;

    @Column(name ="usuario_modificacion")
    private LocalDateTime usuarioModificacion;

    @Column(name ="age_personas_age_licenc_codigo",nullable = false)
    private Integer agePersonasAgeLicencCodigo;

    @Column(name ="age_personas_codigo", nullable = false)
    private Integer agePersonasCodigo;

    @Column(name ="age_sucursales_age_licenc_codigo", nullable = false)
    private Integer ageSucursalesAgeLicencCodigo;

    @Column(name ="age_sucursales_codigo", nullable = false)
    private Integer ageSucursalesCodigo;

    @Column(name ="codigo_biometrico", nullable = false)
    private Integer codigoBiometrico;

    @Column(name ="minutos_espera", nullable = false)
    private Integer minutosEspera;

    @Column(name = "secuencia_marcacion", nullable = false)
    private Integer secuenciaMarcacion;


    @OneToMany(mappedBy = "rhemEmpleado")
    private List<RhemContratoEmpleadoEntity> contratos;
}
