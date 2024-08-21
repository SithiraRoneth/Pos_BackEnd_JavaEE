/* Created By Sithira Roneth
 * Date :8/15/24
 * Time :00:03
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.DAO.Impl;

import lk.ijse.pos_back_end.DAO.CustomerData;
import lk.ijse.pos_back_end.Dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataProcess implements CustomerData {

    static String SAVE_CUSTOMER = "INSERT INTO customer (cus_id,cus_name,cus_address,cus_salary) VALUES (?,?,?,?)";
    static String GET_CUSTOMERS = "SELECT * FROM customer";
    static String UPDATE_CUSTOMER = "UPDATE customer SET cus_name = ?, cus_address = ?, cus_salary = ? WHERE cus_id = ?";
    static String DELETE_CUSTOMER = "DELETE FROM customer WHERE cus_id = ? ";

    @Override
    public String saveCustomer(CustomerDto customerDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(SAVE_CUSTOMER);

            ps.setString(1,customerDto.getId());
            ps.setString(2,customerDto.getName());
            ps.setString(3,customerDto.getAddress());
            ps.setString(4, String.valueOf(customerDto.getSalary()));

            if (ps.executeUpdate() !=0){
                return "customer saved";
            }else {
                return "failed";
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public String deleteCustomer(String id, Connection connection) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setString(1, id);

            if (ps.executeUpdate()!= 0){
                return "Customer Deleted";
            }else {
                return "Deleting failed";
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public String updateCustomer(CustomerDto customerDto, Connection connection) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1,customerDto.getName());
            ps.setString(2,customerDto.getAddress());
            ps.setString(3, String.valueOf(customerDto.getSalary()));
            ps.setString(4,customerDto.getId());

            if (ps.executeUpdate() !=0){
                return "Updated";
            }else {
                return "failed";
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer(Connection connection) {
        List<CustomerDto> customer = new ArrayList<>();

        try {
            var ps = connection.prepareStatement(GET_CUSTOMERS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
              CustomerDto customerDto = new CustomerDto();
              customerDto.setId(rs.getString("cus_id"));
              customerDto.setName(rs.getString("cus_name"));
              customerDto.setAddress(rs.getString("cus_address"));
              customerDto.setSalary(rs.getInt("cus_salary"));

              customer.add(customerDto);
            };

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return customer;
    }

}
