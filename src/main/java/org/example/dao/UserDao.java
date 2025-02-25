package org.example.dao;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.entity.Gender;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.exception.DaoException;
import org.example.utils.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserDao implements Dao<Long, User> {
    private static final UserDao INSTANCE = new UserDao();
    private static final String SAVE_SQL = "INSERT INTO users (name, birthday, email, password, role, gender) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL =
            "SELECT * FROM users WHERE email = ? AND password = ?";

    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email, String password) {
        try(var connection = ConnectionManager.getConnection();
            var preparedStatment = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)){
            preparedStatment.setString(1, email);
            preparedStatment.setString(2, password);

            var resultSet = preparedStatment.executeQuery();
            User user = null;
            if(resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    private User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public User save(User user) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getBirthday());
            preparedStatement.setObject(3, user.getEmail());
            preparedStatement.setObject(4, user.getPassword());
            preparedStatement.setObject(5, user.getRole().name());
            preparedStatement.setObject(6, user.getGender().name());

            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            user.setId(generatedKeys.getObject("id", Integer.class));



            return user;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
