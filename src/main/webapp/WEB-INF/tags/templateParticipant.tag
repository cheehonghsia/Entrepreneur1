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

<title>ABN AMRO Pension Services<jsp:invoke fragment="subtitle" /></title>

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
<script type="text/javascript" src="resources/js/fund-distribution.js"></script>
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
              <li class="first"><a href="change-language.html"><s:message code="header.nav.language" text="Nederlandse pagina's" /></a></li>
              <sec:authorize access="hasRole('ROLE_PARTICIPANT')">
                <li><a><s:message code="header.nav.loggedInAs" text="Logged in as:" />&nbsp;<em class="name"><c:out value="${currentParticipant.personalData.fullName}" /></em></a></li>
                <li><a href="logout.html"><s:message code="header.nav.logout" text="Logout" /></a></li>
              </sec:authorize>
            </ul>
          </div>
        </div>
      </div>
      <div class="line">
        <div class="grid-12">
          <div class="navigation navigation-horizontal navigation-main">
            <ul>
              <li><a href="index.html"><s:message code="header.nav.home" text="Home" /></a></li>
              <li><a target="_blank" href="resources/manual.pdf"><s:message code="header.nav.howDoesItWork" text="How does it work?" /></a></li>
            </ul>
          </div>
        </div>
      </div>
      <sec:authorize access="hasRole('ROLE_PARTICIPANT')">
        <div class="line">
          <div class="grid-3">
            &nbsp;
          </div>
          <div class="grid-9">
            <div class="navigation navigation-horizontal navigation-right navigation-simple">
              <c:if test="${fn:length(selectableAccounts) gt 0}">
                <form id="changeAccountForm" action="participant/change-account.html" method="POST">
                  <ul>
                    <c:if test="${fn:length(selectableAccounts) eq 1}">
                      <li class="first" style="margin-right: 15px;"><a class="{my:'top center', at:'bottom center'}" title="<s:message code='participant.header.pensionFund.text' text='' />"><s:message code="participant.header.pensionFund.title" text="Pension fund" />: <c:out value="${selectedAccount.arrangementName}" /></a></li>
                    </c:if>
                    <c:if test="${fn:length(selectableAccounts) gt 1}">
                      <li class="first" style="margin-right: 15px;">
                        <s:message code="participant.header.pensionFund.title" text="Pension fund" />:
                        <select id="accountNumber" name="accountNumber" class="{my:'top center', at:'bottom center'}" title="<s:message code='participant.header.pensionFund.text' text='' />">
                          <c:forEach var="selectableAccount" items="${selectableAccounts}">
                            <option value="<c:out value='${selectableAccount.accountNumber}' />" <c:out value="${selectableAccount.accountNumber == selectedAccount.accountNumber ? ' selected=\"selected\"' : ''}" />>
                              <c:out value="${selectableAccount.arrangementName}" />
                            </option>
                          </c:forEach>
                        </select>
                      </li>
                    </c:if>
                    <li><a href="participant/portfolio.html" class="{my:'top center', at:'bottom center'}" title="<s:message code='participant.header.pensionValue.text' text='' />"><s:message code="participant.header.pensionValue.title" text="Pension value" />: &euro;&nbsp;<fmt:formatNumber value="${selectedAccount.value}" pattern="#,##0.00" /></a></li>
                    <li><a href="participant/portfolio.html"><s:message code="participant.header.portfolio.link" text="View portfolio" /></a></li>
                  </ul>
                </form>
              </c:if>
            </div>
          </div>
        </div>
        <script type="text/javascript">
          $(document).ready(function() {

            $('#accountNumber').change(function() {
              $('#changeAccountForm').submit();
            });

          });
        </script>
        <div class="grid-12">
          <h1>
            <s:message code="page.participant.home.h1.title" text="Pension Services: My Pension" />
          </h1>
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
