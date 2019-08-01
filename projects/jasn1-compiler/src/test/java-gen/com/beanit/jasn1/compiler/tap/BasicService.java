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


public class BasicService implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 36);

	public byte[] code = null;
	private BasicServiceCode serviceCode = null;
	private TransparencyIndicator transparencyIndicator = null;
	private Fnur fnur = null;
	private UserProtocolIndicator userProtocolIndicator = null;
	private GuaranteedBitRate guaranteedBitRate = null;
	private MaximumBitRate maximumBitRate = null;
	
	public BasicService() {
	}

	public BasicService(byte[] code) {
		this.code = code;
	}

	public void setServiceCode(BasicServiceCode serviceCode) {
		this.serviceCode = serviceCode;
	}

	public BasicServiceCode getServiceCode() {
		return serviceCode;
	}

	public void setTransparencyIndicator(TransparencyIndicator transparencyIndicator) {
		this.transparencyIndicator = transparencyIndicator;
	}

	public TransparencyIndicator getTransparencyIndicator() {
		return transparencyIndicator;
	}

	public void setFnur(Fnur fnur) {
		this.fnur = fnur;
	}

	public Fnur getFnur() {
		return fnur;
	}

	public void setUserProtocolIndicator(UserProtocolIndicator userProtocolIndicator) {
		this.userProtocolIndicator = userProtocolIndicator;
	}

	public UserProtocolIndicator getUserProtocolIndicator() {
		return userProtocolIndicator;
	}

	public void setGuaranteedBitRate(GuaranteedBitRate guaranteedBitRate) {
		this.guaranteedBitRate = guaranteedBitRate;
	}

	public GuaranteedBitRate getGuaranteedBitRate() {
		return guaranteedBitRate;
	}

	public void setMaximumBitRate(MaximumBitRate maximumBitRate) {
		this.maximumBitRate = maximumBitRate;
	}

	public MaximumBitRate getMaximumBitRate() {
		return maximumBitRate;
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
		if (maximumBitRate != null) {
			codeLength += maximumBitRate.encode(reverseOS, true);
		}
		
		if (guaranteedBitRate != null) {
			codeLength += guaranteedBitRate.encode(reverseOS, true);
		}
		
		if (userProtocolIndicator != null) {
			codeLength += userProtocolIndicator.encode(reverseOS, true);
		}
		
		if (fnur != null) {
			codeLength += fnur.encode(reverseOS, true);
		}
		
		if (transparencyIndicator != null) {
			codeLength += transparencyIndicator.encode(reverseOS, true);
		}
		
		if (serviceCode != null) {
			codeLength += serviceCode.encode(reverseOS, true);
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
		if (berTag.equals(BasicServiceCode.tag)) {
			serviceCode = new BasicServiceCode();
			subCodeLength += serviceCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(TransparencyIndicator.tag)) {
			transparencyIndicator = new TransparencyIndicator();
			subCodeLength += transparencyIndicator.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(Fnur.tag)) {
			fnur = new Fnur();
			subCodeLength += fnur.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(UserProtocolIndicator.tag)) {
			userProtocolIndicator = new UserProtocolIndicator();
			subCodeLength += userProtocolIndicator.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(GuaranteedBitRate.tag)) {
			guaranteedBitRate = new GuaranteedBitRate();
			subCodeLength += guaranteedBitRate.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(MaximumBitRate.tag)) {
			maximumBitRate = new MaximumBitRate();
			subCodeLength += maximumBitRate.decode(is, false);
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
		if (serviceCode != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("serviceCode: ");
			serviceCode.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (transparencyIndicator != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("transparencyIndicator: ").append(transparencyIndicator);
			firstSelectedElement = false;
		}
		
		if (fnur != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("fnur: ").append(fnur);
			firstSelectedElement = false;
		}
		
		if (userProtocolIndicator != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("userProtocolIndicator: ").append(userProtocolIndicator);
			firstSelectedElement = false;
		}
		
		if (guaranteedBitRate != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("guaranteedBitRate: ").append(guaranteedBitRate);
			firstSelectedElement = false;
		}
		
		if (maximumBitRate != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("maximumBitRate: ").append(maximumBitRate);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

