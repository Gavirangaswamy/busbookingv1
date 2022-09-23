package com.dxctechproject.busticketbooking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_res_seq")
    @GenericGenerator(name = "order_res_seq", strategy = "com.dxctechproject.busticketbooking.Util.Order_Id_Generator",
            parameters = {
                    @Parameter(value = "50", name = "OrderIdGenerator.INCREMENT_PARAM"),
                    @Parameter(value = "DXC_:_", name = "OrderIdGenerator.VALUE_PREFIX_PARAMETER"),
                    @Parameter(value = "%05d", name = "OrderIdGenerator.NUMBER_FORMAT_PARAMETER")
            })
    @Column(unique = true, updatable = false)
    private String orderId;
	private String custId;
    private String txnAmount;
    private String phone;
    private String email;
	
}
