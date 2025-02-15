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


public class GprsServiceUsed implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 121);

	public byte[] code = null;
	private IMSSignallingContext iMSSignallingContext = null;
	private DataVolumeIncoming dataVolumeIncoming = null;
	private DataVolumeOutgoing dataVolumeOutgoing = null;
	private ChargeInformationList chargeInformationList = null;
	
	public GprsServiceUsed() {
	}

	public GprsServiceUsed(byte[] code) {
		this.code = code;
	}

	public void setIMSSignallingContext(IMSSignallingContext iMSSignallingContext) {
		this.iMSSignallingContext = iMSSignallingContext;
	}

	public IMSSignallingContext getIMSSignallingContext() {
		return iMSSignallingContext;
	}

	public void setDataVolumeIncoming(DataVolumeIncoming dataVolumeIncoming) {
		this.dataVolumeIncoming = dataVolumeIncoming;
	}

	public DataVolumeIncoming getDataVolumeIncoming() {
		return dataVolumeIncoming;
	}

	public void setDataVolumeOutgoing(DataVolumeOutgoing dataVolumeOutgoing) {
		this.dataVolumeOutgoing = dataVolumeOutgoing;
	}

	public DataVolumeOutgoing getDataVolumeOutgoing() {
		return dataVolumeOutgoing;
	}

	public void setChargeInformationList(ChargeInformationList chargeInformationList) {
		this.chargeInformationList = chargeInformationList;
	}

	public ChargeInformationList getChargeInformationList() {
		return chargeInformationList;
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
		if (chargeInformationList != null) {
			codeLength += chargeInformationList.encode(reverseOS, true);
		}
		
		if (dataVolumeOutgoing != null) {
			codeLength += dataVolumeOutgoing.encode(reverseOS, true);
		}
		
		if (dataVolumeIncoming != null) {
			codeLength += dataVolumeIncoming.encode(reverseOS, true);
		}
		
		if (iMSSignallingContext != null) {
			codeLength += iMSSignallingContext.encode(reverseOS, true);
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
		if (berTag.equals(IMSSignallingContext.tag)) {
			iMSSignallingContext = new IMSSignallingContext();
			subCodeLength += iMSSignallingContext.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(DataVolumeIncoming.tag)) {
			dataVolumeIncoming = new DataVolumeIncoming();
			subCodeLength += dataVolumeIncoming.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(DataVolumeOutgoing.tag)) {
			dataVolumeOutgoing = new DataVolumeOutgoing();
			subCodeLength += dataVolumeOutgoing.decode(is, false);
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
		if (iMSSignallingContext != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("iMSSignallingContext: ").append(iMSSignallingContext);
			firstSelectedElement = false;
		}
		
		if (dataVolumeIncoming != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dataVolumeIncoming: ").append(dataVolumeIncoming);
			firstSelectedElement = false;
		}
		
		if (dataVolumeOutgoing != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dataVolumeOutgoing: ").append(dataVolumeOutgoing);
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
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

