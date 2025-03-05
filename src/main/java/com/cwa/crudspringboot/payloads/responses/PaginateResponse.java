package com.cwa.crudspringboot.payloads.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginateResponse<T> {
    private Integer totalPages;
    private long totalElements;
    private Integer size;
    private Integer page;
    private T data;
}
