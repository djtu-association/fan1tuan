<html>
  <head>
    <title>SiteMesh example: <sitemesh:write property='title'/></title>
    <style type='text/css'>
      /* Some CSS */
     body { font-family: arial, sans-serif; background-color: #ffffcc; }
     h1, h2, h3, h4 { text-align: center; background-color: #ccffcc;
                      border-top: 1px solid #66ff66; }
     .mainBody { padding: 10px; border: 1px solid #555555; }
     .disclaimer { text-align: center; border-top: 1px solid #cccccc;
                   margin-top: 40px; color: #666666; font-size: smaller;}
    </style>
    
    <sitemesh:write property='head'/>
  </head>
  <body>
	
    <div class='mainBody'>
      <sitemesh:write property='body'/>
    </div>
	
	<!-- Bootstrap core JavaScript================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../../res/js/jquery-1.8.3.min.js"></script>
	<script src="../../res/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="../../res/js/jquery.ui.touch-punch.min.js"></script>
	<script src="../../res/js/bootstrap.min.js"></script>
	<script src="../../res/js/bootstrap-select.js"></script>
	<script src="../../res/js/bootstrap-switch.js"></script>
	<script src="../../res/js/flatui-checkbox.js"></script>
	<script src="../../res/js/flatui-radio.js"></script>
	<script src="../../res/js/jquery.tagsinput.js"></script>
	<script src="../../res/js/jquery.placeholder.js"></script>
	<script src="../../res/js/jquery.pin.min.js"></script>
	<script src="../../res/js/custom/index.js"></script>
	<script src="../../res/js/holder.js"></script>
  </body>
</html>