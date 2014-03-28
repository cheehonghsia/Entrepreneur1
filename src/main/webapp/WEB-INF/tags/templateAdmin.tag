<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ attribute name="subtitle" fragment="true"%>
<%@ attribute name="meta" fragment="true"%>
<%@ attribute name="scripts" fragment="true"%>
<%@ attribute name="styles" fragment="true"%>
<%@ attribute name="header" fragment="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">

<head>

<title>ABN AMRO Pension Services Beheer<jsp:invoke fragment="subtitle" /></title>

<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame Remove this if you use the .htaccess -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<jsp:invoke fragment="meta" />

<base href='${baseTag}' />

<!-- Place favicon.ico & apple-touch-icon.png in the root of your domain and delete these references -->
<link rel="shortcut icon" href="favicon.ico">

<link rel="stylesheet" href="style/style.css" type="text/css" media="all" charset="utf-8" />
<link rel="stylesheet" type="text/css" media="print" href="style/print.css" />
<link rel="stylesheet" href="css/smoothness/jquery-ui-1.8.13.custom.css" type="text/css" media="screen" charset="utf-8" />

<jsp:invoke fragment="styles" />

<!--[if lt IE 7]>
    <script type='text/javascript' src='style/plugin/dd_belatedpng/dd_belatedpng.js'></script>
    <script type='text/javascript'>
    DD_belatedPNG.fix('.png, .navigation, .navigation li, .navigation a, .navigation a:hover, .navigation b, button, .button, .table-dynamic td, .table-dynamic th');
    </script>
    <![endif]-->

<script type="text/javascript">
  var defaultLocale = 'nl_NL';
  var userLocale = '<c:out value="${pageContext.response.locale}" />';
  var locale = defaultLocale;
  if (userLocale != defaultLocale) {
    locale = 'en_US';
  }

  var defaultLanguage = 'nl';
  var userLanguage = '<c:out value="${pageContext.response.locale.language}" />';
  var language = defaultLanguage;
  if (userLanguage != defaultLanguage) {
    language = 'en';
  }
</script>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
<script type="text/javascript" src="style/plugin/metadata/metadata.js"></script>
<script type="text/javascript" src="style/system/modernizr.min.js"></script>
<script type="text/javascript" src="style/plugin/button/button.js"></script>
<script type="text/javascript" src="style/plugin/gchart/gchart.js"></script>
<script type="text/javascript" src="style/plugin/colorbox/colorbox.js"></script>
<script type="text/javascript" src="style/plugin/datatables/datatables.js"></script>
<script type="text/javascript" src="style/plugin/qtip/qtip.js"></script>
<script type="text/javascript" src="style/plugin/validate/validate.js"></script>
<script type="text/javascript" src="style/application/plugin/jqueryui/jqueryui.js"></script>
<script type="text/javascript" src="style/style.js"></script>
<script type="text/javascript" src="resources/jqueryform/2.8/jquery.form.js"></script>
<script type="text/javascript" src="resources/json/json.min.js"></script>
<script type="text/javascript" src="resources/js/date.js"></script>
<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript" src="resources/js/form-validation.js"></script>
<script type="text/javascript" src="resources/jquerytmpl/1.0/jquery-tmpl-1.0.js"></script>

<jsp:invoke fragment="scripts" />

</head>

<body>

  <div class="container-12">
    <div id="header">
      <div class="line container-head">
        <div class="grid-4">
          <a href="index.html"><img src="logo.png" class="png" alt="ABN AMRO" /></a>
        </div>
        <div class="grid-8">
          <div class="navigation navigation-horizontal navigation-right navigation-simple">
            <ul>
              <sec:authorize access="hasRole('ROLE_ADMINISTRATOR')">
                <li class="first"><a href="admin/change-password.html"><s:message code="header.nav.changePassword" text="Change password" /></a></li>
                <li><a href="logout.html"><s:message code="header.nav.logout" text="Logout" /></a></li>
              </sec:authorize>
            </ul>
          </div>
        </div>
      </div>
      <sec:authorize access="hasRole('ROLE_ADMINISTRATOR')">
        <div class="line">&nbsp;</div>
        <div class="line">
          <div class="grid-12">
            <div class="navigation navigation-horizontal navigation-tabs">
              <ul>
                <li <c:if test="${selectedAdminTab == 'import'}"> class="current"</c:if>><a href="admin/import/index.html"><b>Upload</b></a></li>
                <li <c:if test="${selectedAdminTab == 'letter'}"> class="current"</c:if>><a href="admin/letter/index.html"><b>Brieven</b></a></li>
                <li <c:if test="${selectedAdminTab == 'participant'}"> class="current"</c:if>><a href="admin/participant/search.html"><b>Deelnemers</b></a></li>
                <li <c:if test="${selectedAdminTab == 'pensionfund'}"> class="current"</c:if>><a href="admin/pensionfund/index.html"><b>Pensioenfonds</b></a></li>
                <li <c:if test="${selectedAdminTab == 'news'}"> class="current"</c:if>><a href="admin/news/search.html"><b>Nieuws beheren</b></a></li>
                <li <c:if test="${selectedAdminTab == 'investmentProfile'}"> class="current"</c:if>><a href="admin/investmentprofile/index.html"><b>Beleggingsprofielen</b></a></li>
                <li <c:if test="${selectedAdminTab == 'fund-info-upload'}"> class="current"</c:if>><a href="admin/fund-report/index.html"><b>Koers informatie</b></a></li>
              </ul>
            </div>
          </div>
        </div>
      </sec:authorize>
    </div>

    <c:if test="${not empty message}">
      <div class="line">
        <div class="grid-3">&nbsp;</div>
        <div class="grid-9">
          <c:if test="${message.type == 'error'}">
            <div class="line">
              <div class="grid-6">
                <div class="message message-error">
                  <p>
                    <i class="icon-cross margin-right">&nbsp;</i>
                    <c:out value="${message.text}" />
                  </p>
                </div>
              </div>
            </div>
          </c:if>
          <c:if test="${message.type != 'error'}">
            <div class="line">
              <div class="grid-6">
                <div class="message message-success">
                  <p>
                    <i class="icon-tick margin-right">&nbsp;</i>
                    <c:out value="${message.text}" />
                  </p>
                </div>
              </div>
            </div>
          </c:if>
        </div>
      </div>
    </c:if>

    <jsp:doBody />

    <script type="text/javascript">
      $(document).ready(function() {

        $.datepicker.setDefaults($.datepicker.regional[language]);
        $('.datepicker').datepicker({
          dateFormat : 'dd-mm-yy'
        });

      });
    </script>

    <div class="line">
    <div class="grid-12 container-foot">
        <div class="grid-6 alpha">
            <div class="navigation navigation-horizontal navigation-simple">
                <ul>
                    <li class="first"><a href="index.html"><s:message code="footer.nav.home" text="Home" /></a></li>
                    <li><a href="https://www.abnamro.nl/nl/overabnamro/veiligheid.html"><s:message code="footer.nav.safety" text="Safety" /></a></li>
                    <li><a href="https://www.abnamro.nl/nl/overabnamro/toegankelijkheid.html"><s:message code="footer.nav.accessibility" text="Accessibility" /></a></li>
                    <li><a href="https://www.abnamro.nl/nl/overabnamro/privacy_statement.html"><s:message code="footer.nav.privacy" text="Privacy" /></a></li>
                    <li><a href="https://www.abnamro.nl/nl/overabnamro/disclaimer.html"><s:message code="footer.nav.disclaimer" text="Disclaimer" /></a></li>
                    <li><a href="faq.html"><s:message code="footer.nav.faq" text="FAQ" /></a></li>
                    <li><a href="contact.html"><s:message code="footer.nav.contact" text="Contact" /></a></li>
                </ul>
            </div>
        </div>
        <div class="grid-6 omega">
            <p class="align-right">
                &copy; ABN AMRO Pension Services <c:out value="${versionNumber}" />
            </p>
        </div>
    </div>
    </div>

  </div>

</body>

</html>