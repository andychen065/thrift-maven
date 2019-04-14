package service.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class SocketCompThreadPoolClient {
	public static void main(String[] args) throws Exception {  
		BasicConfigurator.configure();
		
        // ���ô���ͨ�� - ��ͨIO��ͨ��  
        TTransport transport = new TSocket("localhost", 7911);  
        transport.open();  
          
        //ʹ�ø��ܶȶ�����Э��  
        TProtocol protocol = new TCompactProtocol(transport);  
          
        //����Client  
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
