package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Table(name = "portal_users_mar_26")
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebUser {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    @Column(unique = true, nullable = false,name="username")
	    private String username;
	    private String email;
	    private String password;
	    @Column(nullable = false)
	    private String role;
}
