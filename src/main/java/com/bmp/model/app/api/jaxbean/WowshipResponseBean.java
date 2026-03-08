package com.bmp.model.app.api.jaxbean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "scan_detail" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class WowshipResponseBean {

	private Scan_detail[] scan_detail;

    public Scan_detail[] getScan_detail ()
    {
        return scan_detail;
    }

    public void setScan_detail (Scan_detail[] scan_detail)
    {
        this.scan_detail = scan_detail;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [scan_detail = "+scan_detail+"]";
    }
    
    
    public static class Scan_detail
    {
        private String status_code;

        private String updated_date;

        private String status_description;

        private String location;

        private String status;

        private String awbno;

        private String remarks;

        public String getStatus_code ()
        {
            return status_code;
        }

        public void setStatus_code (String status_code)
        {
            this.status_code = status_code;
        }

        public String getUpdated_date ()
        {
            return updated_date;
        }

        public void setUpdated_date (String updated_date)
        {
            this.updated_date = updated_date;
        }

        public String getStatus_description ()
        {
            return status_description;
        }

        public void setStatus_description (String status_description)
        {
            this.status_description = status_description;
        }

        public String getLocation ()
        {
            return location;
        }

        public void setLocation (String location)
        {
            this.location = location;
        }

        public String getStatus ()
        {
            return status;
        }

        public void setStatus (String status)
        {
            this.status = status;
        }

        public String getAwbno ()
        {
            return awbno;
        }

        public void setAwbno (String awbno)
        {
            this.awbno = awbno;
        }

        public String getRemarks ()
        {
            return remarks;
        }

        public void setRemarks (String remarks)
        {
            this.remarks = remarks;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [status_code = "+status_code+", updated_date = "+updated_date+", status_description = "+status_description+", location = "+location+", status = "+status+", awbno = "+awbno+", remarks = "+remarks+"]";
        }
    }
	    
	/*@JsonProperty("scan_detail")
	private List<ScanDetail> scanDetail = null;

	@JsonProperty("scan_detail")
	public List<ScanDetail> getScanDetail() {
		return scanDetail;
	}

	@JsonProperty("scan_detail")
	public void setScanDetail(List<ScanDetail> scanDetail) {
		this.scanDetail = scanDetail;
	}
	
	public static class ScanDetail {

		@JsonProperty("awbno")
		private String awbno;
		@JsonProperty("status_code")
		private String statusCode;
		@JsonProperty("status")
		private String status;
		@JsonProperty("status_description")
		private String statusDescription;
		@JsonProperty("remarks")
		private String remarks;
		@JsonProperty("location")
		private String location;
		@JsonProperty("updated_date")
		private String updatedDate;

		@JsonProperty("awbno")
		public String getAwbno() {
			return awbno;
		}

		@JsonProperty("awbno")
		public void setAwbno(String awbno) {
			this.awbno = awbno;
		}

		@JsonProperty("status_code")
		public String getStatusCode() {
			return statusCode;
		}

		@JsonProperty("status_code")
		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}

		@JsonProperty("status")
		public String getStatus() {
			return status;
		}

		@JsonProperty("status")
		public void setStatus(String status) {
			this.status = status;
		}

		@JsonProperty("status_description")
		public String getStatusDescription() {
			return statusDescription;
		}

		@JsonProperty("status_description")
		public void setStatusDescription(String statusDescription) {
			this.statusDescription = statusDescription;
		}

		@JsonProperty("remarks")
		public String getRemarks() {
			return remarks;
		}

		@JsonProperty("remarks")
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		@JsonProperty("location")
		public String getLocation() {
			return location;
		}

		@JsonProperty("location")
		public void setLocation(String location) {
			this.location = location;
		}

		@JsonProperty("updated_date")
		public String getUpdatedDate() {
			return updatedDate;
		}

		@JsonProperty("updated_date")
		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}
	}*/
	
}