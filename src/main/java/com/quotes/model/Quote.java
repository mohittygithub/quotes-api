package com.quotes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.quotes.util.TimeAudit;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
@Entity
@Table(name = "quote")
public class Quote extends TimeAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    private Long testId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference(value = "author-quotes")
    private User author;

    @OneToMany(mappedBy = "quote", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "quote-likes")
    private Set<Likes> likes = new HashSet<>();
}
