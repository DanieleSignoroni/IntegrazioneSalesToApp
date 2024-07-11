<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///K:/Thip/4.7.0/websrcsvil/dtd/xhtml1-transitional.dtd">
<html>
<!-- WIZGEN Therm 2.0.0 as Form - multiBrowserGen = true -->
<%=WebGenerator.writeRuntimeInfo()%>
<head>
<%@ page contentType="text/html; charset=Cp1252"%>
<%@ page import= " 
  java.sql.*, 
  java.util.*, 
  java.lang.reflect.*, 
  javax.naming.*, 
  com.thera.thermfw.common.*, 
  com.thera.thermfw.type.*, 
  com.thera.thermfw.web.*, 
  com.thera.thermfw.security.*, 
  com.thera.thermfw.base.*, 
  com.thera.thermfw.ad.*, 
  com.thera.thermfw.persist.*, 
  com.thera.thermfw.gui.cnr.*, 
  com.thera.thermfw.setting.*, 
  com.thera.thermfw.collector.*, 
  com.thera.thermfw.batch.web.*, 
  com.thera.thermfw.batch.*, 
  com.thera.thermfw.pref.* 
"%> 
<%
  ServletEnvironment se = (ServletEnvironment)Factory.createObject("com.thera.thermfw.web.ServletEnvironment"); 
  BODataCollector YUtentiSales2AppBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YUtentiSales2AppForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YUtentiSales2AppForm", "YUtentiSales2App", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/connettori/YUtentiSales2App.js"); 
  YUtentiSales2AppForm.setServletEnvironment(se); 
  YUtentiSales2AppForm.setJSTypeList(jsList); 
  YUtentiSales2AppForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YUtentiSales2AppForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YUtentiSales2AppForm.setWebFormModifierClass("it.softre.thip.base.connettori.web.YUtentiSales2AppFormModifier"); 
  YUtentiSales2AppForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YUtentiSales2AppForm.getMode(); 
  String key = YUtentiSales2AppForm.getKey(); 
  String errorMessage; 
  boolean requestIsValid = false; 
  boolean leftIsKey = false; 
  boolean conflitPresent = false; 
  String leftClass = ""; 
  try 
  {
     se.initialize(request, response); 
     if(se.begin()) 
     { 
        YUtentiSales2AppForm.outTraceInfo(getClass().getName()); 
        String collectorName = YUtentiSales2AppForm.findBODataCollectorName(); 
                YUtentiSales2AppBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YUtentiSales2AppBODC instanceof WebDataCollector) 
            ((WebDataCollector)YUtentiSales2AppBODC).setServletEnvironment(se); 
        YUtentiSales2AppBODC.initialize("YUtentiSales2App", true, 0); 
        YUtentiSales2AppForm.setBODataCollector(YUtentiSales2AppBODC); 
        int rcBODC = YUtentiSales2AppForm.initSecurityServices(); 
        mode = YUtentiSales2AppForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YUtentiSales2AppForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YUtentiSales2AppBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YUtentiSales2AppForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 

<% 
  WebLink link_0 =  
   new com.thera.thermfw.web.WebLink(); 
 link_0.setHttpServletRequest(request); 
 link_0.setHRefAttribute("https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"); 
 link_0.setRelAttribute("stylesheet"); 
 link_0.setTypeAttribute("text/css"); 
  link_0.write(out); 
%>
<!--<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">-->
<% 
  WebLink link_1 =  
   new com.thera.thermfw.web.WebLink(); 
 link_1.setHttpServletRequest(request); 
 link_1.setHRefAttribute("//code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css"); 
 link_1.setRelAttribute("stylesheet"); 
 link_1.setTypeAttribute("text/css"); 
  link_1.write(out); 
%>
<!--<link href="//code.jquery.com/ui/1.13.0/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">-->
<% 
  WebScript script_0 =  
   new com.thera.thermfw.web.WebScript(); 
 script_0.setRequest(request); 
 script_0.setSrcAttribute("//code.jquery.com/jquery-3.6.0.min.js"); 
 script_0.setLanguageAttribute(null); 
  script_0.write(out); 
%>
<!--<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>-->
<% 
  WebScript script_1 =  
   new com.thera.thermfw.web.WebScript(); 
 script_1.setRequest(request); 
 script_1.setSrcAttribute("//code.jquery.com/ui/1.13.0/jquery-ui.min.js"); 
 script_1.setLanguageAttribute(null); 
  script_1.write(out); 
%>
<!--<script src="//code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>-->
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YUtentiSales2AppForm); 
   request.setAttribute("menuBar", menuBar); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="menuBar"/> 
</jsp:include> 
<% 
  menuBar.write(out); 
  menuBar.writeChildren(out); 
%> 
<% 
  WebToolBar myToolBarTB = new com.thera.thermfw.web.WebToolBar("myToolBar", "24", "24", "16", "16", "#f7fbfd","#C8D6E1"); 
  myToolBarTB.setParent(YUtentiSales2AppForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
<body onbeforeunload="<%=YUtentiSales2AppForm.getBodyOnBeforeUnload()%>" onload="<%=YUtentiSales2AppForm.getBodyOnLoad()%>" onunload="<%=YUtentiSales2AppForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YUtentiSales2AppForm.writeBodyStartElements(out); 
%> 

	<table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YUtentiSales2AppForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YUtentiSales2AppBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YUtentiSales2AppForm.getServlet()%>" method="post" name="YUtentiSales2AppForm" style="height:100%"><%
  YUtentiSales2AppForm.writeFormStartElements(out); 
%>

		<table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
			<tr>
				<td style="height: 0"><% menuBar.writeElements(out); %> 
</td>
			</tr>
			<tr>
				<td style="height: 0"><% myToolBarTB.writeChildren(out); %> 
</td>
			</tr>
			<tr>
				<td><% 
  WebTextInput YUtentiSales2AppHashUser =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "HashUser"); 
  YUtentiSales2AppHashUser.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppHashUser.getClassType()%>" id="<%=YUtentiSales2AppHashUser.getId()%>" maxlength="<%=YUtentiSales2AppHashUser.getMaxLength()%>" name="<%=YUtentiSales2AppHashUser.getName()%>" size="<%=YUtentiSales2AppHashUser.getSize()%>" type="hidden"><% 
  YUtentiSales2AppHashUser.write(out); 
%>
</td>
			</tr>
			<tr>
				<td height="100%"><!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YUtentiSales2AppForm); 
 mytabbed.addTab("tab1", "it.softre.thip.base.connettori.resources.YUtentiSales2App", "tab1", "YUtentiSales2App", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;"> <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
							<table id="autocomplete" style="width: 100%;">
								<tr>
									<td valign="top"><label>Utente:</label></td>
									<td valign="top"><input id="user" name="user"></td>
								</tr>
							</table>
							<table id="dati" style="width: 100%">
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YUtentiSales2App", "Lastname", null); 
   label.setParent(YUtentiSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Lastname"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YUtentiSales2AppLastname =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "Lastname"); 
  YUtentiSales2AppLastname.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppLastname.getClassType()%>" id="<%=YUtentiSales2AppLastname.getId()%>" maxlength="<%=YUtentiSales2AppLastname.getMaxLength()%>" name="<%=YUtentiSales2AppLastname.getName()%>" size="<%=YUtentiSales2AppLastname.getSize()%>"><% 
  YUtentiSales2AppLastname.write(out); 
%>

									</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YUtentiSales2App", "FirstName", null); 
   label.setParent(YUtentiSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="FirstName"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YUtentiSales2AppFirstName =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "FirstName"); 
  YUtentiSales2AppFirstName.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppFirstName.getClassType()%>" id="<%=YUtentiSales2AppFirstName.getId()%>" maxlength="<%=YUtentiSales2AppFirstName.getMaxLength()%>" name="<%=YUtentiSales2AppFirstName.getName()%>" size="<%=YUtentiSales2AppFirstName.getSize()%>"><% 
  YUtentiSales2AppFirstName.write(out); 
%>

									</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YUtentiSales2App", "Id", null); 
   label.setParent(YUtentiSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Id"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YUtentiSales2AppId =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "Id"); 
  YUtentiSales2AppId.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppId.getClassType()%>" id="<%=YUtentiSales2AppId.getId()%>" maxlength="<%=YUtentiSales2AppId.getMaxLength()%>" name="<%=YUtentiSales2AppId.getName()%>" size="<%=YUtentiSales2AppId.getSize()%>"><% 
  YUtentiSales2AppId.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YUtentiSales2App", "Email", null); 
   label.setParent(YUtentiSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Email"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YUtentiSales2AppEmail =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "Email"); 
  YUtentiSales2AppEmail.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppEmail.getClassType()%>" id="<%=YUtentiSales2AppEmail.getId()%>" maxlength="<%=YUtentiSales2AppEmail.getMaxLength()%>" name="<%=YUtentiSales2AppEmail.getName()%>" size="<%=YUtentiSales2AppEmail.getSize()%>"><% 
  YUtentiSales2AppEmail.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YUtentiSales2App", "Role", null); 
   label.setParent(YUtentiSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Role"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YUtentiSales2AppRole =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "Role"); 
  YUtentiSales2AppRole.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppRole.getClassType()%>" id="<%=YUtentiSales2AppRole.getId()%>" maxlength="<%=YUtentiSales2AppRole.getMaxLength()%>" name="<%=YUtentiSales2AppRole.getName()%>" size="<%=YUtentiSales2AppRole.getSize()%>"><% 
  YUtentiSales2AppRole.write(out); 
%>
</td>
								</tr>
								<tr>
									<td valign="top"><%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YUtentiSales2App", "Phone", null); 
   label.setParent(YUtentiSales2AppForm); 
%><label class="<%=label.getClassType()%>" for="Phone"><%label.write(out);%></label><%}%></td>
									<td valign="top"><% 
  WebTextInput YUtentiSales2AppPhone =  
     new com.thera.thermfw.web.WebTextInput("YUtentiSales2App", "Phone"); 
  YUtentiSales2AppPhone.setParent(YUtentiSales2AppForm); 
%>
<input class="<%=YUtentiSales2AppPhone.getClassType()%>" id="<%=YUtentiSales2AppPhone.getId()%>" maxlength="<%=YUtentiSales2AppPhone.getMaxLength()%>" name="<%=YUtentiSales2AppPhone.getName()%>" size="<%=YUtentiSales2AppPhone.getSize()%>"><% 
  YUtentiSales2AppPhone.write(out); 
%>
</td>
								</tr>
							</table>
					<% mytabbed.endTab(); %> 
</div>
				</div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>--></td>
			</tr>
			<tr>
				<td style="height: 0"><% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YUtentiSales2AppForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>--></td>
			</tr>
		</table>
	<%
  YUtentiSales2AppForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YUtentiSales2AppForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YUtentiSales2AppBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


<%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YUtentiSales2AppForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YUtentiSales2AppBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YUtentiSales2AppBODC.getErrorList().getErrors()); 
           if(YUtentiSales2AppBODC.getConflict() != null) 
                conflitPresent = true; 
     } 
     else 
        errors.add(new ErrorMessage("BAS0000010")); 
  } 
  catch(NamingException e) { 
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("CBS000025", errorMessage));  } 
  catch(SQLException e) {
     errorMessage = e.getMessage(); 
     errors.add(new ErrorMessage("BAS0000071", errorMessage));  } 
  catch(Throwable e) {
     e.printStackTrace(Trace.excStream);
  }
  finally 
  {
     if(YUtentiSales2AppBODC != null && !YUtentiSales2AppBODC.close(false)) 
        errors.addAll(0, YUtentiSales2AppBODC.getErrorList().getErrors()); 
     try 
     { 
        se.end(); 
     }
     catch(IllegalArgumentException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
     catch(SQLException e) { 
        e.printStackTrace(Trace.excStream); 
     } 
  } 
  if(!errors.isEmpty())
  { 
      if(!conflitPresent)
  { 
     request.setAttribute("ErrorMessages", errors); 
     String errorPage = YUtentiSales2AppForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YUtentiSales2AppBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YUtentiSales2AppForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
