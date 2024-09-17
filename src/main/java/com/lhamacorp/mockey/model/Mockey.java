package com.lhamacorp.mockey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mockey {

    @Id
    private String id;
    private String content;
    private Instant lastModified;
    private Instant lastAccessed;

}
