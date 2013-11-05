package springapp.domain;

public class Consumers {
	String sub_area;
	String existing;
	String potential;
	String source;
	public String getSub_area() {
		return sub_area;
	}
	public void setSub_area(String data_type) {
		this.sub_area = data_type;
	}
	public String getExisting() {
		return existing;
	}
	public void setExisting(String consumer) {
		this.existing = consumer;
	}
	public String getPotential() {
		return potential;
	}
	public void setPotential(String consumer_type) {
		this.potential = consumer_type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
