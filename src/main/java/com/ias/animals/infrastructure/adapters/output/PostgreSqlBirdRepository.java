package com.ias.animals.infrastructure.adapters.output;

import com.ias.animals.birds.aplications.domain.Bird;
import com.ias.animals.birds.aplications.domain.valueObjs.BirdId;
import com.ias.animals.birds.aplications.ports.output.BirdRepository;
import com.ias.animals.infrastructure.logSystem.Log;
import com.ias.animals.infrastructure.models.BirdDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgreSqlBirdRepository implements BirdRepository {
  private final DataSource dataSource;

    public PostgreSqlBirdRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Bird bird){
        String sql = "INSERT INTO tbl_aves(nombre_comun,nombre_cientifico,nombre_zona,cantidad_confirmada) values (?, ?, ?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bird.getNombreComun().getValue());
            preparedStatement.setString(2, bird.getNombreCientifico().getValue());
            preparedStatement.setString(3, bird.getNombreZona().getValue());
            preparedStatement.setInt(4, bird.getCantidadConfirmada().getValue());

            preparedStatement.execute();
        }
        catch (SQLException exception) {
            System.out.println("Error DB....: "  + exception.getMessage());
            throw new RuntimeException("Error query database", exception);
        }

    }

    @Override
    public Optional<Bird> get(BirdId birdId) {
        String sql = "Select * From tbl_aves Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, birdId.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                BirdDAO birdDAO = BirdDAO.fromResultSet(resultSet);
                // logic ---
                Bird bird = birdDAO.toDomain();
                return Optional.of(bird);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error query database", exception);
        }
    }

    @Override
    public void update(Bird bird) {
        String sql = "Update tbl_aves Set nombre_comun = ?, nombre_cientifico = ?, nombre_zona = ?, cantidad_confirmada = ?  Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bird.getNombreComun().getValue());
            preparedStatement.setString(2,bird.getNombreCientifico().getValue());
            preparedStatement.setString(3,bird.getNombreZona().getValue());
            preparedStatement.setInt(4, bird.getCantidadConfirmada().getValue());
            preparedStatement.setLong(5,bird.getId().getValue());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error query database");
            log.logger();
            throw new RuntimeException("Error query database", exception);
        }

    }

    @Override
    public Boolean delete(BirdId birdId) {
        String sql = "Delete from tbl_aves Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, birdId.getValue());

            Boolean result = preparedStatement.execute();

            return result;

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error query database");
            throw  new RuntimeException("Error query database", exception);
        }
    }


}
