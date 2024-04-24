package com.quotes.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.quotes.enums.Role;
import com.quotes.util.TimeAudit;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table(name = "users")
public class User extends TimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;
    private String dob;
    private String gender;
    // address
    @Enumerated(EnumType.STRING)
    private Role role;
    @Builder.Default
    private boolean isActive = true;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "author-quotes")
    private Set<Quote> quotes = new HashSet<>();

}
