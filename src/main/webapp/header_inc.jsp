<html:link action="/language" tabindex="1" styleId="lang" styleClass="linkColor">
    <html:param name="language" value="french"/>French
</html:link>
<html:link action="/language" tabindex="2" styleId="lang" styleClass="linkColor">
    <html:param name="language" value="english"/>English
</html:link>
<html:link action="/language" tabindex="3" styleId="lang" styleClass="linkColor">
    <html:param name="language" value="spanish"/>Spanish
</html:link>

<logic:present name="user" scope="session">
    <html:link action="/logout" tabindex="3" styleId="logOut" styleClass="linkColor">
        <bean:message key="label.logout" locale="display" />
    </html:link>
</logic:present>
<h1 id="logo"><a>JavaChap</a></h1>

