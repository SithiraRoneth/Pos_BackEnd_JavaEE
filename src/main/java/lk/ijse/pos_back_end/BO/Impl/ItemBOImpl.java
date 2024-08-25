/* Created By Sithira Roneth
 * Date :8/23/24
 * Time :11:30
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.BO.Impl;

import lk.ijse.pos_back_end.BO.ItemBO;
import lk.ijse.pos_back_end.Dto.ItemDto;

import java.sql.Connection;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    @Override
    public String saveItem(ItemDto itemDto, Connection connection) {
        return null;
    }

    @Override
    public String updateItem(ItemDto itemDto, Connection connection) {
        return null;
    }

    @Override
    public String deleteItem(String code, Connection connection) {
        return null;
    }

    @Override
    public List<ItemDto> getAllItems(Connection connection) {
        return null;
    }
}
