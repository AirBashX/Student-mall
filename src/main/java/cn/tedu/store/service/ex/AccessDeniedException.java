package cn.tedu.store.service.ex;

/**
 * 异常类:客户端提交的数据不是通过正常用户提交
 * @author ZSP
 * @see ServiceException
 */
public class AccessDeniedException extends ServiceException{

	private static final long serialVersionUID = 3849396365637118465L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}
	
}
