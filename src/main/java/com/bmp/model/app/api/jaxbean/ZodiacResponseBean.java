package com.bmp.model.app.api.jaxbean;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "table"
})
@XmlRootElement(name = "NewDataSet")
public class ZodiacResponseBean {

    @XmlElement(name = "Table")
    protected List<ZodiacResponseBean.Table> table;

    public List<ZodiacResponseBean.Table> getTable() {
        if (table == null) {
            table = new ArrayList<ZodiacResponseBean.Table>();
        }
        return this.table;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bookingDate",
        "awbno",
        "origin",
        "destination",
        "pcs",
        "cwt",
        "status",
        "sdate",
        "statusDate",
        "stime",
        "wremarks"
    })
    public static class Table {

        @XmlElement(name = "BookingDate")
        protected String bookingDate;
        @XmlElement(name = "AWBNO")
        protected Long awbno;
        @XmlElement(name = "Origin")
        protected String origin;
        @XmlElement(name = "Destination")
        protected String destination;
        @XmlElement(name = "Pcs")
        protected Byte pcs;
        protected Float cwt;
        protected String status;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar sdate;
        @XmlElement(name = "StatusDate")
        protected String statusDate;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar stime;
        protected String wremarks;

        /**
         * Gets the value of the bookingDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBookingDate() {
            return bookingDate;
        }

        /**
         * Sets the value of the bookingDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBookingDate(String value) {
            this.bookingDate = value;
        }

        /**
         * Gets the value of the awbno property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getAWBNO() {
            return awbno;
        }

        /**
         * Sets the value of the awbno property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setAWBNO(Long value) {
            this.awbno = value;
        }

        /**
         * Gets the value of the origin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrigin() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrigin(String value) {
            this.origin = value;
        }

        /**
         * Gets the value of the destination property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestination() {
            return destination;
        }

        /**
         * Sets the value of the destination property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestination(String value) {
            this.destination = value;
        }

        /**
         * Gets the value of the pcs property.
         * 
         * @return
         *     possible object is
         *     {@link Byte }
         *     
         */
        public Byte getPcs() {
            return pcs;
        }

        /**
         * Sets the value of the pcs property.
         * 
         * @param value
         *     allowed object is
         *     {@link Byte }
         *     
         */
        public void setPcs(Byte value) {
            this.pcs = value;
        }

        /**
         * Gets the value of the cwt property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getCwt() {
            return cwt;
        }

        /**
         * Sets the value of the cwt property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setCwt(Float value) {
            this.cwt = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the sdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSdate() {
            return sdate;
        }

        /**
         * Sets the value of the sdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSdate(XMLGregorianCalendar value) {
            this.sdate = value;
        }

        /**
         * Gets the value of the statusDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatusDate() {
            return statusDate;
        }

        /**
         * Sets the value of the statusDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatusDate(String value) {
            this.statusDate = value;
        }

        /**
         * Gets the value of the stime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStime() {
            return stime;
        }

        /**
         * Sets the value of the stime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStime(XMLGregorianCalendar value) {
            this.stime = value;
        }

        /**
         * Gets the value of the wremarks property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWremarks() {
            return wremarks;
        }

        /**
         * Sets the value of the wremarks property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWremarks(String value) {
            this.wremarks = value;
        }

    }

}