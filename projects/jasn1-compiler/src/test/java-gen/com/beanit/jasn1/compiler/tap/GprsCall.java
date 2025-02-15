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


public class GprsCall implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 14);

	public byte[] code = null;
	private GprsBasicCallInformation gprsBasicCallInformation = null;
	private GprsLocationInformation gprsLocationInformation = null;
	private ImeiOrEsn equipmentIdentifier = null;
	private GprsServiceUsed gprsServiceUsed = null;
	private CamelServiceUsed camelServiceUsed = null;
	private OperatorSpecInfoList operatorSpecInformation = null;
	
	public GprsCall() {
	}

	public GprsCall(byte[] code) {
		this.code = code;
	}

	public void setGprsBasicCallInformation(GprsBasicCallInformation gprsBasicCallInformation) {
		this.gprsBasicCallInformation = gprsBasicCallInformation;
	}

	public GprsBasicCallInformation getGprsBasicCallInformation() {
		return gprsBasicCallInformation;
	}

	public void setGprsLocationInformation(GprsLocationInformation gprsLocationInformation) {
		this.gprsLocationInformation = gprsLocationInformation;
	}

	public GprsLocationInformation getGprsLocationInformation() {
		return gprsLocationInformation;
	}

	public void setEquipmentIdentifier(ImeiOrEsn equipmentIdentifier) {
		this.equipmentIdentifier = equipmentIdentifier;
	}

	public ImeiOrEsn getEquipmentIdentifier() {
		return equipmentIdentifier;
	}

	public void setGprsServiceUsed(GprsServiceUsed gprsServiceUsed) {
		this.gprsServiceUsed = gprsServiceUsed;
	}

	public GprsServiceUsed getGprsServiceUsed() {
		return gprsServiceUsed;
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
		
		if (gprsServiceUsed != null) {
			codeLength += gprsServiceUsed.encode(reverseOS, true);
		}
		
		if (equipmentIdentifier != null) {
			codeLength += equipmentIdentifier.encode(reverseOS, true);
		}
		
		if (gprsLocationInformation != null) {
			codeLength += gprsLocationInformation.encode(reverseOS, true);
		}
		
		if (gprsBasicCallInformation != null) {
			codeLength += gprsBasicCallInformation.encode(reverseOS, true);
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
		if (berTag.equals(GprsBasicCallInformation.tag)) {
			gprsBasicCallInformation = new GprsBasicCallInformation();
			subCodeLength += gprsBasicCallInformation.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(GprsLocationInformation.tag)) {
			gprsLocationInformation = new GprsLocationInformation();
			subCodeLength += gprsLocationInformation.decode(is, false);
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
		
		if (berTag.equals(GprsServiceUsed.tag)) {
			gprsServiceUsed = new GprsServiceUsed();
			subCodeLength += gprsServiceUsed.decode(is, false);
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
		if (gprsBasicCallInformation != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("gprsBasicCallInformation: ");
			gprsBasicCallInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (gprsLocationInformation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("gprsLocationInformation: ");
			gprsLocationInformation.appendAsString(sb, indentLevel + 1);
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
		
		if (gprsServiceUsed != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("gprsServiceUsed: ");
			gprsServiceUsed.appendAsString(sb, indentLevel + 1);
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

