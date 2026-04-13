package all.dao;
import java.util.List;

import all.model.*;

public interface MenuItemDAO {
		boolean addItem(MenuItem item);
		
		List<MenuItem> getAllElements();
		
		MenuItem getElementById(int itemId);

	    boolean updateName(int itemId, String name);

	    boolean updateCategory(int itemId, String category);

	    boolean updatePrice(int itemId, Double price);
	    
		boolean deleteItem(int id);
}
