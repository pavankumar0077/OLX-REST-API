package com.olx.dto;

import java.time.LocalDate;

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

	@ApiModelProperty(value = "Id")
	private long id;
	@ApiModelProperty(value = "Title")
	private String title;
	@ApiModelProperty(value = "description")
	private String description;
	@ApiModelProperty(value = "price")
	private double price;
	@ApiModelProperty(value = "category")
	private long category;
	@ApiModelProperty(value = "createdDate")
	private LocalDate createdDate;
	@ApiModelProperty(value = "modifiedDate")
	private LocalDate modifiedDate;
	@ApiModelProperty(value = "active")
	private String active;
	@ApiModelProperty(value = "username")
	private String username;

}
