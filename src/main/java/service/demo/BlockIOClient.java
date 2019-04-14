package service.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class BlockIOClient {
	public static void main(String[] args) throws Exception {  
		BasicConfigurator.configure();
		
        // 设置传输通道 - 普通IO流通道  
        TTransport transport = new TSocket("localhost", 7911);  
        transport.open();  
          
        //使用高密度二进制协议  
        TProtocol protocol = new TCompactProtocol(transport);  
          
        //创建Client  
        Hello.Client client = new Hello.Client(protocol);  
          
        long start = System.currentTimeMillis();  
        for(int i=0; i<1; i++){  
            client.helloBoolean(false);  
            client.helloInt(111);  
            client.helloNull();  
            client.helloString("dongjian"); 
            client.helloVoid();  
        }  
        System.out.println("耗时：" + (System.currentTimeMillis() - start));  
          
        //关闭资源  
        transport.close();
    } 
}
