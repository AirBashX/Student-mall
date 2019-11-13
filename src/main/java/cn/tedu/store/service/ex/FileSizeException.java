package cn.tedu.store.service.ex;

/**
 * 文件异常类:文件大小异常
 * @author ZSP
 * @see FileUploadException
 */
public class FileSizeException extends FileUploadException{

	private static final long serialVersionUID = -941973505872431866L;

	public FileSizeException() {
		super();
	}

	public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileSizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileSizeException(String message) {
		super(message);
	}

	public FileSizeException(Throwable cause) {
		super(cause);
	}
	
}
