/* Created By Sithira Roneth
 * Date :8/31/24
 * Time :22:27
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private String orderId;
    private String id;
    private String proId;
    private int qtyOnHand;
    private int unitPrice;
}
