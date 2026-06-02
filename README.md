# このアプリは

## Spring Initializr で作成したバックエンド側の構成

項目	設定値
Project	Maven
Language	Java
Spring Boot	デフォルトの安定版
Group	com.example
Artifact	github-actions-demo
Name	github-actions-demo
Package name	com.example.githubactionsdemo
Packaging	Jar
Java	21

### Dependenciesに追加
Spring Web


## 今回作成する内容
Spring Bootアプリの作成
Controller / テスト / Checkstyle設定
Dockerfile / .dockerignore
ci.yml
deploy.yml
push / pull_request / workflow_dispatch
ECRへのDockerイメージbuild・push
ECS Fargateへの自動デプロイ
OIDC認証のIAM信頼ポリシー例
GitHub Secrets / Variables
permissions設定
条件分岐 / matrix strategy / concurrency
保護ブランチと必須チェック
Basic認証を使う外部サービス接続例
成功ケース / 失敗ケース
