package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmazonGetOrdersResponseBean {
	
	private List<ApiError> errors;

    public List<ApiError> getErrors() {
        return errors;
    }

    public void setErrors(List<ApiError> errors) {
        this.errors = errors;
    }

    public static class ApiError {
        private String code;
        private String message;
        private String details;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {
        private List<Order> Orders;
        private String nextToken;
        public String getNextToken() {
            return nextToken;
        }

        public void setNextToken(String nextToken) {
            this.nextToken = nextToken;
        }
        private String CreatedBefore;

        public List<Order> getOrders() {
            return Orders;
        }

        public void setOrders(List<Order> orders) {
            this.Orders = orders;
        }

        public String getCreatedBefore() {
            return CreatedBefore;
        }

        public void setCreatedBefore(String createdBefore) {
            this.CreatedBefore = createdBefore;
        }
    }

    public static class Order {
        private BuyerInfo BuyerInfo;
        private String AmazonOrderId;
        private String EarliestDeliveryDate;
        private String EarliestShipDate;
        private String SalesChannel;
        private AutomatedShippingSettings AutomatedShippingSettings;
        private String OrderStatus;
        private int NumberOfItemsShipped;
        private String OrderType;
        private boolean IsPremiumOrder;
        private boolean IsPrime;
        private String FulfillmentChannel;
        private int NumberOfItemsUnshipped;
        private boolean HasRegulatedItems;
        private String IsReplacementOrder;
        private boolean IsSoldByAB;
        private String LatestShipDate;
        private String ShipServiceLevel;
        private Address DefaultShipFromLocationAddress;
        private boolean IsISPU;
        private String MarketplaceId;
        private String LatestDeliveryDate;
        private String PurchaseDate;
        private ShippingAddress ShippingAddress;
        private boolean IsAccessPointOrder;
        private String PaymentMethod;
        private boolean IsBusinessOrder;
        private Amount OrderTotal;
        private String EasyShipShipmentStatus;
        private List<String> PaymentMethodDetails;
        private boolean IsGlobalExpressEnabled;
        private String LastUpdateDate;
        private String ShipmentServiceLevelCategory;
        private List<PaymentExecutionDetail> PaymentExecutionDetail;

        // Getters and setters for all fields

        // -- Example getter and setter (repeat for all fields) --
        public BuyerInfo getBuyerInfo() {
            return BuyerInfo;
        }

        public String getEarliestShipDate() {
			return EarliestShipDate;
		}

		public void setEarliestShipDate(String earliestShipDate) {
			EarliestShipDate = earliestShipDate;
		}

		public String getSalesChannel() {
			return SalesChannel;
		}

		public void setSalesChannel(String salesChannel) {
			SalesChannel = salesChannel;
		}

		public AutomatedShippingSettings getAutomatedShippingSettings() {
			return AutomatedShippingSettings;
		}

		public void setAutomatedShippingSettings(AutomatedShippingSettings automatedShippingSettings) {
			AutomatedShippingSettings = automatedShippingSettings;
		}

		public String getOrderStatus() {
			return OrderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			OrderStatus = orderStatus;
		}

		public int getNumberOfItemsShipped() {
			return NumberOfItemsShipped;
		}

		public void setNumberOfItemsShipped(int numberOfItemsShipped) {
			NumberOfItemsShipped = numberOfItemsShipped;
		}

		public String getOrderType() {
			return OrderType;
		}

		public void setOrderType(String orderType) {
			OrderType = orderType;
		}

		public boolean isIsPremiumOrder() {
			return IsPremiumOrder;
		}

		public void setIsPremiumOrder(boolean isPremiumOrder) {
			IsPremiumOrder = isPremiumOrder;
		}

		public boolean isIsPrime() {
			return IsPrime;
		}

		public void setIsPrime(boolean isPrime) {
			IsPrime = isPrime;
		}

		public String getFulfillmentChannel() {
			return FulfillmentChannel;
		}

		public void setFulfillmentChannel(String fulfillmentChannel) {
			FulfillmentChannel = fulfillmentChannel;
		}

		public int getNumberOfItemsUnshipped() {
			return NumberOfItemsUnshipped;
		}

		public void setNumberOfItemsUnshipped(int numberOfItemsUnshipped) {
			NumberOfItemsUnshipped = numberOfItemsUnshipped;
		}

		public boolean isHasRegulatedItems() {
			return HasRegulatedItems;
		}

		public void setHasRegulatedItems(boolean hasRegulatedItems) {
			HasRegulatedItems = hasRegulatedItems;
		}

		public String getIsReplacementOrder() {
			return IsReplacementOrder;
		}

		public void setIsReplacementOrder(String isReplacementOrder) {
			IsReplacementOrder = isReplacementOrder;
		}

		public boolean isIsSoldByAB() {
			return IsSoldByAB;
		}

		public void setIsSoldByAB(boolean isSoldByAB) {
			IsSoldByAB = isSoldByAB;
		}

		public String getLatestShipDate() {
			return LatestShipDate;
		}

		public void setLatestShipDate(String latestShipDate) {
			LatestShipDate = latestShipDate;
		}

		public String getShipServiceLevel() {
			return ShipServiceLevel;
		}

		public void setShipServiceLevel(String shipServiceLevel) {
			ShipServiceLevel = shipServiceLevel;
		}

		public Address getDefaultShipFromLocationAddress() {
			return DefaultShipFromLocationAddress;
		}

		public void setDefaultShipFromLocationAddress(Address defaultShipFromLocationAddress) {
			DefaultShipFromLocationAddress = defaultShipFromLocationAddress;
		}

		public boolean isIsISPU() {
			return IsISPU;
		}

		public void setIsISPU(boolean isISPU) {
			IsISPU = isISPU;
		}

		public String getMarketplaceId() {
			return MarketplaceId;
		}

		public void setMarketplaceId(String marketplaceId) {
			MarketplaceId = marketplaceId;
		}

		public String getLatestDeliveryDate() {
			return LatestDeliveryDate;
		}

		public void setLatestDeliveryDate(String latestDeliveryDate) {
			LatestDeliveryDate = latestDeliveryDate;
		}

		public String getPurchaseDate() {
			return PurchaseDate;
		}

		public void setPurchaseDate(String purchaseDate) {
			PurchaseDate = purchaseDate;
		}

		public ShippingAddress getShippingAddress() {
			return ShippingAddress;
		}

		public void setShippingAddress(ShippingAddress shippingAddress) {
			ShippingAddress = shippingAddress;
		}

		public boolean isIsAccessPointOrder() {
			return IsAccessPointOrder;
		}

		public void setIsAccessPointOrder(boolean isAccessPointOrder) {
			IsAccessPointOrder = isAccessPointOrder;
		}

		public String getPaymentMethod() {
			return PaymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			PaymentMethod = paymentMethod;
		}

		public boolean isIsBusinessOrder() {
			return IsBusinessOrder;
		}

		public void setIsBusinessOrder(boolean isBusinessOrder) {
			IsBusinessOrder = isBusinessOrder;
		}

		public Amount getOrderTotal() {
			return OrderTotal;
		}

		public void setOrderTotal(Amount orderTotal) {
			OrderTotal = orderTotal;
		}

		public String getEasyShipShipmentStatus() {
			return EasyShipShipmentStatus;
		}

		public void setEasyShipShipmentStatus(String easyShipShipmentStatus) {
			EasyShipShipmentStatus = easyShipShipmentStatus;
		}

		public List<String> getPaymentMethodDetails() {
			return PaymentMethodDetails;
		}

		public void setPaymentMethodDetails(List<String> paymentMethodDetails) {
			PaymentMethodDetails = paymentMethodDetails;
		}

		public boolean isIsGlobalExpressEnabled() {
			return IsGlobalExpressEnabled;
		}

		public void setIsGlobalExpressEnabled(boolean isGlobalExpressEnabled) {
			IsGlobalExpressEnabled = isGlobalExpressEnabled;
		}

		public String getLastUpdateDate() {
			return LastUpdateDate;
		}

		public void setLastUpdateDate(String lastUpdateDate) {
			LastUpdateDate = lastUpdateDate;
		}

		public String getShipmentServiceLevelCategory() {
			return ShipmentServiceLevelCategory;
		}

		public void setShipmentServiceLevelCategory(String shipmentServiceLevelCategory) {
			ShipmentServiceLevelCategory = shipmentServiceLevelCategory;
		}

		public List<PaymentExecutionDetail> getPaymentExecutionDetail() {
			return PaymentExecutionDetail;
		}

		public void setPaymentExecutionDetail(List<PaymentExecutionDetail> paymentExecutionDetail) {
			PaymentExecutionDetail = paymentExecutionDetail;
		}

		public void setBuyerInfo(BuyerInfo buyerInfo) {
            this.BuyerInfo = buyerInfo;
        }

        public String getAmazonOrderId() {
            return AmazonOrderId;
        }

        public void setAmazonOrderId(String amazonOrderId) {
            this.AmazonOrderId = amazonOrderId;
        }

        public String getEarliestDeliveryDate() {
            return EarliestDeliveryDate;
        }

        public void setEarliestDeliveryDate(String earliestDeliveryDate) {
            this.EarliestDeliveryDate = earliestDeliveryDate;
        }

        // Add remaining getters/setters similarly...
    }

    public static class BuyerInfo {
        private String BuyerEmail;

        public String getBuyerEmail() {
            return BuyerEmail;
        }

        public void setBuyerEmail(String buyerEmail) {
            this.BuyerEmail = buyerEmail;
        }
    }

    public static class AutomatedShippingSettings {
        private boolean HasAutomatedShippingSettings;

        public boolean isHasAutomatedShippingSettings() {
            return HasAutomatedShippingSettings;
        }

        public void setHasAutomatedShippingSettings(boolean hasAutomatedShippingSettings) {
            this.HasAutomatedShippingSettings = hasAutomatedShippingSettings;
        }
    }

    public static class Address {
        private String AddressLine1;
        private String AddressLine2;
        private String StateOrRegion;
        private String PostalCode;
        private String City;
        private String CountryCode;
        private String Name;

        // Getters and setters
        public String getAddressLine1() {
            return AddressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.AddressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return AddressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.AddressLine2 = addressLine2;
        }

        public String getStateOrRegion() {
            return StateOrRegion;
        }

        public void setStateOrRegion(String stateOrRegion) {
            this.StateOrRegion = stateOrRegion;
        }

        public String getPostalCode() {
            return PostalCode;
        }

        public void setPostalCode(String postalCode) {
            this.PostalCode = postalCode;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            this.City = city;
        }

        public String getCountryCode() {
            return CountryCode;
        }

        public void setCountryCode(String countryCode) {
            this.CountryCode = countryCode;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }
    }

    public static class ShippingAddress {
        private String StateOrRegion;
        private String PostalCode;
        private String City;
        private String CountryCode;

        // Getters and setters
        public String getStateOrRegion() {
            return StateOrRegion;
        }

        public void setStateOrRegion(String stateOrRegion) {
            this.StateOrRegion = stateOrRegion;
        }

        public String getPostalCode() {
            return PostalCode;
        }

        public void setPostalCode(String postalCode) {
            this.PostalCode = postalCode;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            this.City = city;
        }

        public String getCountryCode() {
            return CountryCode;
        }

        public void setCountryCode(String countryCode) {
            this.CountryCode = countryCode;
        }
    }

    public static class Amount {
        private String CurrencyCode;
        private String Amount;

        public String getCurrencyCode() {
            return CurrencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.CurrencyCode = currencyCode;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String amount) {
            this.Amount = amount;
        }
    }

    public static class PaymentExecutionDetail {
        private Payment Payment;
        private String PaymentMethod;

        public Payment getPayment() {
            return Payment;
        }

        public void setPayment(Payment payment) {
            this.Payment = payment;
        }

        public String getPaymentMethod() {
            return PaymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.PaymentMethod = paymentMethod;
        }
    }

    public static class Payment {
        private String CurrencyCode;
        private String Amount;

        public String getCurrencyCode() {
            return CurrencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.CurrencyCode = currencyCode;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String amount) {
            this.Amount = amount;
        }
    }


}
