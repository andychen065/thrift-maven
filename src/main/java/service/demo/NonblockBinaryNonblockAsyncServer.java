package service.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TNonblockingServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TTransportException; 
 
public class NonblockBinaryNonblockAsyncServer { 
   /** 
    * 启动 Thrift 异步服务器
    * @param args 
    */ 
   public static void main(String[] args) { 
       TNonblockingServerTransport serverTransport; 
       try { 
           serverTransport = new TNonblockingServerSocket(10005);
           
           Hello.Processor processor = new Hello.Processor(new HelloImpl());
           
           TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(); 
           
           TServer server = new TNonblockingServer( 
        		   new Args(serverTransport)
        		   .processor(processor)
        		   .protocolFactory(proFactory)); 
           System.out.println("Start server on port 10005 ..."); 
           server.serve(); 
       } catch (TTransportException e) { 
           e.printStackTrace(); 
       } 
   } 
}
