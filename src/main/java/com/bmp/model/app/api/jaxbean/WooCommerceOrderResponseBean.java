package com.bmp.model.app.api.jaxbean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WooCommerceOrderResponseBean {

        private Long id;

        @JsonProperty("parent_id")
        private Long parentId;

        private String status;
        private String currency;
        private String version;

        @JsonProperty("prices_include_tax")
        private Boolean pricesIncludeTax;

        @JsonProperty("date_created")
        private String dateCreated;

        @JsonProperty("date_modified")
        private String dateModified;

        @JsonProperty("discount_total")
        private String discountTotal;

        @JsonProperty("discount_tax")
        private String discountTax;

        @JsonProperty("shipping_total")
        private String shippingTotal;

        @JsonProperty("shipping_tax")
        private String shippingTax;

        @JsonProperty("cart_tax")
        private String cartTax;

        private String total;

        @JsonProperty("total_tax")
        private String totalTax;

        @JsonProperty("customer_id")
        private Long customerId;

        @JsonProperty("order_key")
        private String orderKey;

        private Address billing;
        private Address shipping;

        @JsonProperty("payment_method")
        private String paymentMethod;

        @JsonProperty("payment_method_title")
        private String paymentMethodTitle;

        @JsonProperty("transaction_id")
        private String transactionId;

        @JsonProperty("customer_ip_address")
        private String customerIpAddress;

        @JsonProperty("customer_user_agent")
        private String customerUserAgent;

        @JsonProperty("created_via")
        private String createdVia;

        @JsonProperty("customer_note")
        private String customerNote;

        @JsonProperty("date_completed")
        private String dateCompleted;

        @JsonProperty("date_paid")
        private String datePaid;

        @JsonProperty("cart_hash")
        private String cartHash;

        private String number;

        @JsonProperty("meta_data")
        private List<MetaData> metaData;

        @JsonProperty("line_items")
        private List<LineItem> lineItems;

        @JsonProperty("tax_lines")
        private List<TaxLine> taxLines;

        @JsonProperty("shipping_lines")
        private List<ShippingLine> shippingLines;

        @JsonProperty("fee_lines")
        private List<FeeLine> feeLines;

        @JsonProperty("coupon_lines")
        private List<CouponLine> couponLines;

        private List<Refund> refunds;

        @JsonProperty("payment_url")
        private String paymentUrl;

        @JsonProperty("is_editable")
        private Boolean isEditable;

        @JsonProperty("needs_payment")
        private Boolean needsPayment;

        @JsonProperty("needs_processing")
        private Boolean needsProcessing;

        @JsonProperty("date_created_gmt")
        private String dateCreatedGmt;

        @JsonProperty("date_modified_gmt")
        private String dateModifiedGmt;

        @JsonProperty("date_completed_gmt")
        private String dateCompletedGmt;

        @JsonProperty("date_paid_gmt")
        private String datePaidGmt;

        @JsonProperty("currency_symbol")
        private String currencySymbol;

        @JsonProperty("_links")
        private Map<String, List<Link>> links;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getPricesIncludeTax() {
        return pricesIncludeTax;
    }

    public void setPricesIncludeTax(Boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    public String getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public String getCartTax() {
        return cartTax;
    }

    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public Address getBilling() {
        return billing;
    }

    public void setBilling(Address billing) {
        this.billing = billing;
    }

    public Address getShipping() {
        return shipping;
    }

    public void setShipping(Address shipping) {
        this.shipping = shipping;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getCreatedVia() {
        return createdVia;
    }

    public void setCreatedVia(String createdVia) {
        this.createdVia = createdVia;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public String getCartHash() {
        return cartHash;
    }

    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<MetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<MetaData> metaData) {
        this.metaData = metaData;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<TaxLine> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<TaxLine> taxLines) {
        this.taxLines = taxLines;
    }

    public List<ShippingLine> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(List<ShippingLine> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public List<FeeLine> getFeeLines() {
        return feeLines;
    }

    public void setFeeLines(List<FeeLine> feeLines) {
        this.feeLines = feeLines;
    }

    public List<CouponLine> getCouponLines() {
        return couponLines;
    }

    public void setCouponLines(List<CouponLine> couponLines) {
        this.couponLines = couponLines;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        this.refunds = refunds;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public Boolean getEditable() {
        return isEditable;
    }

    public void setEditable(Boolean editable) {
        isEditable = editable;
    }

    public Boolean getNeedsPayment() {
        return needsPayment;
    }

    public void setNeedsPayment(Boolean needsPayment) {
        this.needsPayment = needsPayment;
    }

    public Boolean getNeedsProcessing() {
        return needsProcessing;
    }

    public void setNeedsProcessing(Boolean needsProcessing) {
        this.needsProcessing = needsProcessing;
    }

    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public String getDateCompletedGmt() {
        return dateCompletedGmt;
    }

    public void setDateCompletedGmt(String dateCompletedGmt) {
        this.dateCompletedGmt = dateCompletedGmt;
    }

    public String getDatePaidGmt() {
        return datePaidGmt;
    }

    public void setDatePaidGmt(String datePaidGmt) {
        this.datePaidGmt = datePaidGmt;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Map<String, List<Link>> getLinks() {
        return links;
    }

    public void setLinks(Map<String, List<Link>> links) {
        this.links = links;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Address {
        @JsonProperty("first_name")
        private String firstName;
        @JsonProperty("last_name")
        private String lastName;
        private String company;
        @JsonProperty("address_1")
        private String address1;
        @JsonProperty("address_2")
        private String address2;
        private String city;
        private String state;
        private String postcode;
        private String country;
        private String email;
        private String phone;

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

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class LineItem {
        private Long id;
        private String name;

        @JsonProperty("product_id")
        private Long productId;

        @JsonProperty("variation_id")
        private Long variationId;

        private Integer quantity;

        @JsonProperty("tax_class")
        private String taxClass;

        private String subtotal;

        @JsonProperty("subtotal_tax")
        private String subtotalTax;

        private String total;

        @JsonProperty("total_tax")
        private String totalTax;

        private List<Object> taxes;

        @JsonProperty("meta_data")
        private List<MetaData> metaData;

        private String sku;
        @JsonProperty("global_unique_id")
        private String globalUniqueId;
        private Double price;
        private Image image;
        @JsonProperty("parent_name")
        private String parentName;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Long getVariationId() {
            return variationId;
        }

        public void setVariationId(Long variationId) {
            this.variationId = variationId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getTaxClass() {
            return taxClass;
        }

        public void setTaxClass(String taxClass) {
            this.taxClass = taxClass;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getSubtotalTax() {
            return subtotalTax;
        }

        public void setSubtotalTax(String subtotalTax) {
            this.subtotalTax = subtotalTax;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotalTax() {
            return totalTax;
        }

        public void setTotalTax(String totalTax) {
            this.totalTax = totalTax;
        }

        public List<Object> getTaxes() {
            return taxes;
        }

        public void setTaxes(List<Object> taxes) {
            this.taxes = taxes;
        }

        public List<MetaData> getMetaData() {
            return metaData;
        }

        public void setMetaData(List<MetaData> metaData) {
            this.metaData = metaData;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getGlobalUniqueId() {
            return globalUniqueId;
        }

        public void setGlobalUniqueId(String globalUniqueId) {
            this.globalUniqueId = globalUniqueId;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ShippingLine {

        private Long id;

        @JsonProperty("method_title")
        private String methodTitle;

        @JsonProperty("method_id")
        private String methodId;

        @JsonProperty("instance_id")
        private String instanceId;

        private String total;

        @JsonProperty("total_tax")
        private String totalTax;

        private List<Object> taxes;

        @JsonProperty("tax_status")
        private String taxStatus;

        @JsonProperty("meta_data")
        private List<MetaData> metaData;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getMethodTitle() {
            return methodTitle;
        }

        public void setMethodTitle(String methodTitle) {
            this.methodTitle = methodTitle;
        }

        public String getMethodId() {
            return methodId;
        }

        public void setMethodId(String methodId) {
            this.methodId = methodId;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotalTax() {
            return totalTax;
        }

        public void setTotalTax(String totalTax) {
            this.totalTax = totalTax;
        }

        public List<Object> getTaxes() {
            return taxes;
        }

        public void setTaxes(List<Object> taxes) {
            this.taxes = taxes;
        }

        public String getTaxStatus() {
            return taxStatus;
        }

        public void setTaxStatus(String taxStatus) {
            this.taxStatus = taxStatus;
        }

        public List<MetaData> getMetaData() {
            return metaData;
        }

        public void setMetaData(List<MetaData> metaData) {
            this.metaData = metaData;
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class FeeLine {
        private String name;
        private String total;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class TaxLine {
        private String rateId;
        private String total;

        public String getRateId() {
            return rateId;
        }

        public void setRateId(String rateId) {
            this.rateId = rateId;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MetaData {
        private Long id;
        private String key;
        private Object value;
        @JsonProperty("display_key")
        private String displayKey;
        @JsonProperty("display_value")
        private String displayValue;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getDisplayKey() {
            return displayKey;
        }

        public void setDisplayKey(String displayKey) {
            this.displayKey = displayKey;
        }

        public String getDisplayValue() {
            return displayValue;
        }

        public void setDisplayValue(String displayValue) {
            this.displayValue = displayValue;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Image {
        private String id;
        private String src;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Link {
        private String href;
        private Map<String, Object> targetHints;
        private Boolean embeddable;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public Map<String, Object> getTargetHints() {
            return targetHints;
        }

        public void setTargetHints(Map<String, Object> targetHints) {
            this.targetHints = targetHints;
        }

        public Boolean getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(Boolean embeddable) {
            this.embeddable = embeddable;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Refund {

        private Long id;

        private String reason;

        private String total;

        @JsonProperty("date_created")
        private String dateCreated;

        @JsonProperty("date_created_gmt")
        private String dateCreatedGmt;


        public Refund() {}

        // Getters and Setters
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getReason() {
            return reason;
        }
        public void setReason(String reason) {
            this.reason = reason;
        }
        public String getTotal() {
            return total;
        }
        public void setTotal(String total) {
            this.total = total;
        }
        public String getDateCreated() {
            return dateCreated;
        }
        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }
        public String getDateCreatedGmt() {
            return dateCreatedGmt;
        }
        public void setDateCreatedGmt(String dateCreatedGmt) {
            this.dateCreatedGmt = dateCreatedGmt;
        }
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CouponLine {

        private Long id;

        private String code;

        @JsonProperty("discount")
        private String discount;

        @JsonProperty("discount_tax")
        private String discountTax;

        @JsonProperty("meta_data")
        private Object metaData;

        public CouponLine() {}

        // Getters and Setters
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getDiscount() {
            return discount;
        }
        public void setDiscount(String discount) {
            this.discount = discount;
        }
        public String getDiscountTax() {
            return discountTax;
        }
        public void setDiscountTax(String discountTax) {
            this.discountTax = discountTax;
        }
        public Object getMetaData() {
            return metaData;
        }
        public void setMetaData(Object metaData) {
            this.metaData = metaData;
        }
    }

}

