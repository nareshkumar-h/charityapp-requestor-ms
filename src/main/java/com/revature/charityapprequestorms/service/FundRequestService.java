package com.revature.charityapprequestorms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapprequestorms.dto.FundRequestDto;
import com.revature.charityapprequestorms.dto.MessageConstant;
import com.revature.charityapprequestorms.exception.ServiceException;
import com.revature.charityapprequestorms.model.FundRequest;
import com.revature.charityapprequestorms.repository.FundRequestRepository;

@Service
public class FundRequestService {

	@Autowired
	FundRequestRepository fundRequestRepo;

	/**
	 * Raise fund request in Fund Request service
	 * 
	 * data is passed in fund request object, If the object is returned as null,
	 * return ServiceException If the object is valid, return Fund request object
	 */
	@Transactional
	public void addFundRequest(final FundRequestDto fundRequestDto) throws ServiceException {

		try {
			FundRequest fundRequest = new FundRequest();

			fundRequest.setCategoryId(fundRequestDto.getCategoryId());
			fundRequest.setRequestedBy(fundRequestDto.getRequestedBy());
			fundRequest.setFundNeeded(fundRequestDto.getFundNeeded());

			FundRequest fundResp = fundRequestRepo.findById(fundRequestDto.getCategoryId());
			if (fundResp == null) {

				fundRequest.setActive(true);

				fundRequestRepo.save(fundRequest);
			}

			else {
				throw new ServiceException(MessageConstant.FUND_REQUEST_ADDITION);

			}
		} catch (Exception e) {
			throw new ServiceException(MessageConstant.FUND_REQUEST_ADDITION);

		}
	}
}
