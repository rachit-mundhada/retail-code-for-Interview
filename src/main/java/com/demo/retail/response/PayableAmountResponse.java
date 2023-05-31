package com.demo.retail.response;


import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PayableAmountResponse {
    private String responseMessage;
    private BigDecimal netPayableAmount;

}
