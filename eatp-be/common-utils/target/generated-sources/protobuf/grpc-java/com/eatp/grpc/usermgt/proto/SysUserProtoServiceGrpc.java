package com.eatp.grpc.usermgt.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: sysuser.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SysUserProtoServiceGrpc {

  private SysUserProtoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "SysUserProtoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.eatp.grpc.usermgt.proto.SysUserProtoRequest,
      com.eatp.grpc.usermgt.proto.SysUserProtoResponse> getCreateSysUserProtoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createSysUserProto",
      requestType = com.eatp.grpc.usermgt.proto.SysUserProtoRequest.class,
      responseType = com.eatp.grpc.usermgt.proto.SysUserProtoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.eatp.grpc.usermgt.proto.SysUserProtoRequest,
      com.eatp.grpc.usermgt.proto.SysUserProtoResponse> getCreateSysUserProtoMethod() {
    io.grpc.MethodDescriptor<com.eatp.grpc.usermgt.proto.SysUserProtoRequest, com.eatp.grpc.usermgt.proto.SysUserProtoResponse> getCreateSysUserProtoMethod;
    if ((getCreateSysUserProtoMethod = SysUserProtoServiceGrpc.getCreateSysUserProtoMethod) == null) {
      synchronized (SysUserProtoServiceGrpc.class) {
        if ((getCreateSysUserProtoMethod = SysUserProtoServiceGrpc.getCreateSysUserProtoMethod) == null) {
          SysUserProtoServiceGrpc.getCreateSysUserProtoMethod = getCreateSysUserProtoMethod =
              io.grpc.MethodDescriptor.<com.eatp.grpc.usermgt.proto.SysUserProtoRequest, com.eatp.grpc.usermgt.proto.SysUserProtoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createSysUserProto"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.eatp.grpc.usermgt.proto.SysUserProtoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.eatp.grpc.usermgt.proto.SysUserProtoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SysUserProtoServiceMethodDescriptorSupplier("createSysUserProto"))
              .build();
        }
      }
    }
    return getCreateSysUserProtoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysUserProtoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SysUserProtoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SysUserProtoServiceStub>() {
        @java.lang.Override
        public SysUserProtoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SysUserProtoServiceStub(channel, callOptions);
        }
      };
    return SysUserProtoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysUserProtoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SysUserProtoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SysUserProtoServiceBlockingStub>() {
        @java.lang.Override
        public SysUserProtoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SysUserProtoServiceBlockingStub(channel, callOptions);
        }
      };
    return SysUserProtoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysUserProtoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SysUserProtoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SysUserProtoServiceFutureStub>() {
        @java.lang.Override
        public SysUserProtoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SysUserProtoServiceFutureStub(channel, callOptions);
        }
      };
    return SysUserProtoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createSysUserProto(com.eatp.grpc.usermgt.proto.SysUserProtoRequest request,
        io.grpc.stub.StreamObserver<com.eatp.grpc.usermgt.proto.SysUserProtoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSysUserProtoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SysUserProtoService.
   */
  public static abstract class SysUserProtoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SysUserProtoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SysUserProtoService.
   */
  public static final class SysUserProtoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SysUserProtoServiceStub> {
    private SysUserProtoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysUserProtoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SysUserProtoServiceStub(channel, callOptions);
    }

    /**
     */
    public void createSysUserProto(com.eatp.grpc.usermgt.proto.SysUserProtoRequest request,
        io.grpc.stub.StreamObserver<com.eatp.grpc.usermgt.proto.SysUserProtoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSysUserProtoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SysUserProtoService.
   */
  public static final class SysUserProtoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SysUserProtoServiceBlockingStub> {
    private SysUserProtoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysUserProtoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SysUserProtoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.eatp.grpc.usermgt.proto.SysUserProtoResponse createSysUserProto(com.eatp.grpc.usermgt.proto.SysUserProtoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSysUserProtoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SysUserProtoService.
   */
  public static final class SysUserProtoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SysUserProtoServiceFutureStub> {
    private SysUserProtoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysUserProtoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SysUserProtoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.eatp.grpc.usermgt.proto.SysUserProtoResponse> createSysUserProto(
        com.eatp.grpc.usermgt.proto.SysUserProtoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSysUserProtoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SYS_USER_PROTO = 0;

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
        case METHODID_CREATE_SYS_USER_PROTO:
          serviceImpl.createSysUserProto((com.eatp.grpc.usermgt.proto.SysUserProtoRequest) request,
              (io.grpc.stub.StreamObserver<com.eatp.grpc.usermgt.proto.SysUserProtoResponse>) responseObserver);
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
          getCreateSysUserProtoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.eatp.grpc.usermgt.proto.SysUserProtoRequest,
              com.eatp.grpc.usermgt.proto.SysUserProtoResponse>(
                service, METHODID_CREATE_SYS_USER_PROTO)))
        .build();
  }

  private static abstract class SysUserProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysUserProtoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.eatp.grpc.usermgt.proto.SysUserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysUserProtoService");
    }
  }

  private static final class SysUserProtoServiceFileDescriptorSupplier
      extends SysUserProtoServiceBaseDescriptorSupplier {
    SysUserProtoServiceFileDescriptorSupplier() {}
  }

  private static final class SysUserProtoServiceMethodDescriptorSupplier
      extends SysUserProtoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SysUserProtoServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SysUserProtoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysUserProtoServiceFileDescriptorSupplier())
              .addMethod(getCreateSysUserProtoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
