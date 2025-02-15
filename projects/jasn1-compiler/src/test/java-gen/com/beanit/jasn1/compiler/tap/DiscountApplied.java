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


public class DiscountApplied implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 428);

	private FixedDiscountValue fixedDiscountValue = null;
	private DiscountRate discountRate = null;
	
	public DiscountApplied() {
	}

	public DiscountApplied(byte[] code) {
		this.code = code;
	}

	public void setFixedDiscountValue(FixedDiscountValue fixedDiscountValue) {
		this.fixedDiscountValue = fixedDiscountValue;
	}

	public FixedDiscountValue getFixedDiscountValue() {
		return fixedDiscountValue;
	}

	public void setDiscountRate(DiscountRate discountRate) {
		this.discountRate = discountRate;
	}

	public DiscountRate getDiscountRate() {
		return discountRate;
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
		if (discountRate != null) {
			codeLength += discountRate.encode(reverseOS, true);
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (fixedDiscountValue != null) {
			codeLength += fixedDiscountValue.encode(reverseOS, true);
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

		if (berTag.equals(FixedDiscountValue.tag)) {
			fixedDiscountValue = new FixedDiscountValue();
			codeLength += fixedDiscountValue.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(DiscountRate.tag)) {
			discountRate = new DiscountRate();
			codeLength += discountRate.decode(is, false);
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

		if (fixedDiscountValue != null) {
			sb.append("fixedDiscountValue: ").append(fixedDiscountValue);
			return;
		}

		if (discountRate != null) {
			sb.append("discountRate: ").append(discountRate);
			return;
		}

		sb.append("<none>");
	}

}

