# このアプリは「Spring BootアプリをDockerイメージ化し、GitHub ActionsからOIDCでAWSへ認証し、ECRへpushして、ECS Fargateへデプロイする」構成

> [!success]
> 
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
|                 |               |                                 |
| --------------- | ------------- | ------------------------------- |
| **要素**          | **役割**        | **自分用の理解**          |
| Spring Boot     | Web API本体     | ControllerがHTTPリクエストを受けてJSONを返す |
| Dockerfile      | アプリの実行環境定義    | Java 21入りの実行箱を作る設計書             |
| ECR             | Dockerイメージ置き場 | MavenリポジトリのDocker版に近い           |
| ECS Fargate     | コンテナ実行環境      | サーバを直接管理せずコンテナを動かす              |
| Task Definition | コンテナ起動設定      | Javaの起動引数・ポート・メモリ設定に近い          |
| ECS Service     | 指定数のタスクを維持    | アプリプロセスを常に1個以上動かす管理役            |
| ALB             | 外部公開入口        | HTTPリクエストをECSタスクへ振り分ける入口        |
| GitHub Actions  | CI/CD実行基盤     | push/PRをきっかけにコマンドを自動実行する        |

