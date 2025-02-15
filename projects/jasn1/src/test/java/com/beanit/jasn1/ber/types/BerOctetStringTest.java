/*
 * Copyright 2012 The jASN1 Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.beanit.jasn1.ber.types;

import com.beanit.jasn1.ber.ReverseByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class BerOctetStringTest {

  @Test
  public void explicitEncoding() throws IOException {
    ReverseByteArrayOutputStream berStream = new ReverseByteArrayOutputStream(50);

    byte[] byteArray = new byte[] {0x01, 0x02, 0x03};
    BerOctetString asn1OctetString = new BerOctetString(byteArray);
    int length = asn1OctetString.encode(berStream, true);
    Assert.assertEquals(5, length);

    byte[] expectedBytes = new byte[] {0x04, 0x03, 0x01, 0x02, 0x03};
    Assert.assertArrayEquals(expectedBytes, berStream.getArray());
  }

  @Test
  public void explicitDecoding() throws IOException {
    byte[] byteCode = new byte[] {0x04, 0x00};
    ByteArrayInputStream berInputStream = new ByteArrayInputStream(byteCode);
    BerOctetString asn1OctetString = new BerOctetString();
    asn1OctetString.decode(berInputStream, true);
    Assert.assertEquals(0, asn1OctetString.value.length);
  }

  @Test
  public void toStringTest() {
    BerOctetString octetString = new BerOctetString(new byte[] {1, 2, (byte) 0xa0});
    Assert.assertEquals("0102A0", octetString.toString());
  }
}
