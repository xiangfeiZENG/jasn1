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


public class BasicServiceUsed implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 39);

	public byte[] code = null;
	private BasicService basicService = null;
	private ChargingTimeStamp chargingTimeStamp = null;
	private ChargeInformationList chargeInformationList = null;
	private HSCSDIndicator hSCSDIndicator = null;
	
	public BasicServiceUsed() {
	}

	public BasicServiceUsed(byte[] code) {
		this.code = code;
	}

	public void setBasicService(BasicService basicService) {
		this.basicService = basicService;
	}

	public BasicService getBasicService() {
		return basicService;
	}

	public void setChargingTimeStamp(ChargingTimeStamp chargingTimeStamp) {
		this.chargingTimeStamp = chargingTimeStamp;
	}

	public ChargingTimeStamp getChargingTimeStamp() {
		return chargingTimeStamp;
	}

	public void setChargeInformationList(ChargeInformationList chargeInformationList) {
		this.chargeInformationList = chargeInformationList;
	}

	public ChargeInformationList getChargeInformationList() {
		return chargeInformationList;
	}

	public void setHSCSDIndicator(HSCSDIndicator hSCSDIndicator) {
		this.hSCSDIndicator = hSCSDIndicator;
	}

	public HSCSDIndicator getHSCSDIndicator() {
		return hSCSDIndicator;
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
		if (hSCSDIndicator != null) {
			codeLength += hSCSDIndicator.encode(reverseOS, true);
		}
		
		if (chargeInformationList != null) {
			codeLength += chargeInformationList.encode(reverseOS, true);
		}
		
		if (chargingTimeStamp != null) {
			codeLength += chargingTimeStamp.encode(reverseOS, true);
		}
		
		if (basicService != null) {
			codeLength += basicService.encode(reverseOS, true);
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
		if (berTag.equals(BasicService.tag)) {
			basicService = new BasicService();
			subCodeLength += basicService.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargingTimeStamp.tag)) {
			chargingTimeStamp = new ChargingTimeStamp();
			subCodeLength += chargingTimeStamp.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargeInformationList.tag)) {
			chargeInformationList = new ChargeInformationList();
			subCodeLength += chargeInformationList.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(HSCSDIndicator.tag)) {
			hSCSDIndicator = new HSCSDIndicator();
			subCodeLength += hSCSDIndicator.decode(is, false);
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
		if (basicService != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("basicService: ");
			basicService.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (chargingTimeStamp != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargingTimeStamp: ");
			chargingTimeStamp.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (chargeInformationList != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeInformationList: ");
			chargeInformationList.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (hSCSDIndicator != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("hSCSDIndicator: ").append(hSCSDIndicator);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

