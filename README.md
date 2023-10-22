# 映画情報管理アプリケーション

***

## 概要

### 映画情報を管理する機能をもったAPIの作成

* ### Read処理の実装
* ### Create処理の実装(今後)
* ### Update処理の実装(今後)
* ### Delete処理の実装(今後)

***

## Read処理の実装

### 1.テーブルからレコードを全件取得できるように実装

映画情報に関するDBから全ての情報を獲得できるように実装。<br>

#### ◽️テーブル(MySQL)

<img width="710" alt="スクリーンショット 2023-10-21 23 15 28" src="https://github.com/yamahiro20639/Assignment10/assets/144509349/99526dbd-2401-4609-bdf4-4a8829abc606">


#### ◽️動作確認<br>

全件獲得できている。
<img width="1680" alt="スクリーンショット 2023-10-22 15 35 28" src="https://github.com/yamahiro20639/Assignment10/assets/144509349/3da36a39-6fad-4aa3-9e8e-8b54e9ba1108">
<img width="1680" alt="スクリーンショット 2023-10-22 15 35 36" src="https://github.com/yamahiro20639/Assignment10/assets/144509349/39f088c1-0bda-4778-862a-a3be2a13dc53">


### 2.ID検索から特定のレコードを取得できるように実装

パスパラメーター部分を`id`に設定して、ID指定する事で該当のレコードを獲得するように実装。<br>
また`id`に存在しない値をリクエストした場合はエラー404で返すように例外処理を実装。

#### ◽️動作確認<br>

MySQLに存在するIDを指定した場合、該当の映画情報を獲得できた。
<img width="1680" alt="スクリーンショット 2023-10-22 15 37 03" src="https://github.com/yamahiro20639/Assignment10/assets/144509349/46c478d2-73ed-49f9-abe0-f613b7251f22">
<img width="1680" alt="スクリーンショット 2023-10-22 15 37 11" src="https://github.com/yamahiro20639/Assignment10/assets/144509349/c532f2f0-1c20-4bff-bdac-2c6261dc1e08">


存在しないIDを指定した場合、エラーコード404と関連メッセージが返ってきた。
<img width="1680" alt="スクリーンショット 2023-10-22 15 37 18" src="https://github.com/yamahiro20639/Assignment10/assets/144509349/80744da4-6d1c-4218-bdcf-ca72ce125c68">
