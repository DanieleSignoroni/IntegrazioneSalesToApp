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
  BODataCollector YPsnDatiConnPthSl2appBODC = null; 
  List errors = new ArrayList(); 
  WebJSTypeList jsList = new WebJSTypeList(); 
  WebForm YPsnDatiConnPthSl2appForm =  
     new com.thera.thermfw.web.WebForm(request, response, "YPsnDatiConnPthSl2appForm", "YPsnDatiConnPthSl2app", null, "com.thera.thermfw.web.servlet.FormActionAdapter", false, false, true, true, true, true, null, 0, true, "it/softre/thip/base/connettori/utils/YPsnDatiConnPthSl2app.js"); 
  YPsnDatiConnPthSl2appForm.setServletEnvironment(se); 
  YPsnDatiConnPthSl2appForm.setJSTypeList(jsList); 
  YPsnDatiConnPthSl2appForm.setHeader("it.thera.thip.cs.PantheraHeader.jsp"); 
  YPsnDatiConnPthSl2appForm.setFooter("com.thera.thermfw.common.Footer.jsp"); 
  YPsnDatiConnPthSl2appForm.setWebFormModifierClass("it.softre.thip.base.connettori.utils.web.YPsnDatiConnPthSl2appFormModifier"); 
  YPsnDatiConnPthSl2appForm.setDeniedAttributeModeStr("hideNone"); 
  int mode = YPsnDatiConnPthSl2appForm.getMode(); 
  String key = YPsnDatiConnPthSl2appForm.getKey(); 
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
        YPsnDatiConnPthSl2appForm.outTraceInfo(getClass().getName()); 
        String collectorName = YPsnDatiConnPthSl2appForm.findBODataCollectorName(); 
                YPsnDatiConnPthSl2appBODC = (BODataCollector)Factory.createObject(collectorName); 
        if (YPsnDatiConnPthSl2appBODC instanceof WebDataCollector) 
            ((WebDataCollector)YPsnDatiConnPthSl2appBODC).setServletEnvironment(se); 
        YPsnDatiConnPthSl2appBODC.initialize("YPsnDatiConnPthSl2app", true, 0); 
        YPsnDatiConnPthSl2appForm.setBODataCollector(YPsnDatiConnPthSl2appBODC); 
        int rcBODC = YPsnDatiConnPthSl2appForm.initSecurityServices(); 
        mode = YPsnDatiConnPthSl2appForm.getMode(); 
        if (rcBODC == BODataCollector.OK) 
        { 
           requestIsValid = true; 
           YPsnDatiConnPthSl2appForm.write(out); 
           if(mode != WebForm.NEW) 
              rcBODC = YPsnDatiConnPthSl2appBODC.retrieve(key); 
           if(rcBODC == BODataCollector.OK) 
           { 
              YPsnDatiConnPthSl2appForm.writeHeadElements(out); 
           // fine blocco XXX  
           // a completamento blocco di codice YYY a fine body con catch e gestione errori 
%> 
<% 
  WebMenuBar menuBar = new com.thera.thermfw.web.WebMenuBar("HM_Array1", "150", "#000000","#000000","#A5B6CE","#E4EAEF","#FFFFFF","#000000"); 
  menuBar.setParent(YPsnDatiConnPthSl2appForm); 
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
  myToolBarTB.setParent(YPsnDatiConnPthSl2appForm); 
   request.setAttribute("toolBar", myToolBarTB); 
%> 
<jsp:include page="/it/thera/thip/cs/defObjMenu.jsp" flush="true"> 
<jsp:param name="partRequest" value="toolBar"/> 
</jsp:include> 
<% 
   myToolBarTB.write(out); 
%> 
</head>
  <body onbeforeunload="<%=YPsnDatiConnPthSl2appForm.getBodyOnBeforeUnload()%>" onload="<%=YPsnDatiConnPthSl2appForm.getBodyOnLoad()%>" onunload="<%=YPsnDatiConnPthSl2appForm.getBodyOnUnload()%>" style="margin: 0px; overflow: hidden;"><%
   YPsnDatiConnPthSl2appForm.writeBodyStartElements(out); 
%> 

    <table width="100%" height="100%" cellspacing="0" cellpadding="0">
<tr>
<td style="height:0" valign="top">
<% String hdr = YPsnDatiConnPthSl2appForm.getCompleteHeader();
 if (hdr != null) { 
   request.setAttribute("dataCollector", YPsnDatiConnPthSl2appBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= hdr %>" flush="true"/> 
<% } %> 
</td>
</tr>

<tr>
<td valign="top" height="100%">
<form action="<%=YPsnDatiConnPthSl2appForm.getServlet()%>" method="post" name="YPsnDatiConnPthSl2appForm" style="height:100%"><%
  YPsnDatiConnPthSl2appForm.writeFormStartElements(out); 
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
          <td>
            <% 
  WebTextInput YPsnDatiConnPthSl2appIdAzienda =  
     new com.thera.thermfw.web.WebTextInput("YPsnDatiConnPthSl2app", "IdAzienda"); 
  YPsnDatiConnPthSl2appIdAzienda.setParent(YPsnDatiConnPthSl2appForm); 
%>
<input class="<%=YPsnDatiConnPthSl2appIdAzienda.getClassType()%>" id="<%=YPsnDatiConnPthSl2appIdAzienda.getId()%>" maxlength="<%=YPsnDatiConnPthSl2appIdAzienda.getMaxLength()%>" name="<%=YPsnDatiConnPthSl2appIdAzienda.getName()%>" size="<%=YPsnDatiConnPthSl2appIdAzienda.getSize()%>" type="hidden"><% 
  YPsnDatiConnPthSl2appIdAzienda.write(out); 
%>

          </td>
        </tr>
        <tr>
          <td height="100%">
            <!--<span class="tabbed" id="mytabbed">-->
<table width="100%" height="100%" cellpadding="0" cellspacing="0" style="padding-right:1px">
   <tr valign="top">
     <td><% 
  WebTabbed mytabbed = new com.thera.thermfw.web.WebTabbed("mytabbed", "100%", "100%"); 
  mytabbed.setParent(YPsnDatiConnPthSl2appForm); 
 mytabbed.addTab("tab1", "it.softre.thip.base.connettori.utils.resources.YPsnDatiConnPthSl2app", "tab1", "YPsnDatiConnPthSl2app", null, null, null, null); 
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
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiConnPthSl2app", "ApiKey", null); 
   label.setParent(YPsnDatiConnPthSl2appForm); 
%><label class="<%=label.getClassType()%>" for="ApiKey"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPsnDatiConnPthSl2appApiKey =  
     new com.thera.thermfw.web.WebTextArea("YPsnDatiConnPthSl2app", "ApiKey"); 
  YPsnDatiConnPthSl2appApiKey.setParent(YPsnDatiConnPthSl2appForm); 
%>
<textarea class="<%=YPsnDatiConnPthSl2appApiKey.getClassType()%>" cols="60" id="<%=YPsnDatiConnPthSl2appApiKey.getId()%>" maxlength="<%=YPsnDatiConnPthSl2appApiKey.getMaxLength()%>" name="<%=YPsnDatiConnPthSl2appApiKey.getName()%>" rows="5" size="<%=YPsnDatiConnPthSl2appApiKey.getSize()%>"></textarea><% 
  YPsnDatiConnPthSl2appApiKey.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiConnPthSl2app", "UserCalls", null); 
   label.setParent(YPsnDatiConnPthSl2appForm); 
%><label class="<%=label.getClassType()%>" for="UserCalls"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPsnDatiConnPthSl2appUserCalls =  
     new com.thera.thermfw.web.WebTextInput("YPsnDatiConnPthSl2app", "UserCalls"); 
  YPsnDatiConnPthSl2appUserCalls.setParent(YPsnDatiConnPthSl2appForm); 
%>
<input class="<%=YPsnDatiConnPthSl2appUserCalls.getClassType()%>" id="<%=YPsnDatiConnPthSl2appUserCalls.getId()%>" maxlength="<%=YPsnDatiConnPthSl2appUserCalls.getMaxLength()%>" name="<%=YPsnDatiConnPthSl2appUserCalls.getName()%>" size="<%=YPsnDatiConnPthSl2appUserCalls.getSize()%>"><% 
  YPsnDatiConnPthSl2appUserCalls.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiConnPthSl2app", "PwdCalls", null); 
   label.setParent(YPsnDatiConnPthSl2appForm); 
%><label class="<%=label.getClassType()%>" for="PwdCalls"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPsnDatiConnPthSl2appPwdCalls =  
     new com.thera.thermfw.web.WebTextArea("YPsnDatiConnPthSl2app", "PwdCalls"); 
  YPsnDatiConnPthSl2appPwdCalls.setParent(YPsnDatiConnPthSl2appForm); 
%>
<textarea class="<%=YPsnDatiConnPthSl2appPwdCalls.getClassType()%>" cols="60" id="<%=YPsnDatiConnPthSl2appPwdCalls.getId()%>" maxlength="<%=YPsnDatiConnPthSl2appPwdCalls.getMaxLength()%>" name="<%=YPsnDatiConnPthSl2appPwdCalls.getName()%>" rows="5" size="<%=YPsnDatiConnPthSl2appPwdCalls.getSize()%>"></textarea><% 
  YPsnDatiConnPthSl2appPwdCalls.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiConnPthSl2app", "UrlCalls", null); 
   label.setParent(YPsnDatiConnPthSl2appForm); 
%><label class="<%=label.getClassType()%>" for="UrlCalls"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebTextInput YPsnDatiConnPthSl2appUrlCalls =  
     new com.thera.thermfw.web.WebTextArea("YPsnDatiConnPthSl2app", "UrlCalls"); 
  YPsnDatiConnPthSl2appUrlCalls.setParent(YPsnDatiConnPthSl2appForm); 
%>
<textarea class="<%=YPsnDatiConnPthSl2appUrlCalls.getClassType()%>" cols="60" id="<%=YPsnDatiConnPthSl2appUrlCalls.getId()%>" maxlength="<%=YPsnDatiConnPthSl2appUrlCalls.getMaxLength()%>" name="<%=YPsnDatiConnPthSl2appUrlCalls.getName()%>" rows="5" size="<%=YPsnDatiConnPthSl2appUrlCalls.getSize()%>"></textarea><% 
  YPsnDatiConnPthSl2appUrlCalls.write(out); 
%>

                    </td>
                  </tr>
                  <tr>
                    <td valign="top">
                      <%{  WebLabelCompound label = new com.thera.thermfw.web.WebLabelCompound(null, null, "YPsnDatiConnPthSl2app", "HashUserJolly", null); 
   label.setParent(YPsnDatiConnPthSl2appForm); 
%><label class="<%=label.getClassType()%>" for="UtenteJolly"><%label.write(out);%></label><%}%>
                    </td>
                    <td valign="top">
                      <% 
  WebMultiSearchForm YPsnDatiConnPthSl2appUtenteJolly =  
     new com.thera.thermfw.web.WebMultiSearchForm("YPsnDatiConnPthSl2app", "UtenteJolly", false, false, true, 1, null, null); 
  YPsnDatiConnPthSl2appUtenteJolly.setParent(YPsnDatiConnPthSl2appForm); 
  YPsnDatiConnPthSl2appUtenteJolly.write(out); 
%>
<!--<span class="multisearchform" id="UtenteJolly"></span>-->
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
  errorList.setParent(YPsnDatiConnPthSl2appForm); 
  errorList.write(out); 
%>
<!--<span class="errorlist"></span>-->
          </td>
        </tr>
      </table>
    <%
  YPsnDatiConnPthSl2appForm.writeFormEndElements(out); 
%>
</form></td>
</tr>

<tr>
<td style="height:0">
<% String ftr = YPsnDatiConnPthSl2appForm.getCompleteFooter();
 if (ftr != null) { 
   request.setAttribute("dataCollector", YPsnDatiConnPthSl2appBODC); 
   request.setAttribute("servletEnvironment", se); %>
  <jsp:include page="<%= ftr %>" flush="true"/> 
<% } %> 
</td>
</tr>
</table>


  <%
           // blocco YYY  
           // a completamento blocco di codice XXX in head 
              YPsnDatiConnPthSl2appForm.writeBodyEndElements(out); 
           } 
           else 
              errors.addAll(0, YPsnDatiConnPthSl2appBODC.getErrorList().getErrors()); 
        } 
        else 
           errors.addAll(0, YPsnDatiConnPthSl2appBODC.getErrorList().getErrors()); 
           if(YPsnDatiConnPthSl2appBODC.getConflict() != null) 
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
     if(YPsnDatiConnPthSl2appBODC != null && !YPsnDatiConnPthSl2appBODC.close(false)) 
        errors.addAll(0, YPsnDatiConnPthSl2appBODC.getErrorList().getErrors()); 
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
     String errorPage = YPsnDatiConnPthSl2appForm.getErrorPage(); 
%> 
     <jsp:include page="<%=errorPage%>" flush="true"/> 
<% 
  } 
  else 
  { 
     request.setAttribute("ConflictMessages", YPsnDatiConnPthSl2appBODC.getConflict()); 
     request.setAttribute("ErrorMessages", errors); 
     String conflictPage = YPsnDatiConnPthSl2appForm.getConflictPage(); 
%> 
     <jsp:include page="<%=conflictPage%>" flush="true"/> 
<% 
   } 
   } 
%> 
</body>
</html>
