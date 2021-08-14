package kodlama.io.hrms.core.utilities.results;

import lombok.Getter;

@Getter
//<T> Generic 
public class DataResult<T> extends Result {

	T data; // Ref Tutucu

	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;

	}

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;

	}

	public T getData() {
		return this.data;
	}

}
