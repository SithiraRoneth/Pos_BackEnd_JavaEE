package lk.ijse.pos_back_end.BO.Bo;

import lk.ijse.pos_back_end.Dto.CustomerDto;
import lk.ijse.pos_back_end.Entity.Customer;

import java.sql.Connection;
import java.util.List;

public interface CustomerBO {
    Customer saveBOCustomer(CustomerDto customerDto, Connection connection);
    String updateCustomer(CustomerDto customerDto,Connection connection);
    String deleteCustomer(String id,Connection connection);
    List<CustomerDto>getAllCustomers(Connection connection);
}
