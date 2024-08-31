/* Created By Sithira Roneth
 * Date :8/31/24
 * Time :22:21
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private String orderId;
    private String cusId;
    private String proId;
    private int qtyOnHand;
    private int unitPrice;
}
