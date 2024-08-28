/* Created By Sithira Roneth
 * Date :8/23/24
 * Time :11:29
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.BO.Impl;

import lk.ijse.pos_back_end.BO.Bo.CustomerBO;
import lk.ijse.pos_back_end.Dto.CustomerDto;
import lk.ijse.pos_back_end.Entity.Customer;

import java.sql.Connection;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    @Override
    public Customer saveBOCustomer(CustomerDto customerDto, Connection connection) {
        //return new Customer(customerDto.getId(),customerDto.getName(),customerDto.getAddress(),customerDto.getSalary(),connection);
        return null;
    }

    @Override
    public String updateCustomer(CustomerDto customerDto, Connection connection) {
        return null;
    }

    @Override
    public String deleteCustomer(String id, Connection connection) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers(Connection connection) {
        return null;
    }
}