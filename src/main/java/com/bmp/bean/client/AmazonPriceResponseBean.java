package com.bmp.bean.client;
import java.util.List;

public class AmazonPriceResponseBean {

        private List<Payload> payload;

        public List<Payload> getPayload() {
            return payload;
        }

        public void setPayload(List<Payload> payload) {
            this.payload = payload;
        }

        public static class Payload {
            private String status;
            private String ASIN;
            private Product product;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getASIN() {
                return ASIN;
            }

            public void setASIN(String ASIN) {
                this.ASIN = ASIN;
            }

            public Product getProduct() {
                return product;
            }

            public void setProduct(Product product) {
                this.product = product;
            }
        }

        public static class Product {
            private Identifiers identifiers;
            private List<Offer> offers;

            public Identifiers getIdentifiers() {
                return identifiers;
            }

            public void setIdentifiers(Identifiers identifiers) {
                this.identifiers = identifiers;
            }

            public List<Offer> getOffers() {
                return offers;
            }

            public void setOffers(List<Offer> offers) {
                this.offers = offers;
            }
        }

        public static class Identifiers {
            private MarketplaceASIN marketplaceASIN;

            public MarketplaceASIN getMarketplaceASIN() {
                return marketplaceASIN;
            }

            public void setMarketplaceASIN(MarketplaceASIN marketplaceASIN) {
                this.marketplaceASIN = marketplaceASIN;
            }
        }

        public static class MarketplaceASIN {
            private String marketplaceId;
            private String ASIN;

            public String getMarketplaceId() {
                return marketplaceId;
            }

            public void setMarketplaceId(String marketplaceId) {
                this.marketplaceId = marketplaceId;
            }

            public String getASIN() {
                return ASIN;
            }

            public void setASIN(String ASIN) {
                this.ASIN = ASIN;
            }
        }

        public static class Offer {
            private Price price;

            public Price getPrice() {
                return price;
            }

            public void setPrice(Price price) {
                this.price = price;
            }
        }

        public static class Price {
            private ListingPrice listingPrice;
            private SalePrice salePrice;

            public ListingPrice getListingPrice() {
                return listingPrice;
            }

            public void setListingPrice(ListingPrice listingPrice) {
                this.listingPrice = listingPrice;
            }

            public SalePrice getSalePrice() {
                return salePrice;
            }

            public void setSalePrice(SalePrice salePrice) {
                this.salePrice = salePrice;
            }
        }

        public static class ListingPrice {
            private double amount;
            private String currencyCode;

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getCurrencyCode() {
                return currencyCode;
            }

            public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
            }
        }

        public static class SalePrice {
            private double amount;
            private String currencyCode;

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public String getCurrencyCode() {
                return currencyCode;
            }

            public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
            }
        }

}
