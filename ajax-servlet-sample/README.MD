## What's this?

* ServletとJSONベースのAjaxを使った簡単なサンプルです。


### 解説

* Ajaxは、ページ遷移をさせずにJavaScript　⇔ Webサーバー間で通信をやり取りする技術です

* JSONは、JavaScriptの配列や連想配列のリテラルフォーマットをそのまま流用したデータフォーマットです。
  ```
  {
      'id' : 1234589,
      'posted' : '2017/01/05T10:30:42'
  }
  ```

### サンプルソースで見てほしいところ

src/org/ppa/ajaxsmp/servlet/page/IndexServlet　→　indexページ。
src/org/ppa/ajaxsmp/servlet/ajax/AjaxEmployerServlet　→　Ajax用のWebAPI。リクエストを受けてJSONを出力する。

WebContent/js/index.js　→　index.jspとセットのJavaScriptコード。