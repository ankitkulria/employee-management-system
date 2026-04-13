package all.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import all.model.MenuItem;
import all.util.DBConnection;

public class MenuItemDAOImplement implements MenuItemDAO{

	@Override
	public boolean addItem(MenuItem item) {
		String query="INSERT INTO menu_items (item_name,category,price) VALUES(?,?,?)";
		try( Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1, item.getItemName());
			ps.setString(2, item.getItemCategory());
			ps.setDouble(3, item.getItemPrice());
			int rowsAffected=ps.executeUpdate();
			return rowsAffected>0;
		} catch (SQLException e) {
			System.out.println("Something went wrong");	
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public List<MenuItem> getAllElements() {
		List<MenuItem> items=new ArrayList<>();
		String query="SELECT * FROM menu_items";
		
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery())
		{
			while(rs.next())
			{
				MenuItem item=new MenuItem();
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemCategory(rs.getString("category"));
				item.setItemPrice(rs.getDouble("price"));
				item.setImagePath(rs.getString("image_path"));

				
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return items;
	}

	@Override
	public MenuItem getElementById(int itemId) {
		String query="SELECT * FROM menu_items WHERE item_id=?";
		try( Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
				)
		{
			ps.setInt(1,itemId);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				MenuItem item=new MenuItem();
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemCategory(rs.getString("category"));
				item.setItemPrice(rs.getDouble("price"));
				return item;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateName(int itemId, String newname) 
	{
		String query="UPDATE menu_items SET item_name=? WHERE item_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1,newname);
			ps.setInt(2, itemId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateCategory(int itemId,String newCategory)
	{
		String query="UPDATE menu_items SET category=? WHERE item_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setString(1,newCategory);
			ps.setInt(2, itemId);
			return ps.executeUpdate()==1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
    @Override
    public boolean updatePrice(int itemId, Double newPrice) {

        String sql = "UPDATE menu_items SET price = ? WHERE item_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, newPrice);
            ps.setInt(2, itemId);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return false;
    }


	@Override
	public boolean deleteItem(int id) {
		String query="DELETE FROM menu_items WHERE item_id=?";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(query))
		{
			ps.setInt(1, id);
			int deleted=ps.executeUpdate();
			if(deleted==1)
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
		
}
