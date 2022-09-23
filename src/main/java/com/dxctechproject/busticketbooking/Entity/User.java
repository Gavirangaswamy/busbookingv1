package com.dxctechproject.busticketbooking.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long userId;

    @Column(nullable = false)
    @Size(min = 4, message = "must be Min 5 characters")
    private String first_Name;

    private String last_Name;

    @Column(nullable = false, unique = true)
    @Email(message = "Email should be a Valid Email")
    private String email;

    @Size(min = 6, message = "Password must be 6 char long")
    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private Long contactNo;

    @Min(value = 15, message = "Not Below 15")
    @Max(value = 97, message = "Dont fool Us")
    private int age;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime UpdatedAt;
}