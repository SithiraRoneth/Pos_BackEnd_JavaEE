package lk.ijse.pos_back_end.DAO.Dao;

import lk.ijse.pos_back_end.Dto.CustomerDto;

import java.sql.Connection;
import java.util.List;

public interface CustomerData {
    String saveCustomer(CustomerDto customerDto, Connection connection);
    String deleteCustomer(String id, Connection connection);
    String updateCustomer(CustomerDto customerDto, Connection connection);
    List<CustomerDto> getAllCustomer(Connection connection);
}
