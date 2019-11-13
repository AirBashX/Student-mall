package cn.tedu.store.service.ex;

/***
 * 文件异常类:上传头像State异常
 * @author ZSP
 *@see FileUploadException
 */
public class FileStateException extends FileUploadException{

	private static final long serialVersionUID = -3823378829811872830L;

	public FileStateException() {
		super();
	}

	public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileStateException(String message) {
		super(message);
	}

	public FileStateException(Throwable cause) {
		super(cause);
	}
	
}
