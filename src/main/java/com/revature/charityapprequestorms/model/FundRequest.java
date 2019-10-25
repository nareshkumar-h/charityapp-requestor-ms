package com.revature.charityapprequestorms.model;


import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fund_request")
public class FundRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "fund_needed")
	private double fundNeeded;

	@Column(name = "requested_by")
	private int requestedBy;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "modified_date")
	private LocalDate modifiedDate;

	@Column(name = "active")
	private boolean active;

}
