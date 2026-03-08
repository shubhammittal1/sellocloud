package com.bmp.model.app.api.jaxbean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rdxtrack"
})
@XmlRootElement(name = "ArrayOfRDXTRACK")
public class RajdhaniexpressResponseBean {

    @XmlElement(name = "RDXTRACK", required = true)
    protected List<RajdhaniexpressResponseBean.RDXTRACK> rdxtrack;

    public List<RajdhaniexpressResponseBean.RDXTRACK> getRDXTRACK() {
        if (rdxtrack == null) {
            rdxtrack = new ArrayList<RajdhaniexpressResponseBean.RDXTRACK>();
        }
        return this.rdxtrack;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "consignmentNo",
        "date",
        "status",
        "warehouseName"
    })
    public static class RDXTRACK {

        @XmlElement(name = "Consignment_No")
        protected int consignmentNo;
        @XmlElement(name = "Date", required = true)
        protected String date;
        @XmlElement(name = "Status", required = true)
        protected String status;
        @XmlElement(name = "WarehouseName", required = true)
        protected String warehouseName;

       
        public int getConsignmentNo() {
            return consignmentNo;
        }

        
        public void setConsignmentNo(int value) {
            this.consignmentNo = value;
        }

       
        public String getDate() {
            return date;
        }

       
        public void setDate(String value) {
            this.date = value;
        }

        
        public String getStatus() {
            return status;
        }

        
        public void setStatus(String value) {
            this.status = value;
        }

          
        public String getWarehouseName() {
            return warehouseName;
        }

       
        public void setWarehouseName(String value) {
            this.warehouseName = value;
        }

    }

}
