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
     * 阻塞式、多线程处理 
     *  
     * @param args 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static void main(String[] args) {  
        try {  
        	BasicConfigurator.configure();
        	
            //设置传输通道，普通通道  
            TServerTransport serverTransport = new TServerSocket(7911);  
              
            //使用高密度二进制协议  
            TProtocolFactory proFactory = new TCompactProtocol.Factory();  
              
            //设置处理器HelloImpl  
            TProcessor processor = new Hello.Processor(new HelloImpl());  
              
            //创建服务器  
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
