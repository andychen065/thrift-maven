package service.demo;

import org.apache.thrift.async.AsyncMethodCallback; 

public class MethodCallback implements AsyncMethodCallback { 
	Object response = null; 

	public Object getResult() { 
		// 杩斿洖缁撴灉鍊�
		return this.response; 
	} 

	public void onComplete(Object response) { 
		this.response = response; 
	} 
	// 澶勭悊璋冪敤鏈嶅姟杩囩▼涓嚭鐜扮殑寮傚父

	public void onError(Exception exception) {
		exception.printStackTrace();
	} 
}