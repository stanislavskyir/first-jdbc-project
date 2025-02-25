package org.example.dao;

import org.example.entity.Flight;
import org.example.entity.FlightStatus;
import org.example.entity.Ticket;
import org.example.exception.DaoException;
import org.example.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private final static String FIND_ALL_SQL = """
            SELECT id, flight_no, departure_date, departure_airport_code, arrival_date, arrival_airport_code, aircraft_id, status 
            FROM flight
            """;

    private final static String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private final static FlightDao INSTANCE = new FlightDao();

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private FlightDao() {
    }

    @Override
    public boolean update(Flight flight) {
        return false;
    }

    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {

            List<Flight> flights = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flights.add(
                        buildFlight(resultSet)
                );
            }

            return flights;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        try (var connection = ConnectionManager.getConnection()){
            return findById(id, connection);
        } catch (SQLException e) {
            throw new DaoException(e);
        }


    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getLong("id"),
                resultSet.getString("flight_no"),
                resultSet.getTimestamp("departure_date").toLocalDateTime(),
                resultSet.getString("departure_airport_code"),
                resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                resultSet.getString("arrival_airport_code"),
                resultSet.getInt("aircraft_id"),
                FlightStatus.valueOf(resultSet.getString("status").toUpperCase())
        );
    }


    public Optional<Flight> findById(Long id, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID_SQL)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            Flight flight = null;

            if (resultSet.next()) {
                flight = buildFlight(resultSet);
            }

            return Optional.ofNullable(flight);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Flight save(Flight flight) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

