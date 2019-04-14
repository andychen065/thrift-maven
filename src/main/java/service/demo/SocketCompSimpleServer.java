package service.demo;

import org.apache.log4j.BasicConfigurator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

public class SocketCompSimpleServer {
	/** 
     * ����ʽ�����̴߳��� 
     *  
     * @param args 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static void main(String[] args) {  
        try {  
        	BasicConfigurator.configure();
        	
            TServerTransport serverTransport = new TServerSocket(7911);  
              
            TProtocolFactory proFactory = new TCompactProtocol.Factory();  
              
            TProcessor processor = new Hello.Processor(new HelloImpl());  
              
            TServer server = new TSimpleServer(  
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
