package com.demo.retail.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {
    private String customerSince;
    private String billAmount;
    private String billType;
    private String isAffiliate;
    private String isEmployee;

}
