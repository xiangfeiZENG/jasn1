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


public class ChargeDetail implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 63);

	public byte[] code = null;
	private ChargeType chargeType = null;
	private Charge charge = null;
	private ChargeableUnits chargeableUnits = null;
	private ChargedUnits chargedUnits = null;
	private ChargeDetailTimeStamp chargeDetailTimeStamp = null;
	
	public ChargeDetail() {
	}

	public ChargeDetail(byte[] code) {
		this.code = code;
	}

	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setChargeableUnits(ChargeableUnits chargeableUnits) {
		this.chargeableUnits = chargeableUnits;
	}

	public ChargeableUnits getChargeableUnits() {
		return chargeableUnits;
	}

	public void setChargedUnits(ChargedUnits chargedUnits) {
		this.chargedUnits = chargedUnits;
	}

	public ChargedUnits getChargedUnits() {
		return chargedUnits;
	}

	public void setChargeDetailTimeStamp(ChargeDetailTimeStamp chargeDetailTimeStamp) {
		this.chargeDetailTimeStamp = chargeDetailTimeStamp;
	}

	public ChargeDetailTimeStamp getChargeDetailTimeStamp() {
		return chargeDetailTimeStamp;
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
		if (chargeDetailTimeStamp != null) {
			codeLength += chargeDetailTimeStamp.encode(reverseOS, true);
		}
		
		if (chargedUnits != null) {
			codeLength += chargedUnits.encode(reverseOS, true);
		}
		
		if (chargeableUnits != null) {
			codeLength += chargeableUnits.encode(reverseOS, true);
		}
		
		if (charge != null) {
			codeLength += charge.encode(reverseOS, true);
		}
		
		if (chargeType != null) {
			codeLength += chargeType.encode(reverseOS, true);
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
		if (berTag.equals(ChargeType.tag)) {
			chargeType = new ChargeType();
			subCodeLength += chargeType.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(Charge.tag)) {
			charge = new Charge();
			subCodeLength += charge.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargeableUnits.tag)) {
			chargeableUnits = new ChargeableUnits();
			subCodeLength += chargeableUnits.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargedUnits.tag)) {
			chargedUnits = new ChargedUnits();
			subCodeLength += chargedUnits.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargeDetailTimeStamp.tag)) {
			chargeDetailTimeStamp = new ChargeDetailTimeStamp();
			subCodeLength += chargeDetailTimeStamp.decode(is, false);
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
		if (chargeType != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeType: ").append(chargeType);
			firstSelectedElement = false;
		}
		
		if (charge != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("charge: ").append(charge);
			firstSelectedElement = false;
		}
		
		if (chargeableUnits != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeableUnits: ").append(chargeableUnits);
			firstSelectedElement = false;
		}
		
		if (chargedUnits != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargedUnits: ").append(chargedUnits);
			firstSelectedElement = false;
		}
		
		if (chargeDetailTimeStamp != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeDetailTimeStamp: ");
			chargeDetailTimeStamp.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

