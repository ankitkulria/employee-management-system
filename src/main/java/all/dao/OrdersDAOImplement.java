package all.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import all.model.Order;
import all.model.OrderItem;
import all.util.DBConnection;

public class OrdersDAOImplement implements OrdersDAO{

	@Override
	public int saveOrder(double amount, double rating) {
		String query="INSERT INTO orders(amount,rating) VALUES(?,?)";
		int generatedOrderId=0;
		
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
		{
			ps.setDouble(1,amount);
			ps.setDouble(2,rating);
			ps.executeUpdate();
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next())
				generatedOrderId=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return generatedOrderId;
	}

	@Override
	public String saveOrderItems(int orderId, int[] itemId, int[] quantity, double[] price) {
		String query="INSERT INTO order_items(order_id,item_id,quantity,price) VALUES(?,?,?,?)";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			for(int i=0;i<itemId.length;i++)
			{
				ps.setInt(1, orderId);
				ps.setInt(2, itemId[i]);
				ps.setInt(3, quantity[i]);
				ps.setDouble(4, price[i]);
				
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Done";
	}

	@Override
	public List<Order> getAllOrders() 
	{
		List<Order> orders=new ArrayList<>();
		
		String query="SELECT * FROM orders";
		
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery())
		{
			while(rs.next())
			{
				Order order=new Order();
				try {
					order.setOrderId(rs.getInt("order_id"));
					order.setOrderTime(rs.getTimestamp("order_time").toLocalDateTime());
					order.setAmount(rs.getDouble("amount"));
					order.setRating(rs.getDouble("rating"));
					
					orders.add(order);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return orders;
	}

	@Override
	public Order getSpecificOrder(int orderId) {

	    Order order = null;

	    // 1️⃣ Fetch order header
	    String orderSql =
	            "SELECT * " +
	            "FROM orders WHERE order_id = ?";

	    // 2️⃣ Fetch order items with item names
	    String itemsSql =
	            "SELECT m.item_name, oi.quantity, oi.price " +
	            "FROM order_items oi " +
	            "JOIN menu_items m ON oi.item_id = m.item_id " +
	            "WHERE oi.order_id = ?";

	    try (Connection con = DBConnection.getConnection()) {

	        // -------- ORDER HEADER --------
	        try (PreparedStatement ps = con.prepareStatement(orderSql)) {
	            ps.setInt(1, orderId);

	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    order = new Order();
	                    order.setOrderId(rs.getInt("order_id"));
	                    order.setOrderTime(rs.getTimestamp("order_time").toLocalDateTime());
	                    order.setAmount(rs.getDouble("final_amount"));
	                    order.setRating(rs.getInt("rating"));
	                } else {
	                    return null; // order not found
	                }
	            }
	        }

	        // -------- ORDER ITEMS --------
	        List<OrderItem> items = new ArrayList<>();

	        try (PreparedStatement ps = con.prepareStatement(itemsSql)) {
	            ps.setInt(1, orderId);

	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {

	                    OrderItem item = new OrderItem();
	                    item.setItemName(rs.getString("item_name"));
	                    item.setQuantity(rs.getInt("quantity"));
	                    item.setPrice(rs.getDouble("price"));
	                    item.setAmount(item.getPrice() * item.getQuantity());

	                    items.add(item);
	                }
	            }
	        }

	        order.setItems(items);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    return order;
	}
}
