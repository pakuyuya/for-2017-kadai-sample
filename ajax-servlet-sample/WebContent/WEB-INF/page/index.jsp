<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ajaxテスト用サンプル</title>
  <meta charset="UTF-8" />
  <script src="vendor/jquery-3.2.1.min.js"></script>
  <script defer src="js/index.js"></script>
</head>
<body>

<fieldset>
 <legend>従業員情報をAjaxで取得する</legend>
 <div>
   ID：<input type="text" id="employer_id" value="1">
 </div>
 <div>
   <button type="button" onclick="clickGetEmployer()">取得する</button>
 </div>
</fieldset>

<h3>取得した従業員情報</h3>
<table>
  <tr>
    <th>ID</th>
    <td><span id="result-id"></span></td>
  </tr>
  <tr>
    <th>苗字</th>
    <td><span id="result-family_name"></span></td>
  </tr>
  <tr>
    <th>名前</th>
    <td><span id="result-first_name"></span></td>
  </tr>
  <tr>
    <th>勤務開始日</th>
    <td><span id="result-since"></span></td>
  </tr>
</table>
</body>
</html>