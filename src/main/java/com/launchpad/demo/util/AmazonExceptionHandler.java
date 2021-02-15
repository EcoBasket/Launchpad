package com.launchpad.demo.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

@UtilityClass
public class AmazonExceptionHandler {

    /**
     *
     * @param supplier A default functional interface, that takes nothing but returns 1 item
     * @param <T>
     * @return
     */
    public <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (AmazonServiceException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(e.getStatusCode()), e.getMessage(), e);  // If they make a mistake
        } catch (AmazonClientException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);  // If we make a mistake
        }
    }
}
