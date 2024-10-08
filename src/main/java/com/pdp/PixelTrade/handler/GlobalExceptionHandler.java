package com.pdp.PixelTrade.handler;

import com.pdp.PixelTrade.dto.response.ErrorMessageDTO;
import com.pdp.PixelTrade.exceptions.BaseException;
import com.pdp.PixelTrade.exceptions.ResourceNotFoundException;
import com.pdp.PixelTrade.exceptions.UserAlreadyExistsException;
import com.pdp.PixelTrade.exceptions.UserNotFoundException;
import com.pdp.PixelTrade.exceptions.crypto.DecryptionException;
import com.pdp.PixelTrade.exceptions.crypto.EncryptionException;
import com.pdp.PixelTrade.exceptions.network.ApiCallFailedException;
import com.pdp.PixelTrade.exceptions.network.ConnectionTimeoutException;
import com.pdp.PixelTrade.exceptions.notification.NotificationException;
import com.pdp.PixelTrade.exceptions.otp.InvalidOtpCodeException;
import com.pdp.PixelTrade.exceptions.otp.OtpExpiredException;
import com.pdp.PixelTrade.exceptions.otp.OtpNotFoundException;
import com.pdp.PixelTrade.exceptions.otp.TooManyOtpRequestsException;
import com.pdp.PixelTrade.exceptions.p2p.P2PMarketNotFoundException;
import com.pdp.PixelTrade.exceptions.payment.InvalidPaymentDetailsException;
import com.pdp.PixelTrade.exceptions.payment.PaymentMethodNotSupportedException;
import com.pdp.PixelTrade.exceptions.security.SessionExpiredException;
import com.pdp.PixelTrade.exceptions.security.TokenExpiredException;
import com.pdp.PixelTrade.exceptions.security.UnauthorizedAccessException;
import com.pdp.PixelTrade.exceptions.transaction.*;
import com.pdp.PixelTrade.exceptions.validation.InvalidDataException;
import com.pdp.PixelTrade.exceptions.validation.InvalidInputFormatException;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Aliabbos Ashurov
 * @since 03/September/2024  14:28
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${project.log-mode}")
    private boolean LOG_MODE;

    // NOTE: Package: main
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("RESOURCE_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessageDTO> handleUserAlreadyExistsException(UserAlreadyExistsException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("USER_ALREADY_EXISTS", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("USER_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleUsernameNotFoundException(UsernameNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("USERNAME_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


    // NOTE: Package: crypto
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorMessageDTO> handleCryptoOperationException(BaseException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of(ex.getCode(), ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
    }

    @ExceptionHandler(DecryptionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleDecryptionException(DecryptionException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("DECRYPTION_ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EncryptionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleEncryptionException(EncryptionException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("ENCRYPTION_ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // NOTE: Package: p2p
    @ExceptionHandler(P2PMarketNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleP2PMarketNotFoundException(P2PMarketNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("P2P_MARKET_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }


    // NOTE: Package: network
    @ExceptionHandler(ApiCallFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleApiCallFailedException(ApiCallFailedException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("API_CALL_FAILED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConnectionTimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ResponseEntity<ErrorMessageDTO> handleConnectionTimeoutException(ConnectionTimeoutException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("CONNECTION_TIMEOUT", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.REQUEST_TIMEOUT);
    }


    // NOTE: Package: notification
    @ExceptionHandler(NotificationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleNotificationException(NotificationException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("NOTIFICATION_ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // NOTE: Package: otp
    @ExceptionHandler(MessagingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleMessagingException(MessagingException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("MESSAGING_ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OtpNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleOtpNotFoundException(OtpNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("OTP_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OtpExpiredException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ResponseEntity<ErrorMessageDTO> handleOtpExpiredException(OtpExpiredException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("OTP_EXPIRED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.REQUEST_TIMEOUT);
    }

    @ExceptionHandler(InvalidOtpCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleInvalidOtpCodeException(InvalidOtpCodeException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("INVALID_OTP_CODE", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TooManyOtpRequestsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessageDTO> handleTooManyOtpRequestsException(TooManyOtpRequestsException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("TOO_MANY_REQUESTS", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }


    // NOTE: Package: payment
    @ExceptionHandler(InvalidPaymentDetailsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleInvalidPaymentDetailsException(InvalidPaymentDetailsException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("INVALID_PAYMENT_DETAILS", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PaymentMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ResponseEntity<ErrorMessageDTO> handlePaymentMethodNotSupportedException(PaymentMethodNotSupportedException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("PAYMENT_METHOD_NOT_SUPPORTED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_IMPLEMENTED);
    }


    // NOTE: Package: security
    @ExceptionHandler(SessionExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessageDTO> handleSessionExpiredException(SessionExpiredException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("SESSION_EXPIRED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorMessageDTO> handleTokenExpiredException(TokenExpiredException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("TOKEN_EXPIRED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorMessageDTO> handleUnauthorizedAccessException(UnauthorizedAccessException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("UNAUTHORIZED_ACCESS", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.FORBIDDEN);
    }


    // NOTE: Package: transaction
    @ExceptionHandler(CryptoTransactionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleCryptoTransactionException(CryptoTransactionException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("CRYPTO_TRANSACTION_ERROR", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleInsufficientBalanceException(InsufficientBalanceException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("INSUFFICIENT_BALANCE", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransactionAlreadyProcessedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorMessageDTO> handleTransactionAlreadyProcessedException(TransactionAlreadyProcessedException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("TRANSACTION_ALREADY_PROCESSED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TransactionFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessageDTO> handleTransactionFailedException(TransactionFailedException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("TRANSACTION_FAILED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TransactionLimitExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleTransactionLimitExceededException(TransactionLimitExceededException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("TRANSACTION_LIMIT_EXCEEDED", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(WalletNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleWalletNotFoundException(WalletNotFoundException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("WALLET_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    // NOTE: Package: validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("VALIDATION_EXCEPTION", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleInvalidDataException(InvalidDataException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("INVALID_DATA", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInputFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorMessageDTO> handleInvalidInputFormatException(InvalidInputFormatException ex, HttpServletRequest request) {
        logException(ex, request);
        ErrorMessageDTO errorMessage = ErrorMessageDTO.of("INVALID_INPUT_FORMAT", ex.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    private void logException(Exception ex, HttpServletRequest request) {
        if (LOG_MODE) {
            log.error("Exception occurred at URI: [{}] MESSAGE: {}", request.getRequestURI(), ex.getMessage());
        }
    }
}
