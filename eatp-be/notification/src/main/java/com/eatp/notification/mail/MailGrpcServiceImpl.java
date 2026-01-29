package com.eatp.notification.mail;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.eatp.common.enums.MailTemplate;
import com.eatp.common.utils.GrpcUtils;
import com.eatp.common.utils.SystemUtils;
import com.eatp.grpc.notification.MailProtoRequest;
import com.eatp.grpc.notification.MailProtoServiceGrpc.MailProtoServiceImplBase;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;

@Service
public class MailGrpcServiceImpl extends MailProtoServiceImplBase{

	private final MailService mailService;

	public MailGrpcServiceImpl(MailService mailService) {
		super();
		this.mailService = mailService;
	}

	@Override
	public void sendMail(MailProtoRequest request, StreamObserver<Empty> responseObserver) {
		try {
			Map<String, Any> reqVariables = request.getVariablesMap();
			Map<String, Object> variables = new HashMap<String, Object>();
			for(Entry<String, Any> entry:reqVariables.entrySet()) {
				variables.put(entry.getKey(),GrpcUtils.unpackGrpcValue(entry.getValue()));
			}
			MailRequest mailRequest = new MailRequest("admin@atp.com", request.getRecipient(), SystemUtils.getMailSubject(MailTemplate.getByCode(request.getTemplateCode())), MailTemplate.getByCode(request.getTemplateCode()).getTemplateName(), variables);
			mailService.sendHtmlMail(mailRequest);
			responseObserver.onNext(Empty.newBuilder().build());
			responseObserver.onCompleted();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
