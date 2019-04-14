package service.demo;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

public class NonblockFramedCompThreadSelClient {
	public static void main(String[] args) throws Exception {  
        //���ô���ͨ�������ڷ�����������Ҫʹ��TFramedTransport���������ݷֿ鷢��  
        TTransport transport = new TFramedTransport(new TSocket("localhost", 7911));  
        transport.open();  
          
        //ʹ�ø��ܶȶ�����Э��  
        TProtocol protocol = new TCompactProtocol(transport);  
          
        //����Client  
        Hello.Client client = new Hello.Client(protocol);  
          
        long start = System.currentTimeMillis();  
        for(int i=0; i<10000; i++){  
            client.helloBoolean(false);  
            client.helloInt(111);  
            client.helloNull();  
            client.helloString("360buy");  
            client.helloVoid();  
        }  
        System.out.println("��ʱ��" + (System.currentTimeMillis() - start));  
          
        //�ر���Դ  
        transport.close();  
    }  
}
