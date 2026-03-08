package com.bmp.model.app.api.jaxbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyFulfillmentResponse {
	private Data data;
    private Extensions extensions;

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public Extensions getExtensions() { return extensions; }
    public void setExtensions(Extensions extensions) { this.extensions = extensions; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private FulfillmentCreateV2 fulfillmentCreateV2;
        private FulfillmentEventCreate fulfillmentEventCreate;
        private List<UserError> userErrors;
        private OrderNode order; // Added for fetchAndSyncFulfillmentIds

        public FulfillmentCreateV2 getFulfillmentCreateV2() { return fulfillmentCreateV2; }
        public void setFulfillmentCreateV2(FulfillmentCreateV2 fulfillmentCreateV2) { this.fulfillmentCreateV2 = fulfillmentCreateV2; }

        public List<UserError> getUserErrors() { return userErrors; }
        public void setUserErrors(List<UserError> userErrors) { this.userErrors = userErrors; }

        public FulfillmentEventCreate getFulfillmentEventCreate() { return fulfillmentEventCreate; }
        public void setFulfillmentEventCreate(FulfillmentEventCreate fulfillmentEventCreate) { this.fulfillmentEventCreate = fulfillmentEventCreate; }

        public OrderNode getOrder() { return order; }
        public void setOrder(OrderNode order) { this.order = order; }
    }

    // --- Added for GraphQL Order Sync Logic ---
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderNode {
        private FulfillmentOrders fulfillmentOrders;
        public FulfillmentOrders getFulfillmentOrders() { return fulfillmentOrders; }
        public void setFulfillmentOrders(FulfillmentOrders fulfillmentOrders) { this.fulfillmentOrders = fulfillmentOrders; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentOrders {
        private List<FulfillmentOrderNode> nodes;
        public List<FulfillmentOrderNode> getNodes() { return nodes; }
        public void setNodes(List<FulfillmentOrderNode> nodes) { this.nodes = nodes; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentOrderNode {
        private String id;
        private LineItems lineItems;
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public LineItems getLineItems() { return lineItems; }
        public void setLineItems(LineItems lineItems) { this.lineItems = lineItems; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LineItems {
        private List<OrderLineItemNode> nodes;
        public List<OrderLineItemNode> getNodes() { return nodes; }
        public void setNodes(List<OrderLineItemNode> nodes) { this.nodes = nodes; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OrderLineItemNode {
        private String id;
        private String sku;
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getSku() { return sku; }
        public void setSku(String sku) { this.sku = sku; }
    }
    // --- End of Sync Logic Classes ---

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentCreateV2 {
        private Fulfillment fulfillment;
        private List<UserError> userErrors;

        public Fulfillment getFulfillment() { return fulfillment; }
        public void setFulfillment(Fulfillment fulfillment) { this.fulfillment = fulfillment; }

        public List<UserError> getUserErrors() { return userErrors; }
        public void setUserErrors(List<UserError> userErrors) { this.userErrors = userErrors; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserError {
        private List<String> field;
        private String message;
        public List<String> getField() { return field; }
        public void setField(List<String> field) { this.field = field; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Fulfillment {
        private String id;
        private String status;
        private List<TrackingInfo> trackingInfo;
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public List<TrackingInfo> getTrackingInfo() { return trackingInfo; }
        public void setTrackingInfo(List<TrackingInfo> trackingInfo) { this.trackingInfo = trackingInfo; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TrackingInfo {
        private String number;
        private String url;
        public String getNumber() { return number; }
        public void setNumber(String number) { this.number = number; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Extensions {
        private Cost cost;
        public Cost getCost() { return cost; }
        public void setCost(Cost cost) { this.cost = cost; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Cost {
        private int requestedQueryCost;
        private int actualQueryCost;
        private ThrottleStatus throttleStatus;
        public int getRequestedQueryCost() { return requestedQueryCost; }
        public void setRequestedQueryCost(int requestedQueryCost) { this.requestedQueryCost = requestedQueryCost; }
        public int getActualQueryCost() { return actualQueryCost; }
        public void setActualQueryCost(int actualQueryCost) { this.actualQueryCost = actualQueryCost; }
        public ThrottleStatus getThrottleStatus() { return throttleStatus; }
        public void setThrottleStatus(ThrottleStatus throttleStatus) { this.throttleStatus = throttleStatus; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ThrottleStatus {
        private double maximumAvailable;
        private int currentlyAvailable;
        private double restoreRate;
        public double getMaximumAvailable() { return maximumAvailable; }
        public void setMaximumAvailable(double maximumAvailable) { this.maximumAvailable = maximumAvailable; }
        public int getCurrentlyAvailable() { return currentlyAvailable; }
        public void setCurrentlyAvailable(int currentlyAvailable) { this.currentlyAvailable = currentlyAvailable; }
        public double getRestoreRate() { return restoreRate; }
        public void setRestoreRate(double restoreRate) { this.restoreRate = restoreRate; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentEventCreate {
        private FulfillmentEvent fulfillmentEvent;
        private List<UserError> userErrors;
        public FulfillmentEvent getFulfillmentEvent() { return fulfillmentEvent; }
        public void setFulfillmentEvent(FulfillmentEvent fulfillmentEvent) { this.fulfillmentEvent = fulfillmentEvent; }
        public List<UserError> getUserErrors() { return userErrors; }
        public void setUserErrors(List<UserError> userErrors) { this.userErrors = userErrors; }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FulfillmentEvent {
        private String id;
        private String status;
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }

}
