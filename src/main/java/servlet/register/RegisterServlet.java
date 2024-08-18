package servlet.register;

import bean.customer.Customer;
import service.customerService.CustomerService;
import service.customerService.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "RegisterServlet",
        urlPatterns = {"/Register"}
)
public class RegisterServlet extends HttpServlet {
    private static final String REGISTER_URL = "WEB-INF/jsp/register/Register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(REGISTER_URL).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String r_account = request.getParameter("R_Account");
        String r_password = request.getParameter("R_Password");
        String r_tel = request.getParameter("R_Tel");

        Customer customer = new Customer();
        customer.setAccount(r_account);
        customer.setPassword(r_password);
        customer.setPhone(r_tel);
        CustomerService customerService = new CustomerServiceImpl();

        if (customerService.register(customer)){
            response.getWriter().print("0");
        }
        else {
            response.getWriter().print("1");
        }

    }
}