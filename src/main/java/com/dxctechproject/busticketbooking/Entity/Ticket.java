package com.dxctechproject.busticketbooking.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "res_seq")
    @GenericGenerator(name = "res_seq", strategy = "com.dxctechproject.busticketbooking.Util.String_Id_Generator",
            parameters = {
                    @Parameter(value = "50", name = "StringIdGenerator.INCREMENT_PARAM"),
                    @Parameter(value = "DXC_:_", name = "StringIdGenerator.VALUE_PREFIX_PARAMETER"),
                    @Parameter(value = "%05d", name = "StringIdGenerator.NUMBER_FORMAT_PARAMETER")
            })
    @Column(unique = true, updatable = false)
    private String ticketId;
    private long routeid;
    private String count;
    private String amount;
    private String seats;
    private String pickup;
    private String droppoint;
    private String user;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime bookedAt;

}