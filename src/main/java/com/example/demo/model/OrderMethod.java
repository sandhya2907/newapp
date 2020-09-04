package com.example.demo.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name ="order_method_tab")
public class OrderMethod {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "mode")
	private String orderMode;

	@Column(name = "code")
	private String orderCode;

	@Column(name = "ord_type")
	private String orderType;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "accpt_tab",
	joinColumns = @JoinColumn(name = "id"))
	private List<String> orderAccept;

	@Column(name = "descrp")
	private String orderDescption;

	public OrderMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

	public String getOrderDescption() {
		return orderDescption;
	}

	public void setOrderDescption(String orderDescption) {
		this.orderDescption = orderDescption;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", orderType="
				+ orderType + ", orderAccept=" + orderAccept + ", orderDescption=" + orderDescption + "]";
	}

}
