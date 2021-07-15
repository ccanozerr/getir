package com.getir.exception;

public class SoldStockCannotGreaterThanOldStockException extends RuntimeException{

    public SoldStockCannotGreaterThanOldStockException() {
        super();
    }

    public SoldStockCannotGreaterThanOldStockException(String message) {
        super(message);
    }
}
