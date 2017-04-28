package base.cn.exception;

import com.accountmanage.web.bills.util.BillReturnEnum;

public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5316020414225262256L;

	private BillReturnEnum returnEnum;
	
	public BaseException() {
	}
	
	
	public BaseException(String message) {
		super(message);
	}

	public BaseException(BillReturnEnum returnEnum){
		this.returnEnum = returnEnum;
	}


	public BillReturnEnum getReturnEnum() {
		return returnEnum;
	}


	public void setReturnEnum(BillReturnEnum returnEnum) {
		this.returnEnum = returnEnum;
	}
	
}
