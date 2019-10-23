package com.revature.charityapprequestorms.dto;

import java.time.LocalDate;

import lombok.Data;

@Data

public class FundRequestDto {

	private Integer id;

	private int categoryId;

	private double fundNeeded;

	private int requestedBy;

	private LocalDate createdDate = LocalDate.now();

	private LocalDate modifiedDate = LocalDate.now();

	private boolean active;

}
