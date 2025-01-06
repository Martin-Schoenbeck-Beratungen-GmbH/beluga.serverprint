package de.schoenbeck.serverprint.exceptions;

import org.compiere.util.Env;
import org.compiere.util.Msg;

public class DocumentIsNewException extends RuntimeException {

	private static final long serialVersionUID = -6721970311713406499L;
	static final String MSG_KEY = "Documentisnew";
	
	public DocumentIsNewException () {
		super(Msg.getMsg(Env.getCtx(), MSG_KEY));
	}
}
