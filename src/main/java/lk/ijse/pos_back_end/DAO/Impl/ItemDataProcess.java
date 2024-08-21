/* Created By Sithira Roneth
 * Date :8/15/24
 * Time :00:03
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.DAO.Impl;

import lk.ijse.pos_back_end.DAO.ItemData;
import lk.ijse.pos_back_end.Dto.ItemDto;

import java.sql.Connection;
import java.sql.SQLException;

public class ItemDataProcess implements ItemData {
    static String ITEM_SAVED = "INSERT INTO item(item_code,item_name,item_price,item_qty) VALUES(?,?,?,?)";
    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        try {
            var ps = connection.prepareStatement(ITEM_SAVED);

            ps.setString(1,itemDto.getItemCode());
            ps.setString(2,itemDto.getItemName());
            ps.setString(3,String.valueOf(itemDto.getItemPrice()));
            ps.setString(4,String.valueOf(itemDto.getItemQty()));

            if (ps.executeUpdate() !=0){
                return "Item Saved";
            }else {
                return "Unsuccessfully";
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
