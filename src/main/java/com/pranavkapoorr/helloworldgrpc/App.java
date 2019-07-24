package com.pranavkapoorr.helloworldgrpc;

//import com.pranavkapoorr.helloworldgrpc.services.LoginServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
	public static void main(String[] arg) {
        try {
            Server server = ServerBuilder.forPort(8080)
                    //.addService(new LoginServiceImpl())
                    .build();
            System.out.println("Starting Server......");
            server.start();
            System.out.println("Server has started ========");

            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}