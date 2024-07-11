<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN"
                      "file:///W:\PthDev\Projects\Panthera\PthSales2App\WebContent\dtd/xhtml1-transitional.dtd">
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
  BODataCollector YLegameAgenteUtenteBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YLegameAgenteUtenteForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YLegameAgenteUtenteForm", "YLegameAgenteUtente", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/connettori/legami/YLegameAgenteUtente.js"); 
  YLegameAgenteUtenteForm.setServletEnvironment(se); 
  YLegameAgenteUtenteForm.setJSTypeList(jsList); 
  YLegameAgenteUtenteForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YLegameAgenteUtenteForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YLegameAgenteUtenteForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YLegameAgenteUtenteForm.getMode(); 
  String key = YLegameAgenteUtenteForm.getKey(); 
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
        YLegameAgenteUtenteForm.outTraceInfo(getClass().getName()); 
        String collectorName = YLegameAgenteUtenteForm.findBODataCollectorName(); 
                YLegameAgenteUtenteBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YLegameAgenteUtenteBODC instanceof WebDataCollector) 
            ((WebDataCollector)YLegameAgenteUtenteBODC).setServletEnvironment(se); 
        YLegameAgenteUtenteBODC.initialize("YLegameAgenteUtente", true, 0); 
        YLegameAgenteUtenteForm.setBODataCollector(YLegameAgenteUtenteBODC); 
        int rcBODC = YLegameAgenteUtenteForm.initSecurityServices(); 
        mode = YLegameAgenteUtenteForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YLegameAgenteUtenteForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YLegameAgenteUtenteBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YLegameAgenteUtenteForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YLegameAgenteUtenteForm); 
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
  myToolBarTB.setParent(YLegameAgenteUtenteForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YLegameAgenteUtenteForm.getBodyOnBeforeUnload()%>" onload="<%=YLegameAgenteUtenteForm.getBodyOnLoad()%>" onunload="<%=YLegameAgenteUtenteForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YLegameAgenteUtenteForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YLegameAgenteUtenteForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YLegameAgenteUtenteBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YLegameAgenteUtenteForm.getServlet()%>" method="post" name="YLegameAgenteUtenteForm" style="height:100%"><%
  YLegameAgenteUtenteForm.writeFormStartElements(out); 
%>

      <table cellpadding="0" cellspacing="0" height="100%" id="emptyborder" width="100%">
        <tr>
          <td style="height:0">
            <% menuBar.writeElements(out); %> 

          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% myToolBarTB.writeChildren(out); %> 

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YLegameAgenteUtenteForm); 
 mytabbed.addTab("tab1", "it.softre.thip.base.connettori.legami.resources.YLegameAgenteUtente", "tab1", "YLegameAgenteUtente", null, null, null, null); 
  mytabbed.write(out); 
%>

     </td>
   </tr>
   <tr>
     <td height="100%"><div class="tabbed_pagine" id="tabbedPagine" style="position: relative; width: 100%; height: 100%;">
              <div class="tabbed_page" id="<%=mytabbed.getTabPageId("tab1")%>" style="width:100%;height:100%;overflow:auto;"><% mytabbed.startTab("tab1"); %>
                <table style="width: 100%;">
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLegameAgenteUtente", "IdAgente", null); 
   label.setParent(YLegameAgenteUtenteForm); 
%><label class="<%=label.getClassType()%>" for="Agente"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YLegameAgenteUtenteAgente =  
     new com.thera.thermfw.web.WebMultiSearchForm("YLegameAgenteUtente", "Agente", false, false, true, 1, null, null); 
  YLegameAgenteUtenteAgente.setParent(YLegameAgenteUtenteForm); 
  YLegameAgenteUtenteAgente.write(out); 
%>
<!--<span class="multisearchform" id="Agente"></span>-->
                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YLegameAgenteUtente", "IdUtenteS2App", null); 
   label.setParent(YLegameAgenteUtenteForm); 
%><label class="<%=label.getClassType()%>" for="Utente"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YLegameAgenteUtenteUtente =  
     new com.thera.thermfw.web.WebMultiSearchForm("YLegameAgenteUtente", "Utente", false, false, true, 1, null, null); 
  YLegameAgenteUtenteUtente.setParent(YLegameAgenteUtenteForm); 
  YLegameAgenteUtenteUtente.write(out); 
%>
<!--<span class="multisearchform" id="Utente"></span>-->
                    </td>
                  </tr>
                </table>
              <% mytabbed.endTab(); %> 
</div>
            </div><% mytabbed.endTabbed();%> 

     </td>
   </tr>
</table><!--</span>-->
          </td>
        </tr>
        <tr>
          <td style="height:0">
            <% 
  WebErrorList errorList = new com.thera.thermfw.web.WebErrorList(); 
  errorList.setParent(YLegameAgenteUtenteForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YLegameAgenteUtenteForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YLegameAgenteUtenteForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YLegameAgenteUtenteBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YLegameAgenteUtenteForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YLegameAgenteUtenteBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YLegameAgenteUtenteBODC.getErrorList().getErrors()); 
           if(YLegameAgenteUtenteBODC.getConflict() != null) 
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
     if(YLegameAgenteUtenteBODC != null && !YLegameAgenteUtenteBODC.close(false)) 
        errors.addAll(0, YLegameAgenteUtenteBODC.getErrorList().getErrors()); 
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
     String errorPage = YLegameAgenteUtenteForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YLegameAgenteUtenteBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YLegameAgenteUtenteForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
