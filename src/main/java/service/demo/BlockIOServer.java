package service.demo;

import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class BlockIOServer {
	/** 
     * ����ʽ�����̴߳��� 
     *  
     * @param args 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static void main(String[] args) {  
        try {  
        	BasicConfigurator.configure();
        	
            //���ô���ͨ������ͨͨ��  
            TServerTransport serverTransport = new TServerSocket(7911);  
              
            //ʹ�ø��ܶȶ�����Э��  
            TProtocolFactory proFactory = new TCompactProtocol.Factory();  
              
            //���ô�����HelloImpl  
            TProcessor processor = new Hello.Processor(new HelloImpl());  
              
            //����������  
            TServer server = new TThreadPoolServer(  
                    new Args(serverTransport)  
                    .protocolFactory(proFactory)  
                    .processor(processor)
                );
              
            System.out.println("Start server on port 7911...");
            server.serve();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
