package util;

import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class Sessao {

	public static String verificarSessao() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		if (session.getAttribute("carrinhoId") == null) {
			UUID uuid = UUID.randomUUID();
			session.setAttribute("carrinhoId", uuid.toString());
		}
		return session.getAttribute("carrinhoId").toString();
	}
}
