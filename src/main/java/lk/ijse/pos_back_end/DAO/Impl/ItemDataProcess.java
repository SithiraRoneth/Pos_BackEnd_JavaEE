/* Created By Sithira Roneth
 * Date :8/15/24
 * Time :00:03
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.DAO.Impl;

import lk.ijse.pos_back_end.DAO.ItemData;
import lk.ijse.pos_back_end.Dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDataProcess implements ItemData {
    static String ITEM_SAVED = "INSERT INTO item(item_code,item_name,item_price,item_qty) VALUES(?,?,?,?)";
    static String GET_ITEMS = "SELECT * FROM item";
    static String UPDATE_ITEMS = "UPDATE item SET item_name = ?,item_price = ?,item_qty = ? WHERE item_code = ?";
    static String DELETE_ITEMS = "DELETE FROM item WHERE item_code = ?";

    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(ITEM_SAVED);

            ps.setString(1, itemDto.getCode());
            ps.setString(2, itemDto.getItemName());
            ps.setDouble(3, itemDto.getUnitPrice());
            ps.setInt(4, itemDto.getQtyOnHand());


            if (ps.executeUpdate() != 0) {
                return "Item Saved";
            } else {
                return "Unsuccessful";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String updateItem(ItemDto itemDto, Connection connection) {
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_ITEMS);
            ps.setString(1,itemDto.getCode());
            ps.setString(2,itemDto.getItemName());
            ps.setString(3, String.valueOf(itemDto.getUnitPrice()));
            ps.setString(4, String.valueOf(itemDto.getQtyOnHand()));

            if (ps.executeUpdate() !=0){
                return "Item Updated";
            }else {
                return "Updating Failed";
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteItem(String id, Connection connection) {
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_ITEMS);
            ps.setString(1,id);

            if (ps.executeUpdate() !=0){
                return "Item Delete";
            }else {
                return "Deleting failed";
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ItemDto> getAllItem(Connection connection) {
        List<ItemDto> items = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(GET_ITEMS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ItemDto itemDto = new ItemDto();
                itemDto.setCode(rs.getString("item_code"));
                itemDto.setItemName(rs.getString("item_name"));
                itemDto.setUnitPrice(rs.getInt("item_price"));
                itemDto.setQtyOnHand(rs.getInt("item_qty"));

                items.add(itemDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }


}
