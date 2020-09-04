package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ship1_tab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name = "ship_id_col")
	private Integer id;
	@Column(name = "ship_mode_col")
	private String shipmentMode;
	@Column(name = "ship_code_col")
	private String shipmentCode;
	@Column(name = "ship_enableShip_col")
	private String enableShipment;
	@Column(name = "ship_grade_col")
	private String shipmentGrade;
	@Column(name = "ship_descrp_col")
	private String description;

	public ShipmentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShipmentMode() {
		return shipmentMode;
	}

	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}

	public String getShipmentCode() {
		return shipmentCode;
	}

	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}

	public String getEnableShipment() {
		return enableShipment;
	}

	public void setEnableShipment(String enableShipment) {
		this.enableShipment = enableShipment;
	}

	public String getShipmentGrade() {
		return shipmentGrade;
	}

	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", shipmentMode=" + shipmentMode + ", shipmentCode=" + shipmentCode
				+ ", enableShipment=" + enableShipment + ", shipmentGrade=" + shipmentGrade + ", description="
				+ description + "]";
	}

}
