package com.example.book.Model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "brand")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Brand  extends AbstractAuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String slug;
    private boolean isPublished;




}
