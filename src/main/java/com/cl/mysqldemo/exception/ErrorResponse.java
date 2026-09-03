package com.cl.mysqldemo.exception;

import java.util.Date;

public record ErrorResponse(
        int status,
        String error,
        String message,
        Date timestamp
) {
}
