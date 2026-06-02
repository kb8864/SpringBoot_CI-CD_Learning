# このアプリは「Spring BootアプリをDockerイメージ化し、GitHub ActionsからOIDCでAWSへ認証し、ECRへpushして、ECS Fargateへデプロイする」構成

> [!success]
> PR時: Mavenテストと静的解析だけ実行する。AWSへはデプロイしない。
> 
> mainへのpush時: テスト・静的解析が成功した場合のみ、Docker build、ECR push、ECS Fargate deployを実行する。
> 
> 手動実行: workflow_dispatchで環境を指定してデプロイできるようにする。
> 
> AWS認証: 長期アクセスキーをGitHub Secretsに置かず、OIDCで一時的にAWSロールを引き受ける。
> 
> 保護ブランチ: mainへ直接pushせず、PRの必須チェックを通してからmergeする。


## Spring Initializr で作成したバックエンド側の構成

項目：	設定値

Project：	Maven

Language：	Java

Spring Boot	：4.0.6

Group	：com.example.cicd

Artifact:	github-actions-cicd

Name: github-actions-cicd

Package name:	com.example.githubactionscicd

Packaging:	Jar

Java:	21

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
