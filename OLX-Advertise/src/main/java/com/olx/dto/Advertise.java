package com.olx.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ADVERTISE DTO")
public class Advertise {
	
	@ApiModelProperty(value = "ID")
	private long id;
	
	@ApiModelProperty(value = "Title")
	private String title;
	
	@ApiModelProperty(value = "Description")
	private String description;
	
	@ApiModelProperty(value = "Price")
	private double price;
	
	@ApiModelProperty(value = "Category")
	private long category;
	
	@ApiModelProperty(value = "created_date")
	private LocalDate createdDate;
	
	@ApiModelProperty(value = "modified_date")
	private LocalDate modifiedDate;
	
	@ApiModelProperty(value = "Active")
	private String active;
	
	
	@ApiModelProperty(value = "username")
	private String username;

}
