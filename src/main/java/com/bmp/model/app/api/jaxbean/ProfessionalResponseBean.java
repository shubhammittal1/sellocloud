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
    "track"
})
@XmlRootElement(name = "NewDataSet")
public class ProfessionalResponseBean {

    protected List<ProfessionalResponseBean.Track> track;

    public List<ProfessionalResponseBean.Track> getTrack() {
        if (track == null) {
            track = new ArrayList<ProfessionalResponseBean.Track>();
        }
        return this.track;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "systm",
        "wayno",
        "citydestn",
        "cityorigin",
        "sysdt",
        "remarks",
        "stamp",
        "recipient",
        "activity",
        "weight",
        "pincodeorigin"
    })
    public static class Track {

        @XmlElement(name = "SYS_TM")
        protected String systm;
        @XmlElement(name = "WAYNO")
        protected String wayno;
        @XmlElement(name = "CITY_DESTN")
        protected String citydestn;
        @XmlElement(name = "CITY_ORIGIN")
        protected String cityorigin;
        @XmlElement(name = "SYS_DT")
        protected String sysdt;
        @XmlElement(name = "REMARKS")
        protected String remarks;
        @XmlElement(name = "STAMP")
        protected String stamp;
        @XmlElement(name = "RECIPIENT")
        protected String recipient;
        @XmlElement(name = "ACTIVITY")
        protected String activity;
        @XmlElement(name = "WEIGHT")
        protected String weight;
        @XmlElement(name = "PINCODE_ORIGIN")
        protected String pincodeorigin;

        /**
         * Gets the value of the systm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSYSTM() {
            return systm;
        }

        /**
         * Sets the value of the systm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSYSTM(String value) {
            this.systm = value;
        }

        /**
         * Gets the value of the wayno property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWAYNO() {
            return wayno;
        }

        /**
         * Sets the value of the wayno property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWAYNO(String value) {
            this.wayno = value;
        }

        /**
         * Gets the value of the citydestn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCITYDESTN() {
            return citydestn;
        }

        /**
         * Sets the value of the citydestn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCITYDESTN(String value) {
            this.citydestn = value;
        }

        /**
         * Gets the value of the cityorigin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCITYORIGIN() {
            return cityorigin;
        }

        /**
         * Sets the value of the cityorigin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCITYORIGIN(String value) {
            this.cityorigin = value;
        }

        /**
         * Gets the value of the sysdt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSYSDT() {
            return sysdt;
        }

        /**
         * Sets the value of the sysdt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSYSDT(String value) {
            this.sysdt = value;
        }

        /**
         * Gets the value of the remarks property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getREMARKS() {
            return remarks;
        }

        /**
         * Sets the value of the remarks property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setREMARKS(String value) {
            this.remarks = value;
        }

        /**
         * Gets the value of the stamp property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSTAMP() {
            return stamp;
        }

        /**
         * Sets the value of the stamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSTAMP(String value) {
            this.stamp = value;
        }

        /**
         * Gets the value of the recipient property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRECIPIENT() {
            return recipient;
        }

        /**
         * Sets the value of the recipient property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRECIPIENT(String value) {
            this.recipient = value;
        }

        /**
         * Gets the value of the activity property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getACTIVITY() {
            return activity;
        }

        /**
         * Sets the value of the activity property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setACTIVITY(String value) {
            this.activity = value;
        }

        /**
         * Gets the value of the weight property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWEIGHT() {
            return weight;
        }

        /**
         * Sets the value of the weight property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWEIGHT(String value) {
            this.weight = value;
        }

        /**
         * Gets the value of the pincodeorigin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPINCODEORIGIN() {
            return pincodeorigin;
        }

        /**
         * Sets the value of the pincodeorigin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPINCODEORIGIN(String value) {
            this.pincodeorigin = value;
        }

    }

}
