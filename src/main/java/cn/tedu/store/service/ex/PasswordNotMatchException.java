package cn.tedu.store.service.ex;

/**
 * 控制异常:登录时,密码错误
 * @author ZSP
 *@see ServiceException
 */
public class PasswordNotMatchException extends ServiceException{

	private static final long serialVersionUID = 1903639604855086304L;

	public PasswordNotMatchException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotMatchException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
