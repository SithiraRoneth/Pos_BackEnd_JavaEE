package lk.ijse.pos_back_end.DAO.Dao;

import lk.ijse.pos_back_end.Dto.ItemDto;

import java.sql.Connection;
import java.util.List;

public interface ItemData {
    String saveItem(ItemDto itemDto, Connection connection);
    String updateItem(ItemDto itemDto,Connection connection);
    String deleteItem(String id,Connection connection);
    List<ItemDto>getAllItem(Connection connection);
}
