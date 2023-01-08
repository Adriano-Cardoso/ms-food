package br.com.adrianofood.payment.exception;

import org.springframework.http.HttpStatus;

public enum Message {
    ID_PAYMENT_NOT_FOUND("Id do pagamento não existe", HttpStatus.NOT_FOUND),
    NAME_EXISTS("O nome procurado já existe em nossa base ", HttpStatus.BAD_REQUEST);

    private final String value;
    private String description;
    private HttpStatus statusCode;

    Message(String value, HttpStatus statusCode) {
        this.value = value;
        this.statusCode = statusCode;
    }

    Message(String value, String description, HttpStatus statusCode) {
        this.value = value;
        this.description = description;
        this.statusCode = statusCode;
    }

    Message(String value) {
        this.value = value;
    }

    public String getMessage() {
        return this.value;
    }

    public HttpStatus getStatus() {
        return this.statusCode;
    }

    public String getDescription() {
        return description;
    }

    public BusinessException asBusinessException() {
        return BusinessException.builder().httpStatusCode(this.getStatus())
                .code(String.valueOf(this.getStatus().value())).message(this.getMessage())
                .description(this.getDescription()).build();
    }
}
