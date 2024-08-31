/* Created By Sithira Roneth
 * Date :8/31/24
 * Time :22:21
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private String orderId;
    private String cusId;
    private LocalDate date;
}
