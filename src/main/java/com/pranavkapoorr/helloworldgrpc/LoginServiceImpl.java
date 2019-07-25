package com.pranavkapoorr.helloworldgrpc;

import com.pranavkapoorr.helloworldgrpc.LoginServiceOuterClass.LoginRequest;
import com.pranavkapoorr.helloworldgrpc.LoginServiceOuterClass.LoginResponse;

import io.grpc.stub.StreamObserver;

public class LoginServiceImpl extends LoginServiceGrpc.LoginServiceImplBase  {

    @Override
    public void logIn(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        System.out.println(request);

        responseObserver
                .onNext(checkLoginCredential(request.getUsername(), request.getPassword()));

        responseObserver.onCompleted();
    }

    private LoginResponse checkLoginCredential(String username, String password) {
       LoginResponse.Builder responseBuilder = LoginResponse.newBuilder();
        if (username.equals(password)) {
            responseBuilder.setResponseCode(200)
                    .setMessage("Login Success");
        } else {
            responseBuilder.setResponseCode(400)
                    .setMessage("Login Failed");
        }

        return responseBuilder.build();
    }

}