package com.bmp.bean.saleorder;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MeeshoOrderDetailsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public MeeshoOrderDetailsBean() {
		super();
	}
	
	private List<Orders> orders;
	public class Orders{
		private Integer quantity;
		private String status;
		private String orderId;
		
		private Vsku vsku;
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Vsku{
			private String vsku;
			public Vsku() {
				super();
			}
			public String getVsku() {
				return vsku;
			}
			public void setVsku(String vsku) {
				this.vsku = vsku;
			}
			
		}
		
		private String order_group_id;
		private String created_time;
		private String updated_time;
		
		private ShippingDetails shipping_details;
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class ShippingDetails{
			String awb;
			String carrier;
			String label_url;
			String invoice_url;
			public ShippingDetails() {
				super();
			}
			
			public String getAwb() {
				return awb;
			}
			public void setAwb(String awb) {
				this.awb = awb;
			}
			public String getCarrier() {
				return carrier;
			}
			public void setCarrier(String carrier) {
				this.carrier = carrier;
			}
			public String getLabel_url() {
				return label_url;
			}
			public void setLabel_url(String label_url) {
				this.label_url = label_url;
			}
			public String getInvoice_url() {
				return invoice_url;
			}
			public void setInvoice_url(String invoice_url) {
				this.invoice_url = invoice_url;
			}
			
		}
		
		private PriceDetails price_details;
		@JsonIgnoreProperties(ignoreUnknown = true)
		public  class PriceDetails{
			private Double mrp;
			private Double price;
			private String currency;
			private String cost_price_currency;
			private Double cost_price;
			
			public PriceDetails() {
				super();
			}
			public Double getMrp() {
				return mrp;
			}
			public void setMrp(Double mrp) {
				this.mrp = mrp;
			}
			public Double getPrice() {
				return price;
			}
			public void setPrice(Double price) {
				this.price = price;
			}
			public String getCurrency() {
				return currency;
			}
			public void setCurrency(String currency) {
				this.currency = currency;
			}
			public String getCost_price_currency() {
				return cost_price_currency;
			}
			public void setCost_price_currency(String cost_price_currency) {
				this.cost_price_currency = cost_price_currency;
			}
			public Double getCost_price() {
				return cost_price;
			}
			public void setCost_price(Double cost_price) {
				this.cost_price = cost_price;
			}
			
		}
		
		private Variation variation;
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Variation{
			private String name;
			
			public Variation() {
				super();
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
		}
		
		private Product product;
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Product{
			private String name;
			private String meesho_product_id;
			private List<String> image_urls;
			
			public Product() {
				super();
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public String getMeesho_product_id() {
				return meesho_product_id;
			}
			public void setMeesho_product_id(String meesho_product_id) {
				this.meesho_product_id = meesho_product_id;
			}
			public List<String> getImage_urls() {
				return image_urls;
			}
			public void setImage_urls(List<String> image_urls) {
				this.image_urls = image_urls;
			}
		}
		private String expected_dispatch_date;
		
		
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public Vsku getVsku() {
			return vsku;
		}
		public void setVsku(Vsku vsku) {
			this.vsku = vsku;
		}
		public String getOrder_group_id() {
			return order_group_id;
		}
		public void setOrder_group_id(String order_group_id) {
			this.order_group_id = order_group_id;
		}
		public String getCreated_time() {
			return created_time;
		}
		public void setCreated_time(String created_time) {
			this.created_time = created_time;
		}
		public String getUpdated_time() {
			return updated_time;
		}
		public void setUpdated_time(String updated_time) {
			this.updated_time = updated_time;
		}
		public ShippingDetails getShipping_details() {
			return shipping_details;
		}
		public void setShipping_details(ShippingDetails shipping_details) {
			this.shipping_details = shipping_details;
		}
		public PriceDetails getPrice_details() {
			return price_details;
		}
		public void setPrice_details(PriceDetails price_details) {
			this.price_details = price_details;
		}
		public Variation getVariation() {
			return variation;
		}
		public void setVariation(Variation variation) {
			this.variation = variation;
		}
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}
		public String getExpected_dispatch_date() {
			return expected_dispatch_date;
		}
		public void setExpected_dispatch_date(String expected_dispatch_date) {
			this.expected_dispatch_date = expected_dispatch_date;
		}
	}

	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	

}
