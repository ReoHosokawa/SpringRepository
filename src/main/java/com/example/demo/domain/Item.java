package com.example.demo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.example.demo.validator.ValidInteger;

public class Item {
	private Long id;

	private Long nameId;

	private Long oldNameId;

	private String name;

	@Min(value = 10, message = "10以上の数値を入力してください。")
	@Max(value = 10000, message = "10000以下の数値を入力してください。")
	private int price;

	@ValidInteger(values = { 8, 10 }, message = "8%・10%のいずれかを入力してください。")
	private int taxRate;

	private int priceWithTax;

	private Long vendorId;

	private String vendor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNameId() {
		return nameId;
	}

	public void setNameId(Long nameId) {
		this.nameId = nameId;
	}

	public Long getOldNameId() {
		return oldNameId;
	}

	public void setOldNameId(Long oldNameId) {
		this.oldNameId = oldNameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}

	public int getPriceWithTax() {
		return priceWithTax;
	}

	public void setPriceWithTax(int priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
}
