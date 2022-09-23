package com.dxctechproject.busticketbooking.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @Size(min = 3, message = "must be Min 3 characters")
    private String first_name;

    private String last_name;

    @Column(unique = true)
    @Email(message = "Email should be a valid email")
    private String email;

    @Column(nullable = false)
    private String password;

//    private String role;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;


}