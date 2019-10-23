package com.revature.charityapprequestorms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.Message;
import com.revature.charityapprequestorms.exception.ServiceException;

import com.revature.charityapprequestorms.service.FundRequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("fundrequest")
public class FundRequestController {
	@Autowired
	FundRequestService fundRequestService;

	/**
	 * Raise fund request in Fund Request Controller
	 * 
	 * @Param categoryId, requestedBy,fundNeeded If the object is Invalid, return
	 *        ServiceException ,If the credential is valid, return UserDetails object
	 */

	@PostMapping
	@ApiOperation(value = "RaiseFundRequest API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = FundRequestDto.class),
			@ApiResponse(code = 400, message = "Fund cannot be added", response = Message.class) })
	public ResponseEntity<?> addRequest(@RequestBody FundRequestDto fundRequestDto) {

		try {
			fundRequestService.addFundRequest(fundRequestDto);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (ServiceException e) {

			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

}
