package service.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.server.TThreadedSelectorServer.Args;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportFactory;

public class NonblockFramedCompThreadSelServer {
	public static void main(String[] args) {  
        try {  
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(7911);  
              
            TTransportFactory transportFactory = new TFramedTransport.Factory();  
              
            TProtocolFactory proFactory = new TCompactProtocol.Factory();  
              
            TProcessor processor = new Hello.Processor(new HelloImpl());
              
            TServer server = new TThreadedSelectorServer(  
                    new Args(serverTransport)
                    .protocolFactory(proFactory)
                    .transportFactory(transportFactory)
                    .processor(processor)
                );  
             
            System.out.println("Start server on port 7911...");  
            server.serve();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
