# 간단한 CRUD

## 목차
- [개요](#개요)
- [목적](#목적)
- [진행](#진행)
- [환경](#환경)
- [설명](#설명)

## 개요
게시판, 댓글의 CRUD를 구현했습니다.</br>

## 목적
- Spring 프레임워크의 이해도를 높입니다.

## 진행
- 기간: 3주
- 개인 프로젝트

## 환경
- 언어: Java
- 프레임워크: Spring

## 설명
### 페이지 접속
- 127.0.0.0:8080/home으로 접속합니다.

### 네비게이션 바
- 상단의 네비게이션 바를 통해 다른 페이지로 이동할 수 있습니다.
- Test, Home은 /home으로, Articles는 /articles로 이동할 수 있습니다.

### 모든 게시글 조회
![image](https://github.com/user-attachments/assets/25c7c035-1914-4840-96f6-3b36768bcf56)
- /articles에서 모든 게시글을 조회할 수 있습니다.
- 게시글 제목을 클릭하여 내용을 확인할 수 있습니다.
- 글쓰기 버튼을 클릭하여 새로운 게시글을 작성할 수 있습니다.

### 특정 게시글 조회
![image](https://github.com/user-attachments/assets/a727d702-09e2-4c00-80bf-9ffab06cd4f7)
- 전체글 버튼을 클릭하여 /articles로 이동할 수 있습니다.
- 수정, 삭제 버튼을 클릭하여 게시글을 수정, 삭제할 수 있습니다.

### 댓글
![image](https://github.com/user-attachments/assets/28ad8f58-cd66-4c67-afbc-aa04d83947eb)
- 특정 게시글에 있는 모든 댓글을 조회할 수 있습니다.
- 수정, 삭제 버튼을 클릭하여 게시글을 수정, 삭제할 수 있습니다.

![image](https://github.com/user-attachments/assets/6f43a223-fbeb-44df-8463-b1c13865cda3)
- 닉네임, 내용을 입력하고, 등록 버튼을 클릭하여 댓글을 작성할 수 있습니다.
