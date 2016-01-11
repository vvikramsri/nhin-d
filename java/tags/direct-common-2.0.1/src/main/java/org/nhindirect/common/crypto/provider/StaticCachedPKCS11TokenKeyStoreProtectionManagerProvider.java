/* 
Copyright (c) 2010, NHIN Direct Project
All rights reserved.

Authors:
   Greg Meyer      gm2552@cerner.com
 
Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer 
in the documentation and/or other materials provided with the distribution.  Neither the name of the The NHIN Direct Project (nhindirect.org). 
nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
THE POSSIBILITY OF SUCH DAMAGE.
*/


package org.nhindirect.common.crypto.provider;

import org.nhindirect.common.crypto.KeyStoreProtectionManager;
import org.nhindirect.common.crypto.PKCS11Credential;
import org.nhindirect.common.crypto.exceptions.CryptoException;
import org.nhindirect.common.crypto.impl.StaticCachedPKCS11TokenKeyStoreProtectionManager;

import com.google.inject.Provider;

/**
 * Guice provider for the StaticCachedPKCS11TokenKeyStoreProtectionManager class.
 * @author Greg Meyer
 * @since 2.0
 */
public class StaticCachedPKCS11TokenKeyStoreProtectionManagerProvider implements Provider<KeyStoreProtectionManager>
{
	private final PKCS11Credential credential;
	private final String keyStorePassPhraseAlias;
	private final String privateKeyPassPhraseAlias;
	
	public StaticCachedPKCS11TokenKeyStoreProtectionManagerProvider(PKCS11Credential credential, 
			String keyStorePassPhraseAlias, String privateKeyPassPhraseAlias)
	{
		this.credential = credential;
		this.keyStorePassPhraseAlias = keyStorePassPhraseAlias;
		this.privateKeyPassPhraseAlias = privateKeyPassPhraseAlias;
	}
	
	@Override
	public KeyStoreProtectionManager get()
	{
		try 
		{
			return new StaticCachedPKCS11TokenKeyStoreProtectionManager(credential, 
					keyStorePassPhraseAlias, privateKeyPassPhraseAlias);
		} 
		catch (CryptoException e) 
		{
			throw new IllegalStateException("Failed to create StaticCachedPKCS11TokenKeyStoreProtectionManager.", e);
		}
	}
}