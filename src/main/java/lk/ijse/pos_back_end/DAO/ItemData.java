package lk.ijse.pos_back_end.DAO;

import lk.ijse.pos_back_end.Dto.ItemDto;

import java.sql.Connection;

public interface ItemData {
    String saveItem(ItemDto itemDto, Connection connection);
}
