<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:template>

  <jsp:body>

            <div class="grid-12">
                <h1>
                    <s:message code="page.500.h1.title" text="Error" />
                </h1>
            </div>
            <div class="line">
                <div class="grid-6">
                    <div class="message message-error">
                        <p>
                            <i class="icon-cross margin-right">&nbsp;</i>
                            <s:message code="page.500.message.error" text="" />
                        </p>
                    </div>
                </div>
            </div>

  </jsp:body>

</t:template>
