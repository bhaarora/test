<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, target-densityDpi=device-dpi, user-scalable=no"/>
<style>body{border:0;font-family:Verdana,Geneva,sans-serif;font-size:16px;color:#666;margin:0;padding:0;vertical-align:top;-ms-content-zooming:none}.headercontentblock0,.headercontentblock1{border-left:1px solid #338dc0;border-right:1px solid #338dc0}.headercontentblock0{display:block;border-bottom:1px solid #338dc0;-moz-border-radius-bottomleft:1em;-moz-border-radius-bottomright:1em;border-bottom-left-radius:.5em;border-bottom-right-radius:.5em;padding-bottom:.4em}.headerBarblock,.sharpblueBar{display:block;padding:.4em 15px;font-size:22px;font-weight:700;color:#fff}.headercontentblock1{display:block}.headerBarblock{border:1px solid #338dc0;background:#5e87b0;-moz-border-radius-topleft:1em;-moz-border-radius-topright:1em;border-top-left-radius:.5em;border-top-right-radius:.5em;text-shadow:0 -1px 1px #145072;text-decoration:none;background-image:-moz-linear-gradient(top,#69bfe8,#2a8fc7,#077abc);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#69bfe8),color-stop(.5,#077abc),color-stop(1,#2a8fc7));background-image:-ms-linear-gradient(top,#69bfe8 0,#2a8fc7 50%,#077abc 100%)}.greenButton,.sharpblueBar{background:#5e87b0;text-shadow:0 -1px 1px #145072}.sharpblueBar{border:1px solid #338dc0;background-image:-moz-linear-gradient(top,#69bfe8,#2a8fc7,#077abc);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#69bfe8),color-stop(.5,#077abc),color-stop(1,#2a8fc7));background-image:-ms-linear-gradient(top,#69bfe8 0,#2a8fc7 50%,#077abc 100%)}.container{margin:auto;padding-top:10px;width:95%}.container1{margin:auto;padding:15px}.container3{margin:auto;padding-top:130px;width:95%}.popupcontentBlock,.popupcontentBlockbottom{display:block;border-left:4px solid #338dc0;border-right:4px solid #338dc0;padding:.4em 0}.popupcontentBlockbottom{border-bottom:4px solid #338dc0;-moz-border-radius-bottomleft:1em;-moz-border-radius-bottomright:1em;border-bottom-left-radius:1em;border-bottom-right-radius:1em}label.custom-select{position:relative;display:inline-block}.custom-select select{display:inline-block;border:2px solid #dbdbdb;padding:.2em 15px;height:43px;margin:0;font:inherit;font-size:16px;color:#666;outline:0;line-height:1.2;background:#dbdbdb;-webkit-appearance:none;-webkit-border-radius:15px;-moz-border-radius:15px;border-radius:15px;width:100%}.custom-select:after,.inputboxBg{-moz-border-radius:15px;-webkit-border-radius:15px}@media screen and (-webkit-min-device-pixel-ratio:0){.custom-select select{padding-right:50px}}.custom-select select:focus{box-shadow:0 0 10px #9ecaed;-moz-box-shadow:0 0 10px #9ecaed;-webkit-box-shadow:0 0 10px #9ecaed;border-color:#9ecaed}.custom-select:after{content:url(../images/dropdown_bluesphere.png);position:absolute;top:0;right:0;bottom:0;line-height:30px;background:0 0;color:#fff;pointer-events:none;border-radius:15px}.inputboxBg,.inputboxerror{padding:.2em 15px;width:96%;height:35px;font-family:Verdana,Geneva,sans-serif;color:#666}.no-pointer-events .custom-select:after{content:none}.inputboxBg{background-image:-webkit-gradient(linear,0 0,0 100%,from(#dbdbdb),to(#dbdbdb));background-image:-ms-linear-gradient(top,#dbdbdb 0,#dbdbdb 100%);font-size:16px;border-radius:15px;border:2px solid #dbdbdb}.inputboxBg:focus{outline:0;border-color:#9ecaed;box-shadow:0 0 5px #9ecaed;-moz-box-shadow:0 0 5px #9ecaed;-webkit-box-shadow:0 0 5px #9ecaed}.inputboxerror{background-image:-webkit-gradient(linear,0 0,0 100%,from(#e9e8e8),to(#e9e8e8));background:-ms-linear-gradient(top,#e9e8e8 0,#e9e8e8 100%);font-size:16px;-moz-border-radius:15px;-webkit-border-radius:15px;border-radius:15px;border:2px solid #b31f14}.blueButton,.greenButton{padding:10px;font-size:16px;margin:0 5px}input[type=submit]:disabled{opacity:.5}.greenButton{cursor:pointer;text-align:center;border:none;-moz-border-radius:15px;-webkit-border-radius:15px;border-radius:5px;color:#fff;text-decoration:none;background-image:-moz-linear-gradient(top,#b3db4f,#6ebb44,#476e3d);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#b3db4f),color-stop(.5,#6ebb44),color-stop(1,#476e3d));background-image:-ms-linear-gradient(top,#b3db4f 0,#6ebb44 50%,#476e3d 100%);-webkit-box-shadow:1px 2px 4px #333;-moz-box-shadow:1px 2px 4px #333;box-shadow:1px 2px 4px #333}.alertButtonblue,.blueButton{background:#5e87b0;text-align:center;color:#fff;text-shadow:0 -1px 1px #145072;cursor:pointer;font-weight:700;text-decoration:none}.greenButton:focus{outline:0;border:none}.blueButton{-moz-border-radius:15px;-webkit-border-radius:15px;border-radius:5px;border:none;background-image:-moz-linear-gradient(top,#0ba4e0,#067ab4,#064a84);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#0ba4e0),color-stop(.5,#067ab4),color-stop(1,#064a84));background-image:-ms-linear-gradient(top,#0ba4e0 0,#067ab4 50%,#064a84 100%);-webkit-box-shadow:1px 2px 4px #333;-moz-box-shadow:1px 2px 4px #333;box-shadow:1px 2px 4px #333}.blueButton:focus{outline:0;border:none}.alertButtonblue{padding:5px 10px;width:100%;font-size:22px;-moz-border-radius:15px;-webkit-border-radius:15px;border:2px solid #131e3b;border-radius:5px;background-image:-moz-linear-gradient(top,#70798d,#162344,#212d4e);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#70798d),color-stop(.5,#212d4e),color-stop(1,#162344));background-image:-ms-linear-gradient(top,#70798d 0,#162344 50%,#212d4e 100%);-webkit-box-shadow:1px 2px 4px #454f69;-moz-box-shadow:1px 2px 4px #454f69;box-shadow:1px 2px 4px #454f69}.alertButtonblue:focus{outline:0;border:none}.loginButtonblue{cursor:pointer;padding:15px 20px;background:#5e87b0;text-align:center;font-weight:700;font-size:19px;border:none;-moz-border-radius:15px;-webkit-border-radius:15px;border-radius:5px;color:#fff;text-shadow:0 -1px 1px #145072;text-decoration:none;background-image:-moz-linear-gradient(top,#69bfe8,#2a8fc7,#077abc);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#69bfe8),color-stop(.5,#2a8fc7),color-stop(1,#077abc));background-image:-ms-linear-gradient(top,#69bfe8 0,#2a8fc7 50%,#077abc 100%);-webkit-box-shadow:1px 2px 4px #333;-moz-box-shadow:1px 2px 4px #333;box-shadow:1px 2px 4px #333}.loginButtonblue:focus{outline:0;border:none}.loginForm{margin:auto;width:350px;padding:20px 40px 20px 20px;-moz-border-radius:20px;-webkit-border-radius:20px;border-radius:20px;background-image:-moz-linear-gradient(top,#fafafa,#fff,#eee);background-image:-webkit-gradient(linear,left top,left bottom,color-stop(0,#fafafa),color-stop(.5,#fff),color-stop(1,#eee));background-image:-ms-linear-gradient(top,#fafafa 0,#fff 50%,#eee 100%);-webkit-box-shadow:0 0 5px #666;-moz-box-shadow:0 0 5px #666;box-shadow:0 0 5px #666}.selectWidth10{width:10%}.selectWidth20{width:20%}.selectWidth30{width:30%}.selectWidth40{width:40%}.selectWidth50{width:50%}.selectWidth60{width:60%}.selectWidth70{width:70%}.selectWidth80{width:80%}.selectWidth90{width:90%}.selectWidth95{width:95%}.selectWidth100{width:100%}.selectWidth15{width:15%}.selectWidth85{width:84.85%}.selectWidth25{width:25%}.selectWidth75{width:74.85%}.selectWidth35{width:35%}.selectWidth65{width:64.85%}.selectWidth45{width:45%}.selectWidth55{width:54.85%}.scanner{background:url(../images/scanner.png) left top no-repeat;width:67px;height:80px}.trashBlack{background:url(../images/trash_black.png) left top no-repeat;height:22px;width:22px}.errorMessage,.warningMessage{height:auto;padding-left:60px}.warningMessage{background:url(../images/notice_orange.png) left top no-repeat;min-height:30px}.errorMessage{background:url(../images/error_icon.png) left top no-repeat;min-height:40px;color:#b31f14;font-size:19px}.available,.closeX,.roundedButtoninfo{height:25px;width:25px}.roundedButtoninfo{cursor:pointer;background:url(../images/info.png) left top no-repeat;border:none}.closeX{background:url(../images/Close_white.png) left top no-repeat}.available{background:url(../images/available.png) left top no-repeat}.floatLeft{float:left}.floatRight{float:right}.clear{clear:both}.spacer{margin-bottom:5px}.spacer1{margin-bottom:10px}.spacer2{margin-bottom:20px}.orangeText{color:#ff7200;font-size:16px}.blueText{color:#067ab4;font-size:16px}.redText{color:#b31f14;font-size:16px}.boldText{font-weight:700}.instructionText{color:#666;font-style:italic;font-size:13px}.omblueLine{background-color:#338DC0;height:1px}.alignLeft{text-align:left}.alignCenter{text-align:center}.alignRight{text-align:right}.greybgContent{background-color:#f0f0f0}.padding10{padding:10px}.padding15{padding:15px}.paddingTop5{padding-top:5px}.paddingLeft{padding-left:15px}.paddingLeft10{padding-left:10px}.marginLeft20{margin-left:20px}.alertboxContent{font-size:24px;color:#fff;text-align:center;text-shadow:0 -2px 2px #04070e;text-decoration:none}#alertBox{margin:auto auto auto -23px;border:4px solid #dfe1e6;padding:20px;background:#162344;width:100%;border-radius:15px;-moz-border-radius:15px;-webkit-border-radius:15px}.marginTop15{margin-top:15px}.dashedBorderRed{border:2px dashed #ea211c}</style>



</head>
<body>
<form action="/ATnTProject/logon.do" method="post">
 <br>
  Username : <input name="userId" id="userId" type="text"   placeholder="ATTUID">
  <br>
 <br>
  Password : <input name="password" type="password" placeholder="Password">
  <br><br>
 <input class="loginButtonblue" id="" type="submit" value="Login" />
</form> 
</body>
</html>