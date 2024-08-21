/* Created By Sithira Roneth
 * Date :8/14/24
 * Time :22:29
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
import lk.ijse.pos_back_end.DAO.Impl.CustomerDataProcess;
import lk.ijse.pos_back_end.Dto.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/customer" , loadOnStartup = 2)
public class CustomerController extends HttpServlet {
    static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    Connection connection;
    CustomerDataProcess customerData = new CustomerDataProcess();

    @Override
    public void init() throws ServletException {

        logger.info("initialize CustomerController");
        try {
            var ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/PosBackEnd");
            this.connection = pool.getConnection();
        } catch (NamingException | SQLException e ) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null) {
            //send error
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        try(var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

            var saveCustomer = customerData.saveCustomer(customerDto, connection);
            writer.write(saveCustomer);

            logger.info("Customer Saved");

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null) {
            //send error
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        try (var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
            var updateCustomer = customerData.updateCustomer(customerDto, connection);

            writer.write(updateCustomer);
            logger.info("Update Customer");

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (var writer = resp.getWriter()){
            List<CustomerDto> customers = customerData.getAllCustomer(connection);

            Jsonb jsonb = JsonbBuilder.create();
            String json = jsonb.toJson(customers);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            writer.write(json);

            logger.info("All customer Details are retrieved");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try(var writer = resp.getWriter()){
            var deleteCustomer = customerData.deleteCustomer(id, connection);

            writer.write(deleteCustomer);
            logger.info("Delete Customer");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
