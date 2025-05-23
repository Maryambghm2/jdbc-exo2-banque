package org.example.dao;

import org.example.models.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OperationDao extends BaseDao<Operation> {

    public OperationDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        request = "INSERT INTO operations (amount, status, account_id) VALUES (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);

        statement.setDouble(1, element.getAmount());
        statement.setString(2, element.getStatus().name());
        statement.setInt(3, element.getAccountId().getId());

        nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Operation element) throws SQLException {
        request = "UPDATE operations SET amount = ?, status = ?, account_id = ?";
        statement = connection.prepareStatement(request);

        statement.setDouble(1, element.getAmount());
        statement.setString(2, element.getStatus().name());
        statement.setInt(3, element.getAccountId().getId());

        nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(Operation element) throws SQLException {
        request = "DELETE from operations WHERE id = ?";
        statement = connection.prepareStatement(request);

        statement.setInt(1, element.getId());

        nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Operation get(int id) throws SQLException {
     Operation operation = null;
     request = "SELECT * FROM operations WHERE id = ?";
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
//        if (resultSet.next()) {
//            Operation operation = new Operation(
//                    resultSet.getInt("amount");
//
//            )
//        }
//
        return operation;
    }

    @Override
    public List<Operation> get() throws SQLException {
        return List.of();
    }
}
