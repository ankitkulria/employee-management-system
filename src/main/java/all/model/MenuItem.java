package all.model;

public class MenuItem {
		private int itemId;
		private String itemName;
		private String itemCategory;
		private double itemPrice;
		private String imagePath;
		public MenuItem(){}
		MenuItem(String itemName,String itemCategory,double itemPrice)
		{
			this.itemName=itemName;
			this.itemCategory=itemCategory;
			this.itemPrice=itemPrice;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemCategory() {
			return itemCategory;
		}
		public void setItemCategory(String itemCategory) {
			this.itemCategory = itemCategory;
		}
		public double getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
		}
		@Override
		public String toString() {
			return "MenuItem [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory
					+ ", itemPrice=" + itemPrice + "]";
		}
		public String getImagePath() {
			return imagePath;
		}
		public void setImagePath(String imagePath) {
			this.imagePath = imagePath;
		}
		
}
