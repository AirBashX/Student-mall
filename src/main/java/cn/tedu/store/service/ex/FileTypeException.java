package cn.tedu.store.service.ex;

/**
 * 文件异常类:文件类型错误
 * @author ZSP
 *@see FileUploadException
 */
public class FileTypeException extends FileUploadException{

	private static final long serialVersionUID = -2954625341334072887L;

	public FileTypeException() {
		super();
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileTypeException(String message) {
		super(message);
	}

	public FileTypeException(Throwable cause) {
		super(cause);
	}
	
}
