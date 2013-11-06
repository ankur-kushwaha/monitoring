package springapp.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {
	String business_date;
	String sub_area;
	String statusd;
	public String getBusiness_date() {
		return business_date;
	}
	public void setBusiness_date(String business_date) {
		this.business_date = business_date;
	}
	public String getSub_area() {
		return sub_area;
	}
	public void setSub_area(String sub_area) {
		this.sub_area = sub_area;
	}
	public String getStatusd() {
		return statusd;
	}
	public void setStatusd(String status) {
		this.statusd = status;
	}
}
