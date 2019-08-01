/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.tap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;


public class CallEventDetail implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	private MobileOriginatedCall mobileOriginatedCall = null;
	private MobileTerminatedCall mobileTerminatedCall = null;
	private SupplServiceEvent supplServiceEvent = null;
	private ServiceCentreUsage serviceCentreUsage = null;
	private GprsCall gprsCall = null;
	private ContentTransaction contentTransaction = null;
	private LocationService locationService = null;
	private MessagingEvent messagingEvent = null;
	private MobileSession mobileSession = null;
	
	public CallEventDetail() {
	}

	public CallEventDetail(byte[] code) {
		this.code = code;
	}

	public void setMobileOriginatedCall(MobileOriginatedCall mobileOriginatedCall) {
		this.mobileOriginatedCall = mobileOriginatedCall;
	}

	public MobileOriginatedCall getMobileOriginatedCall() {
		return mobileOriginatedCall;
	}

	public void setMobileTerminatedCall(MobileTerminatedCall mobileTerminatedCall) {
		this.mobileTerminatedCall = mobileTerminatedCall;
	}

	public MobileTerminatedCall getMobileTerminatedCall() {
		return mobileTerminatedCall;
	}

	public void setSupplServiceEvent(SupplServiceEvent supplServiceEvent) {
		this.supplServiceEvent = supplServiceEvent;
	}

	public SupplServiceEvent getSupplServiceEvent() {
		return supplServiceEvent;
	}

	public void setServiceCentreUsage(ServiceCentreUsage serviceCentreUsage) {
		this.serviceCentreUsage = serviceCentreUsage;
	}

	public ServiceCentreUsage getServiceCentreUsage() {
		return serviceCentreUsage;
	}

	public void setGprsCall(GprsCall gprsCall) {
		this.gprsCall = gprsCall;
	}

	public GprsCall getGprsCall() {
		return gprsCall;
	}

	public void setContentTransaction(ContentTransaction contentTransaction) {
		this.contentTransaction = contentTransaction;
	}

	public ContentTransaction getContentTransaction() {
		return contentTransaction;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setMessagingEvent(MessagingEvent messagingEvent) {
		this.messagingEvent = messagingEvent;
	}

	public MessagingEvent getMessagingEvent() {
		return messagingEvent;
	}

	public void setMobileSession(MobileSession mobileSession) {
		this.mobileSession = mobileSession;
	}

	public MobileSession getMobileSession() {
		return mobileSession;
	}

	public int encode(OutputStream reverseOS) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			return code.length;
		}

		int codeLength = 0;
		if (mobileSession != null) {
			codeLength += mobileSession.encode(reverseOS, true);
			return codeLength;
		}
		
		if (messagingEvent != null) {
			codeLength += messagingEvent.encode(reverseOS, true);
			return codeLength;
		}
		
		if (locationService != null) {
			codeLength += locationService.encode(reverseOS, true);
			return codeLength;
		}
		
		if (contentTransaction != null) {
			codeLength += contentTransaction.encode(reverseOS, true);
			return codeLength;
		}
		
		if (gprsCall != null) {
			codeLength += gprsCall.encode(reverseOS, true);
			return codeLength;
		}
		
		if (serviceCentreUsage != null) {
			codeLength += serviceCentreUsage.encode(reverseOS, true);
			return codeLength;
		}
		
		if (supplServiceEvent != null) {
			codeLength += supplServiceEvent.encode(reverseOS, true);
			return codeLength;
		}
		
		if (mobileTerminatedCall != null) {
			codeLength += mobileTerminatedCall.encode(reverseOS, true);
			return codeLength;
		}
		
		if (mobileOriginatedCall != null) {
			codeLength += mobileOriginatedCall.encode(reverseOS, true);
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, null);
	}

	public int decode(InputStream is, BerTag berTag) throws IOException {

		int codeLength = 0;
		BerTag passedTag = berTag;

		if (berTag == null) {
			berTag = new BerTag();
			codeLength += berTag.decode(is);
		}

		if (berTag.equals(MobileOriginatedCall.tag)) {
			mobileOriginatedCall = new MobileOriginatedCall();
			codeLength += mobileOriginatedCall.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(MobileTerminatedCall.tag)) {
			mobileTerminatedCall = new MobileTerminatedCall();
			codeLength += mobileTerminatedCall.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(SupplServiceEvent.tag)) {
			supplServiceEvent = new SupplServiceEvent();
			codeLength += supplServiceEvent.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(ServiceCentreUsage.tag)) {
			serviceCentreUsage = new ServiceCentreUsage();
			codeLength += serviceCentreUsage.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(GprsCall.tag)) {
			gprsCall = new GprsCall();
			codeLength += gprsCall.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(ContentTransaction.tag)) {
			contentTransaction = new ContentTransaction();
			codeLength += contentTransaction.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(LocationService.tag)) {
			locationService = new LocationService();
			codeLength += locationService.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(MessagingEvent.tag)) {
			messagingEvent = new MessagingEvent();
			codeLength += messagingEvent.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(MobileSession.tag)) {
			mobileSession = new MobileSession();
			codeLength += mobileSession.decode(is, false);
			return codeLength;
		}

		if (passedTag != null) {
			return 0;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (mobileOriginatedCall != null) {
			sb.append("mobileOriginatedCall: ");
			mobileOriginatedCall.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (mobileTerminatedCall != null) {
			sb.append("mobileTerminatedCall: ");
			mobileTerminatedCall.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (supplServiceEvent != null) {
			sb.append("supplServiceEvent: ");
			supplServiceEvent.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (serviceCentreUsage != null) {
			sb.append("serviceCentreUsage: ");
			serviceCentreUsage.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (gprsCall != null) {
			sb.append("gprsCall: ");
			gprsCall.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (contentTransaction != null) {
			sb.append("contentTransaction: ");
			contentTransaction.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (locationService != null) {
			sb.append("locationService: ");
			locationService.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (messagingEvent != null) {
			sb.append("messagingEvent: ");
			messagingEvent.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (mobileSession != null) {
			sb.append("mobileSession: ");
			mobileSession.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

