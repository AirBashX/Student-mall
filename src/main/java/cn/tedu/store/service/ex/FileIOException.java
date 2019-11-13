package cn.tedu.store.service.ex;

/***
 * 文件异常类:上传文件IO异常
 * @author ZSP
 *@see FileUploadException
 */
public class FileIOException extends FileUploadException{

	private static final long serialVersionUID = -3823378829811872830L;

	public FileIOException() {
		super();
	}

	public FileIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileIOException(String message) {
		super(message);
	}

	public FileIOException(Throwable cause) {
		super(cause);
	}
	
}
