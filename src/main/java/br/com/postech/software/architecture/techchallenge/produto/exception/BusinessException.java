package br.com.postech.software.architecture.techchallenge.produto.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }

}
