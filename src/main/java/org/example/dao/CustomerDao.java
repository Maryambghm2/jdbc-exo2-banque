package org.example.dao;

import org.example.models.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends BaseDao<Customer> {

    public CustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Customer element) throws SQLException {
        request = "INSERT INTO customers (lastname, firstname, phone) VALUES (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, element.getLastname());
        statement.setString(2, element.getFirstname());
        statement.setString(3, element.getPhone());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        request = "UPDATE customers SET lastname = ?, firstname = ?, phone = ? WHERE id = ?";
        statement = connection.prepareStatement(request);
        statement.setString(1, element.getLastname());
        statement.setString(2, element.getFirstname());
        statement.setString(3, element.getPhone());
        statement.setInt(4, element.getId());
        nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public boolean delete(Customer element) throws SQLException {
        request = "DELETE FROM customers WHERE id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1, element.getId());
        nbRows = statement.executeUpdate();
        return nbRows == 1;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM customers WHERE id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            customer = new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("lastname"),
                    resultSet.getString("firstname"),
                    resultSet.getString("phone"));
        }
        return customer;


    }

    @Override
    public List<Customer> get() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        request = "SELECT * FROM customers";
        statement = connection.prepareStatement(request);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Customer customer = new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("lastname"),
                    resultSet.getString("firstname"),
                    resultSet.getString("phone"));
            customers.add(customer);
        }
        return customers;
    }
}
