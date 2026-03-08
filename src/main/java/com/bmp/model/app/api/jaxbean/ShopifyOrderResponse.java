package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyOrderResponse {
	private Data data;
    private Extensions extensions;
    private Object errors;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private Orders orders;

        public Orders getOrders() {
            return orders;
        }

        public void setOrders(Orders orders) {
            this.orders = orders;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Orders {
        private List<OrderNode> nodes;
        private PageInfo pageInfo;

        public List<OrderNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<OrderNode> nodes) {
            this.nodes = nodes;
        }

        public PageInfo getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfo pageInfo) {
            this.pageInfo = pageInfo;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderNode {
        private String id;
        private String name;
        private String displayFulfillmentStatus;
        private String displayFinancialStatus;
        private boolean closed;
        private String createdAt;
        private String totalPrice;
        private String totalReceived;
        private boolean fulfillable;
        private boolean unpaid;
        private FulfillmentOrders fulfillmentOrders;
        private List<Transaction> transactions;
        private OriginalTotalPriceSet originalTotalPriceSet;
        private LineItems lineItems;
        private Address billingAddress;
        private Address shippingAddress;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDisplayFulfillmentStatus() {
            return displayFulfillmentStatus;
        }

        public void setDisplayFulfillmentStatus(String displayFulfillmentStatus) {
            this.displayFulfillmentStatus = displayFulfillmentStatus;
        }

        public String getDisplayFinancialStatus() {
            return displayFinancialStatus;
        }

        public void setDisplayFinancialStatus(String displayFinancialStatus) {
            this.displayFinancialStatus = displayFinancialStatus;
        }

        public boolean isClosed() {
            return closed;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getTotalReceived() {
            return totalReceived;
        }

        public void setTotalReceived(String totalReceived) {
            this.totalReceived = totalReceived;
        }

        public boolean isFulfillable() {
            return fulfillable;
        }

        public void setFulfillable(boolean fulfillable) {
            this.fulfillable = fulfillable;
        }

        public boolean isUnpaid() {
            return unpaid;
        }

        public void setUnpaid(boolean unpaid) {
            this.unpaid = unpaid;
        }

        public FulfillmentOrders getFulfillmentOrders() {
            return fulfillmentOrders;
        }

        public void setFulfillmentOrders(FulfillmentOrders fulfillmentOrders) {
            this.fulfillmentOrders = fulfillmentOrders;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
        }

        public OriginalTotalPriceSet getOriginalTotalPriceSet() {
            return originalTotalPriceSet;
        }

        public void setOriginalTotalPriceSet(OriginalTotalPriceSet originalTotalPriceSet) {
            this.originalTotalPriceSet = originalTotalPriceSet;
        }

        public LineItems getLineItems() {
            return lineItems;
        }

        public void setLineItems(LineItems lineItems) {
            this.lineItems = lineItems;
        }

        public Address getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
        }

        public Address getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address {
        private String name;
        private String firstName;
        private String lastName;
        private Double latitude;
        private Double longitude;
        private String phone;
        private String city;
        private String address1;
        private String address2;
        private String zip;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentOrders {
        private List<FulfillmentOrderNode> nodes;

        public List<FulfillmentOrderNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<FulfillmentOrderNode> nodes) {
            this.nodes = nodes;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentOrderNode {
        private String id;
        private String status;
        private OrderLineItems lineItems;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

		public OrderLineItems getLineItems() {
			return lineItems;
		}

		public void setLineItems(OrderLineItems lineItems) {
			this.lineItems = lineItems;
		}

        
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Transaction {
        private String gateway;
        private AmountSet amountSet;

        public String getGateway() {
            return gateway;
        }

        public void setGateway(String gateway) {
            this.gateway = gateway;
        }

        public AmountSet getAmountSet() {
            return amountSet;
        }

        public void setAmountSet(AmountSet amountSet) {
            this.amountSet = amountSet;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AmountSet {
        private ShopMoney shopMoney;

        public ShopMoney getShopMoney() {
            return shopMoney;
        }

        public void setShopMoney(ShopMoney shopMoney) {
            this.shopMoney = shopMoney;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ShopMoney {
        private String amount;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OriginalTotalPriceSet {
        private ShopMoney shopMoney;

        public ShopMoney getShopMoney() {
            return shopMoney;
        }

        public void setShopMoney(ShopMoney shopMoney) {
            this.shopMoney = shopMoney;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LineItems {
        private List<LineItemNode> nodes;

        public List<LineItemNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<LineItemNode> nodes) {
            this.nodes = nodes;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderLineItems {
        private List<OrderLineItemNode> nodes;

        public List<OrderLineItemNode> getNodes() {
            return nodes;
        }

        public void setNodes(List<OrderLineItemNode> nodes) {
            this.nodes = nodes;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LineItemNode {
        private String id;
        private String name;
        private String sku;
        private int quantity;
        private int nonFulfillableQuantity;
        private int unfulfilledQuantity;
        private String discountedUnitPrice;
        private OriginalUnitPriceSet originalUnitPriceSet;
        private List<TaxLines> taxLines;
        private FulfillmentService fulfillmentService;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSku() {
			return sku;
		}
		public void setSku(String sku) {
			this.sku = sku;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getNonFulfillableQuantity() {
			return nonFulfillableQuantity;
		}
		public void setNonFulfillableQuantity(int nonFulfillableQuantity) {
			this.nonFulfillableQuantity = nonFulfillableQuantity;
		}
		public int getUnfulfilledQuantity() {
			return unfulfilledQuantity;
		}
		public void setUnfulfilledQuantity(int unfulfilledQuantity) {
			this.unfulfilledQuantity = unfulfilledQuantity;
		}
		public FulfillmentService getFulfillmentService() {
			return fulfillmentService;
		}
		public void setFulfillmentService(FulfillmentService fulfillmentService) {
			this.fulfillmentService = fulfillmentService;
		}
		public String getDiscountedUnitPrice() {
			return discountedUnitPrice;
		}
		public void setDiscountedUnitPrice(String discountedUnitPrice) {
			this.discountedUnitPrice = discountedUnitPrice;
		}
		public OriginalUnitPriceSet getOriginalUnitPriceSet() {
			return originalUnitPriceSet;
		}
		public void setOriginalUnitPriceSet(OriginalUnitPriceSet originalUnitPriceSet) {
			this.originalUnitPriceSet = originalUnitPriceSet;
		}
		public List<TaxLines> getTaxLines() {
			return taxLines;
		}
		public void setTaxLines(List<TaxLines> taxLines) {
			this.taxLines = taxLines;
		}
		
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderLineItemNode {
        private String id;
        private String sku;
        private Integer totalQuantity;
        private Integer remainingQuantity;
        private String inventoryItemId;
        private Weight weight;
        private Image image;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getSku() {
			return sku;
		}
		public void setSku(String sku) {
			this.sku = sku;
		}
		public Integer getTotalQuantity() {
			return totalQuantity;
		}
		public void setTotalQuantity(Integer totalQuantity) {
			this.totalQuantity = totalQuantity;
		}
		public Integer getRemainingQuantity() {
			return remainingQuantity;
		}
		public void setRemainingQuantity(Integer remainingQuantity) {
			this.remainingQuantity = remainingQuantity;
		}
		public String getInventoryItemId() {
			return inventoryItemId;
		}
		public void setInventoryItemId(String inventoryItemId) {
			this.inventoryItemId = inventoryItemId;
		}
		public Weight getWeight() {
			return weight;
		}
		public void setWeight(Weight weight) {
			this.weight = weight;
		}
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}
		
		
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weight {
        private String unit;
        private double value;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Image {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OriginalUnitPriceSet {
    	private ShopMoney shopMoney;

		public ShopMoney getShopMoney() {
			return shopMoney;
		}

		public void setShopMoney(ShopMoney shopMoney) {
			this.shopMoney = shopMoney;
		}
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TaxLines {
    	private Double ratePercentage;

		public Double getRatePercentage() {
			return ratePercentage;
		}
		public void setRatePercentage(Double ratePercentage) {
			this.ratePercentage = ratePercentage;
		}
    	
    }
    
    
    
    
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentService {
        private Location location;

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {
        private String name;
        private Address address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageInfo {
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private String startCursor;
        private String endCursor;

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public String getStartCursor() {
            return startCursor;
        }

        public void setStartCursor(String startCursor) {
            this.startCursor = startCursor;
        }

        public String getEndCursor() {
            return endCursor;
        }

        public void setEndCursor(String endCursor) {
            this.endCursor = endCursor;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Extensions {
        private Cost cost;

        public Cost getCost() {
            return cost;
        }

        public void setCost(Cost cost) {
            this.cost = cost;
        }

        public static class Cost {
            private int requestedQueryCost;
            private int actualQueryCost;
            private ThrottleStatus throttleStatus;

            public int getRequestedQueryCost() {
                return requestedQueryCost;
            }

            public void setRequestedQueryCost(int requestedQueryCost) {
                this.requestedQueryCost = requestedQueryCost;
            }

            public int getActualQueryCost() {
                return actualQueryCost;
            }

            public void setActualQueryCost(int actualQueryCost) {
                this.actualQueryCost = actualQueryCost;
            }

            public ThrottleStatus getThrottleStatus() {
                return throttleStatus;
            }

            public void setThrottleStatus(ThrottleStatus throttleStatus) {
                this.throttleStatus = throttleStatus;
            }

            public static class ThrottleStatus {
                private double maximumAvailable;
                private double currentlyAvailable;
                private double restoreRate;
				public double getMaximumAvailable() {
					return maximumAvailable;
				}
				public void setMaximumAvailable(double maximumAvailable) {
					this.maximumAvailable = maximumAvailable;
				}
				public double getCurrentlyAvailable() {
					return currentlyAvailable;
				}
				public void setCurrentlyAvailable(double currentlyAvailable) {
					this.currentlyAvailable = currentlyAvailable;
				}
				public double getRestoreRate() {
					return restoreRate;
				}
				public void setRestoreRate(double restoreRate) {
					this.restoreRate = restoreRate;
				}
                
            }
        }
    }
}
