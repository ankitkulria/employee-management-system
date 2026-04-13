<%
				String msg=(String)request.getAttribute("err");
				if(msg!=null)
				{
				%>
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
  				<strong><%= msg %></strong> 
  				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
<%
					
					request.removeAttribute("errMsg");
				} 
				else 
				{
					String success=(String)request.getAttribute("success");
					if(success!=null)
					{
					%>
					
					<div class="alert alert-warning alert-dismissible fade show" role="alert">
					  <strong><%= success %></strong>
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
					<%
					request.removeAttribute("errMsg");
					}
				}
%>