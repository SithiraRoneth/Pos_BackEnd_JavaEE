/* Created By Sithira Roneth
 * Date :8/31/24
 * Time :22:26
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String cusId;
    private LocalDate date;
}
