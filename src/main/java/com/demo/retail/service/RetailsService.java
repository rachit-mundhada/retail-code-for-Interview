package com.demo.retail.service;

import com.demo.retail.request.Bill;
import com.demo.retail.response.PayableAmountResponse;

public interface RetailsService {

    public PayableAmountResponse getNetPayableAmount(Bill bill);
}
