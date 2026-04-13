package all.filters;

import jakarta.servlet.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/EmployeeRegister")
public class EmpRegFilter extends HttpFilter implements Filter {
 
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String name=request.getParameter("name").trim();
		String role=request.getParameter("role").trim();
		String phone=request.getParameter("phone").trim();
		Double salary=Double.parseDouble(request.getParameter("salary"));
		String gender=request.getParameter("gender").trim();
		String isMarried=request.getParameter("isMarried").trim();
		String email=request.getParameter("email").trim();
		String password=request.getParameter("password").trim();
		
		if(name==null || name.isBlank() || role==null || role.isBlank() || phone==null || phone.isBlank() || salary<=0 
				|| gender==null || gender.isBlank() ||isMarried==null || isMarried.isBlank() || email==null || email.isBlank()
				|| password==null || password.isBlank())
		{
			request.setAttribute("errMsg", "Fill up the Mandtory Fields");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);

	}
}
