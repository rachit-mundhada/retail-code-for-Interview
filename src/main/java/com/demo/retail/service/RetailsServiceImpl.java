package com.demo.retail.service;

import com.demo.retail.request.Bill;
import com.demo.retail.response.PayableAmountResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static java.util.Objects.nonNull;


@Service
public class RetailsServiceImpl implements RetailsService {


    @Override
    public PayableAmountResponse getNetPayableAmount(Bill bill) {

        //Integer currentYear= Calendar.getInstance().get(Calendar.YEAR);
        PayableAmountResponse payableAmountResponse = new PayableAmountResponse();
        if(nonNull(bill.getBillType()) && bill.getBillType().equalsIgnoreCase("Groceries")){
            return PayableAmountResponse.builder()
                    .netPayableAmount(new BigDecimal(bill.getBillAmount()))
                    .responseMessage("No discounts applicable on bill type Groceries")
                    .build();
        }

        if (nonNull(bill.getBillAmount()) && !bill.getBillAmount().isBlank()) {
            BigDecimal amt = new BigDecimal(Integer.parseInt(bill.getBillAmount()));

            if (nonNull(bill.getIsEmployee()) && bill.getIsEmployee().equalsIgnoreCase("true")) {
                BigDecimal intermediateAmt=new BigDecimal(amt.intValue() * 0.30);
                payableAmountResponse.setNetPayableAmount(new BigDecimal(bill.getBillAmount()).subtract(intermediateAmt));
                payableAmountResponse.setResponseMessage("Success");
            }
            else if (nonNull(bill.getIsAffiliate()) && bill.getIsAffiliate().equalsIgnoreCase("true")) {
                BigDecimal intermediateAmt=new BigDecimal(amt.intValue() * 0.10);
                payableAmountResponse.setNetPayableAmount(new BigDecimal(bill.getBillAmount()).subtract(intermediateAmt));
                payableAmountResponse.setResponseMessage("Success");

            }
            else if (nonNull(bill.getCustomerSince()) && Integer.parseInt(bill.getCustomerSince()) >= 2) {
                BigDecimal intermediateAmt=new BigDecimal(amt.intValue() * 0.05);
                payableAmountResponse.setNetPayableAmount(new BigDecimal(bill.getBillAmount()).subtract(intermediateAmt));
                payableAmountResponse.setResponseMessage("Success");

            } else {
                    //amt.divide(new BigDecimal(100)).intValue()*5;
                BigDecimal intermediateAmt= new BigDecimal(amt.divide(new BigDecimal(100)).intValue());
                PayableAmountResponse.builder()
                        .netPayableAmount(new BigDecimal(bill.getBillAmount()).subtract(intermediateAmt.multiply(new BigDecimal(5))))
                        .responseMessage("Success")
                        .build();

            }
            return payableAmountResponse;
        }
        else{
            return PayableAmountResponse.builder().responseMessage("Bill amount is null").netPayableAmount(null).build();
        }
    }
}
