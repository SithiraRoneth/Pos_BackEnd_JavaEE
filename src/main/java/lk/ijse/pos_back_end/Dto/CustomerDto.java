/* Created By Sithira Roneth
 * Date :8/14/24
 * Time :22:46
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private int salary;
}
