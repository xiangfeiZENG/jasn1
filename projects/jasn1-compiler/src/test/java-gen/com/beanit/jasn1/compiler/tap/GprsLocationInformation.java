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


public class GprsLocationInformation implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 117);

	public byte[] code = null;
	private GprsNetworkLocation gprsNetworkLocation = null;
	private HomeLocationInformation homeLocationInformation = null;
	private GeographicalLocation geographicalLocation = null;
	
	public GprsLocationInformation() {
	}

	public GprsLocationInformation(byte[] code) {
		this.code = code;
	}

	public void setGprsNetworkLocation(GprsNetworkLocation gprsNetworkLocation) {
		this.gprsNetworkLocation = gprsNetworkLocation;
	}

	public GprsNetworkLocation getGprsNetworkLocation() {
		return gprsNetworkLocation;
	}

	public void setHomeLocationInformation(HomeLocationInformation homeLocationInformation) {
		this.homeLocationInformation = homeLocationInformation;
	}

	public HomeLocationInformation getHomeLocationInformation() {
		return homeLocationInformation;
	}

	public void setGeographicalLocation(GeographicalLocation geographicalLocation) {
		this.geographicalLocation = geographicalLocation;
	}

	public GeographicalLocation getGeographicalLocation() {
		return geographicalLocation;
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
		if (geographicalLocation != null) {
			codeLength += geographicalLocation.encode(reverseOS, true);
		}
		
		if (homeLocationInformation != null) {
			codeLength += homeLocationInformation.encode(reverseOS, true);
		}
		
		if (gprsNetworkLocation != null) {
			codeLength += gprsNetworkLocation.encode(reverseOS, true);
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
		if (berTag.equals(GprsNetworkLocation.tag)) {
			gprsNetworkLocation = new GprsNetworkLocation();
			subCodeLength += gprsNetworkLocation.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(HomeLocationInformation.tag)) {
			homeLocationInformation = new HomeLocationInformation();
			subCodeLength += homeLocationInformation.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(GeographicalLocation.tag)) {
			geographicalLocation = new GeographicalLocation();
			subCodeLength += geographicalLocation.decode(is, false);
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
		if (gprsNetworkLocation != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("gprsNetworkLocation: ");
			gprsNetworkLocation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (homeLocationInformation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("homeLocationInformation: ");
			homeLocationInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (geographicalLocation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("geographicalLocation: ");
			geographicalLocation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

