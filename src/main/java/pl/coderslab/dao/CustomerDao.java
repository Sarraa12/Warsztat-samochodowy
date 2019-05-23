package pl.coderslab.dao;

import pl.coderslab.DbUtil;
import pl.coderslab.model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static void main(String[] args) throws SQLException {
        Connection c = DbUtil.getConn();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/warsztat_samochodowy?useSSL=false",
                "root", "coderslab");
        loadAll();
    }

    private static Customer customer;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static List<Customer> loadAll() throws SQLException {
        String sql =
                "SELECT * FROM customers;";
        PreparedStatement preparedStatement = DbUtil.getConn().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Customer> customerArrayList = new ArrayList<>();
        while (resultSet.next()) {
            customer = new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    LocalDate.parse(resultSet.getString("date_of_birth"),formatter)
            );
            customerArrayList.add(customer);
        }
        return customerArrayList;
    }
    public static Customer loadById(int id) throws SQLException {
        String sql =
                "SELECT customers.id, customers.first_name, customers.last_name, customers.date_of_birth FROM customers" +
                        "WHERE customers.id = ?;";
        PreparedStatement preparedStatement = DbUtil.getConn().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        return new Customer(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                LocalDate.parse(resultSet.getString("date_of_birth"), formatter)
        );
    }

    public static void save(Customer customer) throws SQLException {
        String sql = "INSERT INTO warsztat_samochodowy.customers VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = DbUtil.getConn().prepareStatement(sql);
        preparedStatement.setNull(1, customer.getId());
        preparedStatement.setString(2, customer.getFirstName());
        preparedStatement.setString(3, customer.getLastName());
        preparedStatement.setDate(4, Date.valueOf(customer.getBirthday()));
        preparedStatement.executeUpdate();
    }

    public static void delete(Customer customer) throws SQLException {
        String sql = "DELETE FROM warsztat_samochodowy.customers WHERE id = ?;";
        PreparedStatement preparedStatement = DbUtil.getConn().prepareStatement(sql);
        preparedStatement.setInt(1, customer.getId());
        preparedStatement.executeUpdate();
    }

    public static void update(Customer customer) throws SQLException {
        String sql =
                "UPDATE warsztat_samochodowy.customers\n" +
                        "SET customers.first_name = ?, customers.last_name = ?, customers.date_of_birth = ?\n" +
                        "WHERE customers.id = ?;\n";
        PreparedStatement preparedStatement = DbUtil.getConn().prepareStatement(sql);
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setDate(3, Date.valueOf(customer.getBirthday()));
        preparedStatement.setInt(4, customer.getId());
        preparedStatement.executeUpdate();
    }

}
