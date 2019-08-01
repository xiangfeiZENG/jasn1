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


public class ThreeGcamelDestination implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 431);

	private CamelDestinationNumber camelDestinationNumber = null;
	private GprsDestination gprsDestination = null;
	
	public ThreeGcamelDestination() {
	}

	public ThreeGcamelDestination(byte[] code) {
		this.code = code;
	}

	public void setCamelDestinationNumber(CamelDestinationNumber camelDestinationNumber) {
		this.camelDestinationNumber = camelDestinationNumber;
	}

	public CamelDestinationNumber getCamelDestinationNumber() {
		return camelDestinationNumber;
	}

	public void setGprsDestination(GprsDestination gprsDestination) {
		this.gprsDestination = gprsDestination;
	}

	public GprsDestination getGprsDestination() {
		return gprsDestination;
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
		if (gprsDestination != null) {
			codeLength += gprsDestination.encode(reverseOS, true);
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (camelDestinationNumber != null) {
			codeLength += camelDestinationNumber.encode(reverseOS, true);
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

		if (berTag.equals(CamelDestinationNumber.tag)) {
			camelDestinationNumber = new CamelDestinationNumber();
			codeLength += camelDestinationNumber.decode(is, false);
			return codeLength;
		}

		if (berTag.equals(GprsDestination.tag)) {
			gprsDestination = new GprsDestination();
			codeLength += gprsDestination.decode(is, false);
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

		if (camelDestinationNumber != null) {
			sb.append("camelDestinationNumber: ").append(camelDestinationNumber);
			return;
		}

		if (gprsDestination != null) {
			sb.append("gprsDestination: ");
			gprsDestination.appendAsString(sb, indentLevel + 1);
			return;
		}

		sb.append("<none>");
	}

}

