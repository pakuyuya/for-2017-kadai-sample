'use strict';

/**
 * 従業員取得ボタンを押下したときに発火するイベント
 */
function clickGetEmployer() {
    var employer_id = $('#employer_id').val();
    loadAjaxEmployer(employer_id);
}

/**
 * ajaxでサーバーから従業員情報を取得し、結果を画面に反映させます。<br>
 *
 * @param emplyoer_id 従業員ID
 */
function loadAjaxEmployer(employer_id) {
    var param = { id : employer_id};
    var url = 'ajax/getEmployer' + '?' + toQueryString(param);

    // JQueryのAjax用ユーティリティメソッド
    // JavaScriptでページ遷移を起こさずにリクエストを投げる。（Ajax)
    $.ajax({
        method: 'GET',    // リクエストメソッド
        url : url,        // URL
        dataType: 'json', // doneで受け取るレスポンスの種別
    }).done(function(json) {
        // レスポンスが200で帰ってくると、doneに指定したfunctionが遅延発火する
        renderEmployer(json);
    }).fail(function(error) {
        // レスポンスが何かしらのエラーコードで返ってきたりフォーマットがおかしかった場合などは
        // failに指定したfunctionが遅延発火する
    	console.error(error);
        alert('エラーが発生しました。開発者ツールのコンソールウィンドウにエラーを出力。');
    });

    // リクエストの返答を待たずに、とりあえず呼び出したもともとのコードは継続して走る
}

/**
 * 従業員情報を画面に反映する
 *
 * @param employer 従業員情報のモデル
 */
function renderEmployer(employer) {
    if (!employer) {
        return;
    }

    $('#result-id').text(employer.id ? employer.id : '');
    $('#result-family_name').text(employer.family_name ? employer.family_name : '');
    $('#result-first_name').text(employer.first_name ? employer.first_name : '');
    $('#result-since').text(employer.since ? employer.since : '');
}

/**
 * JavaScriptオブジェクトをGETリクエストのクエリ文字に置き換える
 *
 * @param query javascriptオブジェクト
 * @returns クエリ―文字
 */
function toQueryString(query) {
	var q = '';
	for (var k in query) {
		q += '&' + encodeURI(k) + '=' + encodeURI(query[k]);
	}

	return q !== '' ? q.substring(1) : '';
}
