package all.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
		private int orderId;
		private LocalDateTime orderTime;
		private double amount;
		private double rating;
		private List<OrderItem> items;
		public Order(){}
		public Order(int orderId, LocalDateTime orderTime, double amount, double rating) {
			super();
			this.orderId = orderId;
			this.orderTime = orderTime;
			this.amount = amount;
			this.rating = rating;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public LocalDateTime getOrderTime() {
			return orderTime;
		}
		public void setOrderTime(LocalDateTime orderTime) {
			this.orderTime = orderTime;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public double getRating() {
			return rating;
		}
		public void setRating(double rating) {
			this.rating = rating;
		}
		public List<OrderItem> getItems() {
			return items;
		}
		public void setItems(List<OrderItem> items) {
			this.items = items;
		}
		
}
