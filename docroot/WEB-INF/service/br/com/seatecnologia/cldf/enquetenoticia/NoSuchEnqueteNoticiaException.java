/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package br.com.seatecnologia.cldf.enquetenoticia;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Wallacy, Adan, Eduardo
 */
public class NoSuchEnqueteNoticiaException extends NoSuchModelException {

	public NoSuchEnqueteNoticiaException() {
		super();
	}

	public NoSuchEnqueteNoticiaException(String msg) {
		super(msg);
	}

	public NoSuchEnqueteNoticiaException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEnqueteNoticiaException(Throwable cause) {
		super(cause);
	}

}