package cn.tedu.store.service.ex;

/**
 * 文件异常基类:文件上传错误
 * @author ZSP
 */
public class FileUploadException extends RuntimeException{

	private static final long serialVersionUID = -5187037827166791187L;

	public FileUploadException() {
		super();
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}
	
}
