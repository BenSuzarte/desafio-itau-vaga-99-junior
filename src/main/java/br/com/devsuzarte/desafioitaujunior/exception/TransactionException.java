package br.com.devsuzarte.desafioitaujunior.exception;

public class TransactionException {
    public static class InvalidTransactionException extends RuntimeException {
        public InvalidTransactionException(String message) { super(message); }
    };
}
