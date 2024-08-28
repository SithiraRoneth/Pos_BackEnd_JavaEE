/* Created By Sithira Roneth
 * Date :8/28/24
 * Time :22:37
 * Project Name :Pos_Back_End
 * */
package lk.ijse.pos_back_end.Controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {
    static Logger logger = LoggerFactory.getLogger(OrderController.class);
    Connection connection;


    @Override
    public void init() throws ServletException {
        logger.info("initialize OrderController");
        try {
            var ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/PosBackEnd");
            this.connection = pool.getConnection();
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null) {
            //send error
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        /*try (var writer = resp.getWriter()) {
            Jsonb jsonb = JsonbBuilder.create();
            OrderDto orderDto = jsonb.fromJson(req.getReader(), OrderDto.class);
            OrderDetailsDto orderDetailsDto = jsonb.fromJson(req.getReader(), OrderDetailsDto.class);
            System.out.println("POST");

            var saveOrder = orderDAO.saveOrder(orderDto, connection);
            writer.write(saveOrder);

            logger.info("Order Saved");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
