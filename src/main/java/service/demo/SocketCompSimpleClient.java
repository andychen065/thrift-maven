package service.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class SocketCompSimpleClient {
	public static void main(String[] args) throws Exception {  
		BasicConfigurator.configure();
		
        TTransport transport = new TSocket("localhost", 7911);  
        transport.open();  
          
        TProtocol protocol = new TCompactProtocol(transport);  
          
        Hello.Client client = new Hello.Client(protocol);  
          
        long start = System.currentTimeMillis();  
        for(int i=0; i<1; i++){  
            client.helloBoolean(false);  
            client.helloInt(111);  
            client.helloNull();  
            client.helloString("dongjian"); 
            client.helloVoid();  
        }  
        System.out.println("��ʱ��" + (System.currentTimeMillis() - start));  
          
        //�ر���Դ  
        transport.close();
    } 
}
