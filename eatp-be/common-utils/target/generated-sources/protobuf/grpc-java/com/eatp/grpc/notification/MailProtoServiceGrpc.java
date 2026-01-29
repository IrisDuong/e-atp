package com.eatp.grpc.notification;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: mailrequest.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MailProtoServiceGrpc {

  private MailProtoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "MailProtoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.eatp.grpc.notification.MailProtoRequest,
      com.google.protobuf.Empty> getSendMailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMail",
      requestType = com.eatp.grpc.notification.MailProtoRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.eatp.grpc.notification.MailProtoRequest,
      com.google.protobuf.Empty> getSendMailMethod() {
    io.grpc.MethodDescriptor<com.eatp.grpc.notification.MailProtoRequest, com.google.protobuf.Empty> getSendMailMethod;
    if ((getSendMailMethod = MailProtoServiceGrpc.getSendMailMethod) == null) {
      synchronized (MailProtoServiceGrpc.class) {
        if ((getSendMailMethod = MailProtoServiceGrpc.getSendMailMethod) == null) {
          MailProtoServiceGrpc.getSendMailMethod = getSendMailMethod =
              io.grpc.MethodDescriptor.<com.eatp.grpc.notification.MailProtoRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.eatp.grpc.notification.MailProtoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MailProtoServiceMethodDescriptorSupplier("sendMail"))
              .build();
        }
      }
    }
    return getSendMailMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MailProtoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MailProtoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MailProtoServiceStub>() {
        @java.lang.Override
        public MailProtoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MailProtoServiceStub(channel, callOptions);
        }
      };
    return MailProtoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MailProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MailProtoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MailProtoServiceBlockingStub>() {
        @java.lang.Override
        public MailProtoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MailProtoServiceBlockingStub(channel, callOptions);
        }
      };
    return MailProtoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MailProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MailProtoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MailProtoServiceFutureStub>() {
        @java.lang.Override
        public MailProtoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MailProtoServiceFutureStub(channel, callOptions);
        }
      };
    return MailProtoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sendMail(com.eatp.grpc.notification.MailProtoRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMailMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MailProtoService.
   */
  public static abstract class MailProtoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MailProtoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MailProtoService.
   */
  public static final class MailProtoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MailProtoServiceStub> {
    private MailProtoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MailProtoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MailProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendMail(com.eatp.grpc.notification.MailProtoRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMailMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MailProtoService.
   */
  public static final class MailProtoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MailProtoServiceBlockingStub> {
    private MailProtoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MailProtoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MailProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty sendMail(com.eatp.grpc.notification.MailProtoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMailMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MailProtoService.
   */
  public static final class MailProtoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MailProtoServiceFutureStub> {
    private MailProtoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MailProtoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MailProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> sendMail(
        com.eatp.grpc.notification.MailProtoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MAIL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MAIL:
          serviceImpl.sendMail((com.eatp.grpc.notification.MailProtoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendMailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.eatp.grpc.notification.MailProtoRequest,
              com.google.protobuf.Empty>(
                service, METHODID_SEND_MAIL)))
        .build();
  }

  private static abstract class MailProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MailProtoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.eatp.grpc.notification.MailProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MailProtoService");
    }
  }

  private static final class MailProtoServiceFileDescriptorSupplier
      extends MailProtoServiceBaseDescriptorSupplier {
    MailProtoServiceFileDescriptorSupplier() {}
  }

  private static final class MailProtoServiceMethodDescriptorSupplier
      extends MailProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MailProtoServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MailProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MailProtoServiceFileDescriptorSupplier())
              .addMethod(getSendMailMethod())
              .build();
        }
      }
    }
    return result;
  }
}
