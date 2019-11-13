package cn.tedu.store.service.ex;

/**
 * 控制异常:username已存在
 * @author ZSP
 * @see ServiceException
 */
public class UsernameDuplicateException extends ServiceException{
	private static final long serialVersionUID = 3164055183124220212L;

	public UsernameDuplicateException() {
		super();
	}

	public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameDuplicateException(String message) {
		super(message);
	}

	public UsernameDuplicateException(Throwable cause) {
		super(cause);
	}
	
}
