import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet",urlPatterns = "/converter")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Product_Description = request.getParameter("ProductDescription");
        float List_Price = Float.parseFloat(request.getParameter("ListPrice"));
        float Discount_Percent = Float.parseFloat(request.getParameter("DiscountPercent"));


        float Discount_Amount = List_Price * Discount_Percent / 100;
        float Discount_Price = List_Price - Discount_Amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: "+Product_Description+"</h1>");
        writer.println("<h1>List Price: " + List_Price + "</h1>");
        writer.println("<h1>Discount Percent: " + Discount_Percent + "%</h1>");
        writer.println("<h1>Discount Amount: " + Discount_Amount + "</h1>");
        writer.println("<h1>Discount Price: " + Discount_Price + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
