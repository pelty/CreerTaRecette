<%-- 
    Document   : imageTest
    Created on : 16 août 2022, 19:39:06
    Author     : dev-pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
        <script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="60" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
    </head>
    <body style="text-align: center">
        
        <header>
            <h1>Veuillez choisir les images à uploader.</h1>
        </header>
        
        <form method="post" action="upload" enctype="multipart/form-data">
            Fichiers sélectionnés : 
            <input type="file" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
            <input type="submit" value="Upload" /> <br/>        
            
            <div id="list"></div>   
        </form>
    </body>
</html>
