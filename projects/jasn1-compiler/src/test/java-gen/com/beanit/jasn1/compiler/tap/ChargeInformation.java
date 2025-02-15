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


public class ChargeInformation implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.CONSTRUCTED, 69);

	public byte[] code = null;
	private ChargedItem chargedItem = null;
	private ExchangeRateCode exchangeRateCode = null;
	private CallTypeGroup callTypeGroup = null;
	private ChargeDetailList chargeDetailList = null;
	private TaxInformationList taxInformation = null;
	private DiscountInformation discountInformation = null;
	
	public ChargeInformation() {
	}

	public ChargeInformation(byte[] code) {
		this.code = code;
	}

	public void setChargedItem(ChargedItem chargedItem) {
		this.chargedItem = chargedItem;
	}

	public ChargedItem getChargedItem() {
		return chargedItem;
	}

	public void setExchangeRateCode(ExchangeRateCode exchangeRateCode) {
		this.exchangeRateCode = exchangeRateCode;
	}

	public ExchangeRateCode getExchangeRateCode() {
		return exchangeRateCode;
	}

	public void setCallTypeGroup(CallTypeGroup callTypeGroup) {
		this.callTypeGroup = callTypeGroup;
	}

	public CallTypeGroup getCallTypeGroup() {
		return callTypeGroup;
	}

	public void setChargeDetailList(ChargeDetailList chargeDetailList) {
		this.chargeDetailList = chargeDetailList;
	}

	public ChargeDetailList getChargeDetailList() {
		return chargeDetailList;
	}

	public void setTaxInformation(TaxInformationList taxInformation) {
		this.taxInformation = taxInformation;
	}

	public TaxInformationList getTaxInformation() {
		return taxInformation;
	}

	public void setDiscountInformation(DiscountInformation discountInformation) {
		this.discountInformation = discountInformation;
	}

	public DiscountInformation getDiscountInformation() {
		return discountInformation;
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
		if (discountInformation != null) {
			codeLength += discountInformation.encode(reverseOS, true);
		}
		
		if (taxInformation != null) {
			codeLength += taxInformation.encode(reverseOS, true);
		}
		
		if (chargeDetailList != null) {
			codeLength += chargeDetailList.encode(reverseOS, true);
		}
		
		if (callTypeGroup != null) {
			codeLength += callTypeGroup.encode(reverseOS, true);
		}
		
		if (exchangeRateCode != null) {
			codeLength += exchangeRateCode.encode(reverseOS, true);
		}
		
		if (chargedItem != null) {
			codeLength += chargedItem.encode(reverseOS, true);
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
		if (berTag.equals(ChargedItem.tag)) {
			chargedItem = new ChargedItem();
			subCodeLength += chargedItem.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ExchangeRateCode.tag)) {
			exchangeRateCode = new ExchangeRateCode();
			subCodeLength += exchangeRateCode.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(CallTypeGroup.tag)) {
			callTypeGroup = new CallTypeGroup();
			subCodeLength += callTypeGroup.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(ChargeDetailList.tag)) {
			chargeDetailList = new ChargeDetailList();
			subCodeLength += chargeDetailList.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(TaxInformationList.tag)) {
			taxInformation = new TaxInformationList();
			subCodeLength += taxInformation.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(DiscountInformation.tag)) {
			discountInformation = new DiscountInformation();
			subCodeLength += discountInformation.decode(is, false);
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
		if (chargedItem != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargedItem: ").append(chargedItem);
			firstSelectedElement = false;
		}
		
		if (exchangeRateCode != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("exchangeRateCode: ").append(exchangeRateCode);
			firstSelectedElement = false;
		}
		
		if (callTypeGroup != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("callTypeGroup: ");
			callTypeGroup.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (chargeDetailList != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("chargeDetailList: ");
			chargeDetailList.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (taxInformation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("taxInformation: ");
			taxInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (discountInformation != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("discountInformation: ");
			discountInformation.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

