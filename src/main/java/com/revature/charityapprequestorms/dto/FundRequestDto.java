package com.revature.charityapprequestorms.dto;


import java.time.LocalDate;

import lombok.Data;

@Data

public class FundRequestDto {

	private Integer id;

	private int categoryId;

	private double fundNeeded;

	private int requestedBy;

	private LocalDate createdDate;

	private LocalDate modifiedDate;

	private boolean active;

}
