package servlet.products;

import bean.product.Product;
import com.google.gson.Gson;
import dao.product.ProductDAO;
import dao.product.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "HandServlet",
        urlPatterns = {"/Hand"}
)
public class HandServlet extends HttpServlet {
    private static final String CUSTOMER_URL = "WEB-INF/jsp/products/Hand.jsp";
    private static final String SUGARICE_URL = "Sugarice";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        if (account == null) {
            response.sendRedirect("Login");
            return;
        }
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> hand = productDAO.getBoutique();
        String handJson = new Gson().toJson(hand);
        request.setAttribute("json", handJson);

        request.getRequestDispatcher(CUSTOMER_URL).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String productName = request.getParameter("productName");
        session.setAttribute("ProductName", productName);
    }
}
