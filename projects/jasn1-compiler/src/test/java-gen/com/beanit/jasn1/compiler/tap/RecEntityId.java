/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.tap;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.beanit.jasn1.ber.*;


public class RecEntityId extends AsciiString {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 400);

	public RecEntityId() {
	}

	public RecEntityId(byte[] value) {
		super(value);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		int codeLength;

		codeLength = super.encode(reverseOS, false);
		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;
	}

	public int decode(InputStream is, boolean withTag) throws IOException {

		int codeLength = 0;

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		codeLength += super.decode(is, false);

		return codeLength;
	}

}
