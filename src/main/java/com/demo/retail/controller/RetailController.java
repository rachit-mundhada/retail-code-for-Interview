package com.demo.retail.controller;


import com.demo.retail.request.Bill;
import com.demo.retail.response.PayableAmountResponse;
import com.demo.retail.service.RetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RetailController {


    @Autowired
    RetailsServiceImpl retailsService;


    @PostMapping("/getPayableAmt")
    public ResponseEntity<PayableAmountResponse> getNetPayableAmount(@RequestBody Bill bill){
        return new ResponseEntity<>(retailsService.getNetPayableAmount(bill), HttpStatus.OK);

    }
}
