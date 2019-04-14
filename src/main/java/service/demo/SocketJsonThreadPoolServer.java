package service.demo;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException; 
 
public class SocketJsonThreadPoolServer { 
   /** 
    * 启动 Thrift 服务器
    * @param args 
    */ 
   public static void main(String[] args) {
       try { 
           // 设置服务端口为 7911 
    	   TServerTransport serverTransport = new TServerSocket(7911);
           
           TProtocolFactory proFactory = new TJSONProtocol.Factory();
           
           // 关联处理器与 Hello 服务的实现
           TProcessor processor = new Hello.Processor(new HelloImpl());
           
           //TServer server = new TThreadPoolServer(processor, serverTransport, proFactory); 
           TServer server = new TThreadPoolServer(new Args(serverTransport)
        		   .protocolFactory(proFactory)
                   .processor(processor));
           System.out.println("Start server on port 7911..."); 
           server.serve(); 
       } catch (TTransportException e) { 
           e.printStackTrace(); 
       } 
   } 
}