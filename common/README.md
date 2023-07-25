# common

## 初回インストール
まず`common`をmvnインストールしよう  
`common`にはWEB,API,BATCHの各プロジェクトのコンパイルに必要となる共通クラス等が含まれているため、一番初めに実施する  

```
コマンドプロンプトを起動し、
`spring-boot2-system\common`ディレクトリ直下に移動する

以下のinstallコマンドを実行し、ローカルリポジトリにcommonプロジェクトをインストールする
mvnw.cmd install

例えば、以下のローカルリポジトリがインストール先となる
C:\Users\ユーザ\.m2\repository\com\example\orange\common\0.0.1-SNAPSHOT\common-0.0.1-SNAPSHOT.jar
```

## 変更したら再度インストール

commonの資材を変更した場合、再度installを行わないと、WEB,API,BATCHの各プロジェクトへ資材が反映されない

## バージョン管理

バージョン番号をカウントアップして、バージョンを管理する

```
スナップショット
common-0.0.1-SNAPSHOT.jar
common-0.0.2-SNAPSHOT.jar
common-0.0.3-SNAPSHOT.jar
common-1.0.0-SNAPSHOT.jar
common-1.0.1-SNAPSHOT.jar
common-1.0.2-SNAPSHOT.jar

非スナップショット
common-0.0.1.jar
common-0.0.2.jar
common-0.0.3.jar
common-1.0.0.jar
common-1.0.1.jar
common-1.0.2.jar

混在
common-0.0.1-SNAPSHOT.jar
common-0.0.2-SNAPSHOT.jar
common-0.0.3-SNAPSHOT.jar
common-1.0.0.jar
common-1.0.1-SNAPSHOT.jar
common-1.0.2-SNAPSHOT.jar
```

バージョンの種類と使い分け  
https://maven3.kengo-toda.jp/deploy/snapshot-and-stable  

バージョン表記の各数字の意味をイラストで理解する  
https://dev.classmethod.jp/articles/versoning-with-pictures/  

## リポジトリ

オフライン環境構築 Nexus Repository3編  
https://qiita.com/kannkyo/items/5195069c65350b60edd9  
