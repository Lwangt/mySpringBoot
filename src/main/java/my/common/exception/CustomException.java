package my.common.exception;

public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final Integer code;

    private final String message;

    public CustomException(String message)
    {
        this.message = message;
        this.code = null;
    }

    public CustomException(Integer code)
    {
        this.code = code;
        this.message = null;
    }

    public CustomException(String message, Integer code)
    {
        this.message = message;
        this.code = code;
    }

    public CustomException(String message, Throwable e, Integer code)
    {
        super(message, e);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public Integer getCode()
    {
        return code;
    }
}
