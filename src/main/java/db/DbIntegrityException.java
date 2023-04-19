package db;

public class DbIntegrityException extends RuntimeException{

    DbIntegrityException (String msg) {
        super(msg);
    }
}
