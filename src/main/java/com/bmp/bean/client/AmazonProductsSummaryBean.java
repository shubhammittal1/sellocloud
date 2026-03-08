package com.bmp.bean.client;

public class AmazonProductsSummaryBean {
        private String marketplaceId;
        private boolean adultProduct;
        private boolean autographed;
        private String brand;
        private BrowseClassification browseClassification;
        private String color;
        private String itemClassification;
        private String itemName;
        private String manufacturer;
        private boolean memorabilia;
        private String modelNumber;
        private String packageQuantity;
        private String partNumber;
        private String releaseDate;
        private String size;
        private String style;
        private boolean tradeInEligible;
        private String websiteDisplayGroup;
        private String websiteDisplayGroupName;

    public AmazonProductsSummaryBean() {
        super();
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(String marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public boolean isAdultProduct() {
        return adultProduct;
    }

    public void setAdultProduct(boolean adultProduct) {
        this.adultProduct = adultProduct;
    }

    public boolean isAutographed() {
        return autographed;
    }

    public void setAutographed(boolean autographed) {
        this.autographed = autographed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BrowseClassification getBrowseClassification() {
        return browseClassification;
    }

    public void setBrowseClassification(BrowseClassification browseClassification) {
        this.browseClassification = browseClassification;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getItemClassification() {
        return itemClassification;
    }

    public void setItemClassification(String itemClassification) {
        this.itemClassification = itemClassification;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isMemorabilia() {
        return memorabilia;
    }

    public void setMemorabilia(boolean memorabilia) {
        this.memorabilia = memorabilia;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isTradeInEligible() {
        return tradeInEligible;
    }

    public void setTradeInEligible(boolean tradeInEligible) {
        this.tradeInEligible = tradeInEligible;
    }

    public String getWebsiteDisplayGroup() {
        return websiteDisplayGroup;
    }

    public void setWebsiteDisplayGroup(String websiteDisplayGroup) {
        this.websiteDisplayGroup = websiteDisplayGroup;
    }

    public String getWebsiteDisplayGroupName() {
        return websiteDisplayGroupName;
    }

    public void setWebsiteDisplayGroupName(String websiteDisplayGroupName) {
        this.websiteDisplayGroupName = websiteDisplayGroupName;
    }

    public static class BrowseClassification {
            private String displayName;
            private String classificationId;

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }

}
