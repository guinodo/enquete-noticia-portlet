<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="java.util.List" %>

<%
List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(0, LayoutLocalServiceUtil.getLayoutsCount());

System.out.println(layouts);
// Esse atualmente possui apenas 2, os mesmos dois da barra de navega��o do Liferay

List<String> ignore = new ArrayList<String>();
ignore.add("/manage"); // Excluindo painel de controle da lista

out.println("<ul>");
for (Layout layout : layouts){
	if(!ignore.contains(layout.getFriendlyURL())){
		if(layout.hasChildren()){
			out.println("<li>");
			out.println("<a href=\"" + layout.getFriendlyURL() + "\">" + layout.getName("en_US") + "</a>");
			out.println("</li>");

			List<Layout> layoustsChildren = layout.getChildren();
			out.println("<ul>");
			for (Layout children : layoustsChildren){
				if(!ignore.contains(layout.getFriendlyURL())){
					out.println("<li>");
					out.print("<a href=\"" + children.getFriendlyURL() + "\">" + children.getName("en_US") + "</a>");
					out.println("</li>");
					ignore.add(children.getFriendlyURL()); //As filhas aparecem como layouts separdos
															//e para n�o ser mapeado depois deve ser removida
				}

			}
			out.println("</ul>");
			ignore.add(layout.getFriendlyURL()); //Pode existir mais de um layout mapeado para a mesma url,
												//ent�o cada pagina adiconada � tamb�m para evitar reinser��o na lista

		}else{
			out.println("<li>");
			out.print("<a href=\"" + layout.getFriendlyURL() + "\">" + layout.getName("en_US") + "</a>");
			out.println("</li>");
			ignore.add(layout.getFriendlyURL());
		}

	}
}
out.println("</ul>");
 %>