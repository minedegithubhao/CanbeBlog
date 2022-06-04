package com.cxd.entity.system;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Book {
    private Long bookId;

    private String bookName;

    private Integer number;

}