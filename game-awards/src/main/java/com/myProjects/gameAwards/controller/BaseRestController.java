package com.myProjects.gameAwards.controller;

import com.myProjects.gameAwards.controller.dto.ApiErrorDTO;
import com.myProjects.gameAwards.service.exception.BusinessException;
import com.myProjects.gameAwards.service.exception.NoContentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public abstract class BaseRestController {

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Void> handlerNoContentException(NoContentException exception){
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorDTO> handlerBusinessException(BusinessException exception){
        ApiErrorDTO error = new ApiErrorDTO(exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiErrorDTO> handlerUnexpectedException(Throwable exception){
        exception.printStackTrace();
        String message = "Todo mundo erra e dessa vez nós erramos! Pedimos desculpas por esse erro inesperado.";
        ApiErrorDTO error = new ApiErrorDTO(message);
        return ResponseEntity.internalServerError().body(error);
    }
}
