/* Created By Sithira Roneth
 * Date :8/14/24
 * Time :23:53
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String itemCode;
    private String itemName;
    private int itemPrice;
    private int itemQty;
}
