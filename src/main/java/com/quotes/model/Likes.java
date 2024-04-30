package com.quotes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.quotes.util.TimeAudit;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "likes")
public class Likes extends TimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-likes")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    @JsonBackReference(value = "quote-likes")
    private Quote quote;
}
