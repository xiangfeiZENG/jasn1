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


public class MobileTerminatedCall implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 10);

	public byte[] code = null;
	private MtBasicCallInformation basicCallInformation = null;
	private LocationInformation locationInformation = null;
	private ImeiOrEsn equipmentIdentifier = null;
	private BasicServiceUsedList basicServiceUsedList = null;
	private CamelServiceUsed camelServiceUsed = null;
	private OperatorSpecInfoList operatorSpecInformation = null;
	
	public MobileTerminatedCall() {
	}

	public MobileTerminatedCall(byte[] code) {
		this.code = code;
	}

	public void setBasicCallInformation(MtBasicCallInformation basicCallInformation) {
		this.basicCallInformation = basicCallInformation;
	}

	public MtBasicCallInformation getBasicCallInformation() {
		return basicCallInformation;
	}

	public void setLocationInformation(LocationInformation locationInformation) {
		this.locationInformation = locationInformation;
	}

	public LocationInformation getLocationInformation() {
		return locationInformation;
	}

	public void setEquipmentIdentifier(ImeiOrEsn equipmentIdentifier) {
		this.equipmentIdentifier = equipmentIdentifier;
	}

	public ImeiOrEsn getEquipmentIdentifier() {
		return equipmentIdentifier;
	}

	public void setBasicServiceUsedList(BasicServiceUsedList basicServiceUsedList) {
		this.basicServiceUsedList = basicServiceUsedList;
	}

	public BasicServiceUsedList getBasicServiceUsedList() {
		return basicServiceUsedList;
	}

	public void setCamelServiceUsed(CamelServiceUsed camelServiceUsed) {
		this.camelServiceUsed = camelServiceUsed;
	}

	public CamelServiceUsed getCamelServiceUsed() {
		return camelServiceUsed;
	}

	public void setOperatorSpecInformation(OperatorSpecInfoList operatorSpecInformation) {
		this.operatorSpecInformation = operatorSpecInformation;
	}

	public OperatorSpecInfoList getOperatorSpecInformation() {
		return operatorSpecInformation;
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
		if (operatorSpecInformation != null) {
			codeLength += operatorSpecInformation.encode(reverseOS, true);
		}
		
		if (camelServiceUsed != null) {
			codeLength += camelServiceUsed.encode(reverseOS, true);
		}
		
		if (basicServiceUsedList != null) {
			codeLength += basicServiceUsedList.encode(reverseOS, true);
		}
		
		if (equipmentIdentifier != null) {
			codeLength += equipmentIdentifier.encode(reverseOS, true);
		}
		
		if (locationInformation != null) {
			codeLength += locationInformation.encode(reverseOS, true);
		}
		
		if (basicCallInformation != null) {
			codeLength += basicCallInformation.encode(reverseOS, true);
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
		if (berTag.equals(MtBasicCallInformation.tag)) {
			basicCallInformation = new MtBasicCallInformation();
			subCodeLength += basicCallInformation.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(LocationInformation.tag)) {
			locationInformation = new LocationInformation();
			subCodeLength += locationInformation.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ImeiOrEsn.tag)) {
			equipmentIdentifier = new ImeiOrEsn();
			subCodeLength += equipmentIdentifier.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(BasicServiceUsedList.tag)) {
			basicServiceUsedList = new BasicServiceUsedList();
			subCodeLength += basicServiceUsedList.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CamelServiceUsed.tag)) {
			camelServiceUsed = new CamelServiceUsed();
			subCodeLength += camelServiceUsed.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(OperatorSpecInfoList.tag)) {
			operatorSpecInformation = new OperatorSpecInfoList();
			subCodeLength += operatorSpecInformation.decode(is, false);
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
		if (basicCallInformation != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("basicCallInformation: ");
			basicCallInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (locationInformation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("locationInformation: ");
			locationInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (equipmentIdentifier != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("equipmentIdentifier: ");
			equipmentIdentifier.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (basicServiceUsedList != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("basicServiceUsedList: ");
			basicServiceUsedList.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (camelServiceUsed != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("camelServiceUsed: ");
			camelServiceUsed.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (operatorSpecInformation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("operatorSpecInformation: ");
			operatorSpecInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

