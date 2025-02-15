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


public class ChargeableSubscriber implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 427);

	private SimChargeableSubscriber simChargeableSubscriber = null;
	private MinChargeableSubscriber minChargeableSubscriber = null;
	
	public ChargeableSubscriber() {
	}

	public ChargeableSubscriber(byte[] code) {
		this.code = code;
	}

	public void setSimChargeableSubscriber(SimChargeableSubscriber simChargeableSubscriber) {
		this.simChargeableSubscriber = simChargeableSubscriber;
	}

	public SimChargeableSubscriber getSimChargeableSubscriber() {
		return simChargeableSubscriber;
	}

	public void setMinChargeableSubscriber(MinChargeableSubscriber minChargeableSubscriber) {
		this.minChargeableSubscriber = minChargeableSubscriber;
	}

	public MinChargeableSubscriber getMinChargeableSubscriber() {
		return minChargeableSubscriber;
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
		if (minChargeableSubscriber != null) {
			codeLength += minChargeableSubscriber.encode(reverseOS, true);
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (simChargeableSubscriber != null) {
			codeLength += simChargeableSubscriber.encode(reverseOS, true);
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		BerLength length = new BerLength();
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += length.decode(is);
		codeLength += berTag.decode(is);

		if (berTag.equals(SimChargeableSubscriber.tag)) {
			simChargeableSubscriber = new SimChargeableSubscriber();
			codeLength += simChargeableSubscriber.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(MinChargeableSubscriber.tag)) {
			minChargeableSubscriber = new MinChargeableSubscriber();
			codeLength += minChargeableSubscriber.decode(is, false);
			return codeLength;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
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

		if (simChargeableSubscriber != null) {
			sb.append("simChargeableSubscriber: ");
			simChargeableSubscriber.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (minChargeableSubscriber != null) {
			sb.append("minChargeableSubscriber: ");
			minChargeableSubscriber.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

