package com.zngsgw.ssh.entity.productIntroduction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name="t_product")
public class Product implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private String productName;
	private Double price;
	private String photoPath;
	private String createTime;
	private String creater;
	private String lastUpdater;
	private String lastUpdateTime;
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	@Lob
	public String getDescription() {
		return description;
	}
	@Column(length=32)
	public String getProductName() {
		return productName;
	}
	@Column(length=10)
	public Double getPrice() {
		return price;
	}
	@Column(length=100)
	public String getPhotoPath() {
		return photoPath;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public String getLastUpdater() {
		return lastUpdater;
	}
	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	
}
