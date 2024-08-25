/* Created By Sithira Roneth
 * Date :8/26/24
 * Time :00:06
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String code;
    private String itemName;
    private int unitPrice;
    private int qtyOnHand;
}
