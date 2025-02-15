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


public class ScuChargeType implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 192);

	public byte[] code = null;
	private MessageStatus messageStatus = null;
	private PriorityCode priorityCode = null;
	private DistanceChargeBandCode distanceChargeBandCode = null;
	private MessageType messageType = null;
	private MessageDescriptionCode messageDescriptionCode = null;
	
	public ScuChargeType() {
	}

	public ScuChargeType(byte[] code) {
		this.code = code;
	}

	public void setMessageStatus(MessageStatus messageStatus) {
		this.messageStatus = messageStatus;
	}

	public MessageStatus getMessageStatus() {
		return messageStatus;
	}

	public void setPriorityCode(PriorityCode priorityCode) {
		this.priorityCode = priorityCode;
	}

	public PriorityCode getPriorityCode() {
		return priorityCode;
	}

	public void setDistanceChargeBandCode(DistanceChargeBandCode distanceChargeBandCode) {
		this.distanceChargeBandCode = distanceChargeBandCode;
	}

	public DistanceChargeBandCode getDistanceChargeBandCode() {
		return distanceChargeBandCode;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageDescriptionCode(MessageDescriptionCode messageDescriptionCode) {
		this.messageDescriptionCode = messageDescriptionCode;
	}

	public MessageDescriptionCode getMessageDescriptionCode() {
		return messageDescriptionCode;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (messageDescriptionCode != null) {
			codeLength += messageDescriptionCode.encode(reverseOS, true);
		}
		
		if (messageType != null) {
			codeLength += messageType.encode(reverseOS, true);
		}
		
		if (distanceChargeBandCode != null) {
			codeLength += distanceChargeBandCode.encode(reverseOS, true);
		}
		
		if (priorityCode != null) {
			codeLength += priorityCode.encode(reverseOS, true);
		}
		
		if (messageStatus != null) {
			codeLength += messageStatus.encode(reverseOS, true);
		}
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berTag.decode(is);
		if (berTag.equals(MessageStatus.tag)) {
			messageStatus = new MessageStatus();
			subCodeLength += messageStatus.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(PriorityCode.tag)) {
			priorityCode = new PriorityCode();
			subCodeLength += priorityCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(DistanceChargeBandCode.tag)) {
			distanceChargeBandCode = new DistanceChargeBandCode();
			subCodeLength += distanceChargeBandCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(MessageType.tag)) {
			messageType = new MessageType();
			subCodeLength += messageType.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(MessageDescriptionCode.tag)) {
			messageDescriptionCode = new MessageDescriptionCode();
			subCodeLength += messageDescriptionCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (messageStatus != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("messageStatus: ").append(messageStatus);
			firstSelectedElement = false;
		}
		
		if (priorityCode != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("priorityCode: ").append(priorityCode);
			firstSelectedElement = false;
		}
		
		if (distanceChargeBandCode != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("distanceChargeBandCode: ").append(distanceChargeBandCode);
			firstSelectedElement = false;
		}
		
		if (messageType != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("messageType: ").append(messageType);
			firstSelectedElement = false;
		}
		
		if (messageDescriptionCode != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("messageDescriptionCode: ").append(messageDescriptionCode);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

