package com.ias.animals.infrastructure.models;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.*;

public class BirdDTO {

    private Long id;
    private String nombreComun;
    private String nombreCientifico;
    private String nombreZona;
    private Integer cantidadConfirmada;
    private String status;

    public BirdDTO(Long id, String nombreComun, String nombreCientifico, String nombreZona, Integer cantidadConfirmada) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.nombreZona = nombreZona;
        this.cantidadConfirmada = cantidadConfirmada;
    }


    public Bird toDomain(){
        return new Bird(
            new BirdId(id),
            new BirdNombreComun(nombreComun),
            new BirdNombreCientifico(nombreCientifico),
            new BirdNombreZona(nombreCientifico),
            new BirdCantidadConfirmada(cantidadConfirmada)
        );
    }

    public static BirdDTO fromDomain(Bird bird){
            BirdDTO birdDTO = new BirdDTO();
            birdDTO.setId(bird.getId().getValue());
            birdDTO.setNombreComun(bird.getNombreComun().getValue());
            birdDTO.setNombreCientifico(bird.getNombreCientifico().getValue());
            birdDTO.setNombreZona(bird.getNombreZona().getValue());
            birdDTO.setCantidadConfirmada(bird.getCantidadConfirmada().getValue());

            return birdDTO;
    }

    public BirdDTO(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public void setCantidadConfirmada(Integer cantidadConfirmada) {
        this.cantidadConfirmada = cantidadConfirmada;
    }

    public Long getId() {
        return id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public Integer getCantidadConfirmada() {
        return cantidadConfirmada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "BirdDTO{" +
                "id=" + id +
                ", nombreComun='" + nombreComun + '\'' +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                ", nombreZona='" + nombreZona + '\'' +
                ", cantidadConfirmada=" + cantidadConfirmada +
                '}';
    }
}
