package cn.tedu.store.service.ex;

/**
 * 更新数据异常
 * @author ZSP
 *@see ServiceException
 */
public class UpdateException extends ServiceException{

	private static final long serialVersionUID = -3670870874533766508L;

	public UpdateException() {
		super();
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateException(String message) {
		super(message);
	}

	public UpdateException(Throwable cause) {
		super(cause);
	}

}
