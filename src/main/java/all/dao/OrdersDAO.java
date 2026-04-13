package all.dao;

import java.util.List;


import all.model.Order;

public interface OrdersDAO {
		int saveOrder(double amount,double rating);
		
		String saveOrderItems(int orderId,int[] itemId,int[] quantity,double[] price);
		
		List<Order> getAllOrders();
		
		Order getSpecificOrder(int orderId);
}
