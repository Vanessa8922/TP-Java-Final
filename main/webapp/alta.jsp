<html>
    <head>
            <%@include file="head.jsp" %>
            <title>ABM DE ORADORES</title>
    </head>
  
    <body>
        <main>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section class="border border-primary rounded-4 col-6 mx-auto text-center" style="background-color:gray">
                    <h1 class="text-center my-4" style="font-style: italic">Alta</h1>
                    <!--  JSP -->
                    <form method="post"
                        action="<%=request.getContextPath()%>/CreateController">
                        
                        <div class="my-3 mx-3">
                          <input name="nombre"  type="text" class="form-control" id="nombretxt" placeholder="nombre" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                          <input name="apellido" type="text" class="form-control" id="apellidotxt" placeholder="apellido">
                        </div>
                        <div class="my-3 mx-3">
                          <input name="mail" type="email" class="form-control" id="mailtxt" placeholder="mail" maxlength="50">
                        </div>
                        <div class="my-3 mx-3">
                          <input name="tema" type="text" class="form-control" id="tematxt" maxlength="7" placeholder="tema">
                        </div>
                        <button class="btn btn-primary my-3">
                           Nuevo Orador
                        </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>