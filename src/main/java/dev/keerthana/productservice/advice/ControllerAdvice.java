package dev.keerthana.productservice.advice;

import dev.keerthana.productservice.Exception.ProductNotFoundException;
import dev.keerthana.productservice.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException()
    {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode("400");
        errorDTO.setErrorMsg("Invalid input");
        return ResponseEntity.badRequest().body(errorDTO);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException()
    {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode("500");
        errorDTO.setErrorMsg("Product not found");
        return ResponseEntity.badRequest().body(errorDTO);
    }
}
