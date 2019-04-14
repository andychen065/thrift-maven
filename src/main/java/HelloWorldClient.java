import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class HelloWorldClient {
	public static final int SERVER_PORT = 7099;
	public static final String SERVER_IP = "localhost";

	public void startClient(String username) {
		TTransport tTransport = null;
		try {
			tTransport = new TSocket(SERVER_IP, SERVER_PORT);
			// 协议要和服务端一致
			TProtocol protocol = new TBinaryProtocol(tTransport);
			HelloWorldService.Client client = new HelloWorldService.Client(protocol);
			tTransport.open();
			String result = client.sayHello(username);
			System.out.println("Thrift client result=" + result);
			result = client.getRandom();
			System.out.println("Thrift client result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HelloWorldClient client = new HelloWorldClient();
		client.startClient("chenxiaochan");
	}
}