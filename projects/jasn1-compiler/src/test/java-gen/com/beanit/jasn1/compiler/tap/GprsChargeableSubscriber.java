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


public class GprsChargeableSubscriber implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 115);

	public byte[] code = null;
	private ChargeableSubscriber chargeableSubscriber = null;
	private PdpAddress pdpAddress = null;
	private NetworkAccessIdentifier networkAccessIdentifier = null;
	
	public GprsChargeableSubscriber() {
	}

	public GprsChargeableSubscriber(byte[] code) {
		this.code = code;
	}

	public void setChargeableSubscriber(ChargeableSubscriber chargeableSubscriber) {
		this.chargeableSubscriber = chargeableSubscriber;
	}

	public ChargeableSubscriber getChargeableSubscriber() {
		return chargeableSubscriber;
	}

	public void setPdpAddress(PdpAddress pdpAddress) {
		this.pdpAddress = pdpAddress;
	}

	public PdpAddress getPdpAddress() {
		return pdpAddress;
	}

	public void setNetworkAccessIdentifier(NetworkAccessIdentifier networkAccessIdentifier) {
		this.networkAccessIdentifier = networkAccessIdentifier;
	}

	public NetworkAccessIdentifier getNetworkAccessIdentifier() {
		return networkAccessIdentifier;
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
		if (networkAccessIdentifier != null) {
			codeLength += networkAccessIdentifier.encode(reverseOS, true);
		}
		
		if (pdpAddress != null) {
			codeLength += pdpAddress.encode(reverseOS, true);
		}
		
		if (chargeableSubscriber != null) {
			codeLength += chargeableSubscriber.encode(reverseOS, true);
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
		if (berTag.equals(ChargeableSubscriber.tag)) {
			chargeableSubscriber = new ChargeableSubscriber();
			subCodeLength += chargeableSubscriber.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(PdpAddress.tag)) {
			pdpAddress = new PdpAddress();
			subCodeLength += pdpAddress.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(NetworkAccessIdentifier.tag)) {
			networkAccessIdentifier = new NetworkAccessIdentifier();
			subCodeLength += networkAccessIdentifier.decode(is, false);
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
		if (chargeableSubscriber != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeableSubscriber: ");
			chargeableSubscriber.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (pdpAddress != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("pdpAddress: ").append(pdpAddress);
			firstSelectedElement = false;
		}
		
		if (networkAccessIdentifier != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("networkAccessIdentifier: ").append(networkAccessIdentifier);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

