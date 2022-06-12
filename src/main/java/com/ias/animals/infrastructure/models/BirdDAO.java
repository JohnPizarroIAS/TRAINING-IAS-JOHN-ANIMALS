package com.ias.animals.infrastructure.models;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BirdDAO {
    private Long id;
    private String nombreComun;
    private String nombreCientifico;
    private String nombreZona;
    private Integer cantidadConfirmada;

    public BirdDAO(Long id, String nombreComun, String nombreCientifico, String nombreZona, Integer cantidadConfirmada) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.nombreZona = nombreZona;
        this.cantidadConfirmada = cantidadConfirmada;
    }

    public BirdDAO() {
    }

    public Bird toDomain(){
        return new Bird(
                new BirdId(id),
                new BirdNombreComun(nombreComun),
                new BirdNombreCientifico(nombreCientifico),
                new BirdNombreZona(nombreZona),
                new BirdCantidadConfirmada(cantidadConfirmada)
        );
    }

    public  static BirdDAO fromDomain(Bird bird){
        BirdDAO birdDAO = new BirdDAO(
            bird.getId().getValue(),
            bird.getNombreComun().getValue(),
            bird.getNombreCientifico().getValue(),
            bird.getNombreZona().getValue(),
            bird.getCantidadConfirmada().getValue()
        );
        return birdDAO;
    }

    public static BirdDAO fromResultSet(ResultSet resultSet) throws SQLException{
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setId(resultSet.getLong("id"));
        birdDAO.setNombreComun(resultSet.getString("nombre_comun"));
        birdDAO.setNombreCientifico(resultSet.getString("nombre_cientifico"));
        birdDAO.setNombreZona(resultSet.getString("nombre_zona"));
        birdDAO.setCantidadConfirmada(resultSet.getInt("cantidad_confirmada"));
        return birdDAO;
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
}
