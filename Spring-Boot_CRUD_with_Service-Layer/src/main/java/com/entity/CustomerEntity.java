package com.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	private String customerEmail;
	private String billingAddress;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Set<ShippingAddressEntity> shippingAddress = new HashSet<>();

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Set<ShippingAddressEntity> getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Set<ShippingAddressEntity> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Customer_Entity [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}

	public CustomerEntity(long customerId, String customerName, String customerEmail, String billingAddress,
			Set<ShippingAddressEntity> shippingAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	


}

