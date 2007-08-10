  
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <meta name="layout" content="main" />
         <title>Create Book</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link action="list">Book List</g:link></span>
        </div>
        <div class="body">
           <h1>Create Book</h1>
           <g:if test="${flash.message}">
                 <div class="message">${flash.message}</div>
           </g:if>
           <g:hasErrors bean="${book}">
                <div class="errors">
                    <g:renderErrors bean="${book}" as="list" />
                </div>
           </g:hasErrors>
           <g:form action="save" method="post" >
               <div class="dialog">
                <table>
                    <tbody>

                       
                       
                    </tbody>
               </table>
               </div>
               <div class="buttons">
                     <span class="formButton">
                        <input type="submit" value="Create"></input>
                     </span>
               </div>
            </g:form>
        </div>
    </body>
</html>
