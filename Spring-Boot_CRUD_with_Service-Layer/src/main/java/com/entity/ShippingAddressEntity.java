package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "shippingAddress")
public class ShippingAddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private long doorNo;
	private String streetName;
	private String layout;
	private String city;
	private long pincode;
	
	/*
		 {
		    "doorNo": 533,
		    "streetName": "Park Street",
		    "layout": "Jashi Bazar",
		    "city": "Agra",
		    "pincode": 783440
		  }
	 */
	
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public long getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(long doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "ShippingAddress_Entity [addressId=" + addressId + ", doorNo=" + doorNo + ", streetName=" + streetName
				+ ", layout=" + layout + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	public ShippingAddressEntity(long addressId, long doorNo, String streetName, String layout, String city,
			long pincode) {
		super();
		this.addressId = addressId;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.layout = layout;
		this.city = city;
		this.pincode = pincode;
	}
	
	
	public ShippingAddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
}