package com.banquemisr.irrigationsystem.message.config;


import com.banquemisr.irrigationsystem.message.*;
import com.banquemisr.irrigationsystem.message.constant.*;
import jakarta.validation.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.http.*;
import org.springframework.transaction.*;
import org.springframework.validation.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import java.util.stream.*;

@ControllerAdvice
public class RestExceptionHandler {

  Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
  private final MessageSource messageSource;

  @Autowired
  public RestExceptionHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<RestMessage> handleExceptions(Exception ex, Locale locale) {
    logger.error("Unexpected error in: [" + ex.getClass().getName() + "]", ex);
    String errorMessage = messageSource.getMessage(ExceptionCode.UNEXPECTED_ERROR, null, locale);
    return new ResponseEntity<>(
        new RestMessage(errorMessage, MessageType.ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<RestMessage> handleArgumentNotValidException(
      MethodArgumentNotValidException ex, Locale locale) {
    BindingResult result = ex.getBindingResult();
    String header = messageSource.getMessage(result.getObjectName(), null, locale);
    List<String> errorMessages =
        result.getAllErrors().stream()
            .filter(elm -> elm.getDefaultMessage() != null)
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
    return getExceptionsResponse(ex, header, errorMessages);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<RestMessage> handleExceptions(
      ConstraintViolationException ex, Locale locale) {
    String header =
        messageSource.getMessage(ExceptionCode.CONSTRAINT_VIOLATION_EXCEPTION, null, locale);
    List<String> errorMessages =
        ex.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toList());
    return getExceptionsResponse(ex, header, errorMessages);
  }

  @ExceptionHandler(TransactionSystemException.class)
  public ResponseEntity<RestMessage> handleExceptions(
      TransactionSystemException ex, Locale locale) {

    if (ex.getCause().getCause() instanceof ConstraintViolationException) {
      return handleExceptions((ConstraintViolationException) ex.getCause().getCause(), locale);
    } else {
      String header =
          messageSource.getMessage(ExceptionCode.CONSTRAINT_VIOLATION_EXCEPTION, null, locale);
      return getExceptionsResponse(ex, header);
    }
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<RestMessage> handleExceptions(ValidationException ex, Locale locale) {
    String header =
        messageSource.getMessage(ExceptionCode.CONSTRAINT_VIOLATION_EXCEPTION, null, locale);
    return getExceptionsResponse(ex, header);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<RestMessage> handleExceptions(
      MissingServletRequestParameterException ex, Locale locale) {
    String header =
        messageSource.getMessage(ExceptionCode.CONSTRAINT_VIOLATION_EXCEPTION, null, locale);
    return getExceptionsResponse(ex, header);
  }

  private ResponseEntity<RestMessage> getExceptionsResponse(Throwable throwable, String header) {
    return getExceptionsResponse(throwable, header, null);
  }

  private ResponseEntity<RestMessage> getExceptionsResponse(
      Throwable throwable, String header, List<String> errorMessages) {
    return getExceptionsResponse(throwable, MessageType.VALIDATION, header, errorMessages);
  }

  private ResponseEntity<RestMessage> getExceptionsResponse(
      Throwable throwable, MessageType messageType, String header, List<String> errorMessages) {
    logger.error("Application error in: [" + throwable.getClass().getName() + "]", throwable);
    return new ResponseEntity<>(
        new RestMessage(header, messageType, errorMessages), HttpStatus.BAD_REQUEST);
  }
}
